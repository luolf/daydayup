package com.linewell.license.platform.common.security.filter;

import com.linewell.license.platform.common.model.session.SessionContext;
import com.linewell.license.platform.common.model.session.SessionInfo;
import com.linewell.license.platform.common.security.config.SecurityConfigBean;
import com.linewell.license.platform.common.security.service.UserCheckService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * 每次请求会先验证token有效性，验证通过生成UsernamePasswordAuthenticationToken放到共享池内
 * UrlAccessDecisionManager.decide 会判断这个Authentication（UsernamePasswordAuthenticationToken）
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-15
 * Time 17:55
 */

public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    protected final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    UserCheckService userCheckService;
    @Autowired
    SecurityConfigBean securityConfigBean;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain) throws ServletException, IOException {
        String authHeader = request.getHeader(securityConfigBean.getTokenHeader());

        /**
         * 初始化，清除
         */
        SessionContext.setSessionInfo(null);
        SessionContext.setToken(null);

        if (authHeader != null && authHeader.startsWith(securityConfigBean.getTokenPrefix())) {

            final String authToken = authHeader.substring(securityConfigBean.getTokenPrefix().length());
            SessionInfo sessionInfo = userCheckService.checkUser(authToken);
            if (sessionInfo != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        sessionInfo.getUserName(), null, listUserGrantedAuthorities(sessionInfo.getRoleIdList()));
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(
                        request));
                logger.info("authenticated user " + sessionInfo.getUserName() + ", setting security context");
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
            SessionContext.setSessionInfo(sessionInfo);
            SessionContext.setToken(authToken);

        }

        chain.doFilter(request, response);
    }

    protected Set<GrantedAuthority> listUserGrantedAuthorities(Set<Long> roles) {
        Set<GrantedAuthority> authorities = new HashSet<>();
        if (null == roles || roles.isEmpty()) {
            return authorities;
        }
        for (Long roleId : roles) {
            authorities.add(new SimpleGrantedAuthority(roleId.toString()));
        }
        return authorities;
    }
}
