package com.linewell.license.platform.common.security.filter;

import com.linewell.license.platform.common.security.token.MobileCodeAuthenticationToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 过滤出手机短信验证码的认证方式
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-14
 * Time 17:26
 */
public class MobileCodeAuthenticationProcessingFilter extends AbstractAuthenticationProcessingFilter {

    @Value("${license.security.sms.phoneNumParameter:mobile}")
    private String mobileParameter;
    @Value("${license.security.sms.codeParameter:code}")
    private String codeParameter;


    private boolean postOnly = true;
//    public MobileCodeAuthenticationProcessingFilter() {
//        this(null);
//    }

    public MobileCodeAuthenticationProcessingFilter(@Value("${license.security.sms.loginProcessingUrl:/mobileLogin}") String loginProcessingUrl) {
        super(new AntPathRequestMatcher( loginProcessingUrl, "POST"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException{
        if (postOnly && !request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException(
                    "Authentication method not supported: " + request.getMethod());
        }

        String mobile = obtainMobile(request);
        String code = obtainCode(request);

        if (mobile == null) {
            mobile = "";
        }

        if (code == null) {
            code = "";
        }

        mobile = mobile.trim();
        code = code.trim();

        AbstractAuthenticationToken authRequest = new MobileCodeAuthenticationToken(mobile, code);

        // Allow subclasses to set the "details" property
        setDetails(request, authRequest);

        return this.getAuthenticationManager().authenticate(authRequest);
    }

    protected String obtainMobile(HttpServletRequest request) {
        return request.getParameter(mobileParameter);
    }

    protected String obtainCode(HttpServletRequest request) {
        return request.getParameter(codeParameter);
    }

    protected void setDetails(HttpServletRequest request,
                              AbstractAuthenticationToken authRequest) {
        authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
    }

}
