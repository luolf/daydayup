package com.linewell.license.platform.common.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.linewell.license.platform.common.security.RespBean;
import com.linewell.license.platform.common.security.facade.dto.UserPrincipalDto;
import com.linewell.license.platform.common.security.util.ConvertUtil;
import com.linewell.license.platform.common.security.util.JwtTokenUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 认证成功处理器
 * 颁发token
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-13
 * Time 9:08
 */
@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest req,
                                        HttpServletResponse resp,
                                        Authentication auth) throws IOException {
        resp.setContentType("application/json;charset=utf-8");
//        RespBean respBean = RespBean.ok("登录成功!", SecurityContextHolder.getContext().getAuthentication());
//        UserPrincipalDto userPrincipalDto=(UserPrincipalDto)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Object principal= SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(auth);
        System.out.println(ConvertUtil.beanToMap(principal));
        String token=JwtTokenUtil.generalToken(ConvertUtil.beanToMap(principal));
        ObjectMapper om = new ObjectMapper();
        PrintWriter out = resp.getWriter();
        out.write(om.writeValueAsString(token));
        out.flush();
        out.close();
    }
}
