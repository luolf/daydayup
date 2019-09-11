package com.linewell.license.platform.common.security.handler;

import com.linewell.license.platform.common.model.constants.security.SecurityConstants;
import com.linewell.license.platform.common.model.session.SessionInfo;
import com.linewell.license.platform.common.security.config.SecurityConfigBean;
import com.linewell.license.platform.common.security.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-29
 * Time 19:57
 */
@Component
public class CustomLogoutHandler implements LogoutHandler {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    SecurityConfigBean securityConfigBean;
    @Override
    public void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) {

        String authHeader = httpServletRequest.getHeader(securityConfigBean.getTokenHeader());
           try {
               authHeader.startsWith(securityConfigBean.getTokenPrefix());
               final String authToken = authHeader.substring(securityConfigBean.getTokenPrefix().length());
              SessionInfo sessionInfo= JwtTokenUtil.parseToken(authToken);
               redisTemplate.delete(SecurityConstants.REDIS_TOKEN+sessionInfo.getUserId());
           }catch(Exception e){

           }


    }
}
