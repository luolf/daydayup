package com.linewell.license.platform.common.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.linewell.license.platform.common.model.constants.security.SecurityConstants;
import com.linewell.license.platform.common.model.result.ResultBaseModel;
import com.linewell.license.platform.common.model.session.SessionInfo;
import com.linewell.license.platform.common.security.authen.JwtUserDetails;
import com.linewell.license.platform.common.security.config.SecurityConfigBean;
import com.linewell.license.platform.common.security.dto.AuthenResultDto;
import com.linewell.license.platform.common.security.dto.MidToken;
import com.linewell.license.platform.common.security.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

/**
 * 认证成功处理器
 * 颁发token
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-13
 * Time 9:08
 */
@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    SecurityConfigBean securityConfigBean;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest req,
                                        HttpServletResponse resp,
                                        Authentication auth) throws IOException {
        resp.setContentType("application/json;charset=utf-8");
        JwtUserDetails principal = (JwtUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        SessionInfo sessionInfo = JwtTokenUtil.generalSessionInfo(principal);
        MidToken midToken = JwtTokenUtil.generalMidToken(sessionInfo);

        //记录到redis,在注销、作废、刷新的地方都有互动
        String reflushTokenId=JwtTokenUtil.getTokenId(midToken.getReflushtoken());
        redisTemplate.opsForValue().set(SecurityConstants.REDIS_TOKEN+sessionInfo.getUserId(),reflushTokenId,securityConfigBean.getReflushTokenExpiredTime(),TimeUnit.MINUTES);

        System.out.println(JwtTokenUtil.parseToken(midToken.getToken()));
        System.out.println(JwtTokenUtil.parseToken(midToken.getReflushtoken()));

        ResultBaseModel<AuthenResultDto> resultBaseModel = new ResultBaseModel<>("200", "Authentication success", new AuthenResultDto(midToken, principal.isPasswdExpired()));
        ObjectMapper om = new ObjectMapper();
        PrintWriter out = resp.getWriter();

        out.write(om.writeValueAsString(resultBaseModel));
        out.flush();
        out.close();
    }
}
