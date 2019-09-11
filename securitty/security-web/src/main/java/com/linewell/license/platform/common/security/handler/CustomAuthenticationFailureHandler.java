package com.linewell.license.platform.common.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.linewell.license.platform.common.security.RespBean;
import com.linewell.license.platform.common.security.exception.BadCaptchaException;
import com.linewell.license.platform.common.security.exception.BadSmsCodeException;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-13
 * Time 9:06
 */
@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest req,
                                        HttpServletResponse resp,
                                        AuthenticationException e) throws IOException {
        resp.setContentType("application/json;charset=utf-8");
        RespBean respBean = null;
        if (e instanceof BadCredentialsException ||
                e instanceof UsernameNotFoundException) {
            respBean = RespBean.error("账户名或者密码输入错误!");
        } else if (e instanceof LockedException) {
            respBean = RespBean.error("账户被锁定，请联系管理员!");
        } else if (e instanceof CredentialsExpiredException) {
            respBean = RespBean.error("密码过期，请联系管理员!");
        } else if (e instanceof AccountExpiredException) {
            respBean = RespBean.error("账户过期，请联系管理员!");
        } else if (e instanceof DisabledException) {
            respBean = RespBean.error("账户被禁用，请联系管理员!");
        } else if (e instanceof BadSmsCodeException) {
            respBean = RespBean.error("请输入正确短信验证码!");
        } else if (e instanceof BadCaptchaException) {
            respBean = RespBean.error("请输入正确图片验证码!");
        } else {
            respBean = RespBean.error("登录失败!");
        }

        resp.setStatus(401);
        ObjectMapper om = new ObjectMapper();
        PrintWriter out = resp.getWriter();
        out.write(om.writeValueAsString(respBean));
        out.flush();
        out.close();
    }
}
