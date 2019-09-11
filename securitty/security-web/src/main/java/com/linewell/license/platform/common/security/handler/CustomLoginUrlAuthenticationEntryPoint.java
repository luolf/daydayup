package com.linewell.license.platform.common.security.handler;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *  处理未登录时认证或授权的处理
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-16
 * Time 16:32
 */

public class CustomLoginUrlAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint {

    public CustomLoginUrlAuthenticationEntryPoint(String loginFormUrl) {
        super(loginFormUrl);
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        // redirect to login page. Use https if forceHttps true
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        StringBuffer sb = new StringBuffer();
        sb.append("{\"status\":\"error\",\"msg\":\"");
        sb.append("未登陆!"+authException.getMessage());
        sb.append("\"}");
        out.write(sb.toString());
        out.flush();
        out.close();

    }
}
