package com.linewell.license.platform.common.security.filter;

import com.linewell.license.platform.common.security.bean.MidLoginInfoBo;
import com.linewell.license.platform.common.security.token.MidAuthenticationToken;
import com.linewell.license.platform.common.security.token.MobileCodeAuthenticationToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.Assert;

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
public class MidAuthenticationProcessingFilter extends AbstractAuthenticationProcessingFilter {
    /**
     * 手机号参数
     */
    @Value("${license.mid.security.sms.phoneNumParameter:mobile}")
    private String phoneNumParameter;
    /**
     * 手机短信验证码参数
     */
    @Value("${license.mid.security.sms.smsCodeParameter:smsCode}")
    private String smsCodeParameter;
    /**
     * 用户账号参数
     */
    @Value("${license.mid.security.account.accountParameter:account}")
    private String accountParameter;
    /**
     * 用户密码参数
     */
    @Value("${license.mid.security.account.passwdParameter:password}")
    private String passwdParameter;
    /**
     * 图片验证码参数
     */
    @Value("${license.mid.security.captchaParameter:captcha}")
    private String captchaParameter;


    /**
     * 图片验证开启参数
     */
    @Value("${license.mid.security.isCaptchaParameter:isCaptcha}")
    private String isCaptchaParameter;
    private boolean postOnly = true;

    public MidAuthenticationProcessingFilter() {
        this("/midLogin");
    }

    public MidAuthenticationProcessingFilter(String loginProcessingUrl) {
        super(new AntPathRequestMatcher( loginProcessingUrl, "POST"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException{
        if (postOnly && !request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException(
                    "Authentication method not supported: " + request.getMethod());
        }
//        String   phoneNum  =request.getParameter(phoneNumParameter);
        String   smsCode =request.getParameter(smsCodeParameter);
        String   account  =request.getParameter(accountParameter);
        String   passwd  =request.getParameter(passwdParameter);
        String   captcha  =request.getParameter(captchaParameter);
        String   isCaptcha  =request.getParameter(isCaptchaParameter);
        String  captchaId=request.getHeader("Captcha-ID");


        smsCode = preStringdeal(smsCode);
        account = preStringdeal(account);
        passwd = preStringdeal(passwd);
        captcha = preStringdeal(captcha);
        isCaptcha= preStringdeal(isCaptcha);

//        MidLoginInfoBo loginInfoBo=new MidLoginInfoBo(phoneNum,smsCode,account,passwd,captcha);
        MidLoginInfoBo loginInfoBo=new MidLoginInfoBo(Boolean.valueOf(isCaptcha),smsCode,account,passwd,captcha,captchaId);

        AbstractAuthenticationToken authRequest = new MidAuthenticationToken(loginInfoBo,loginInfoBo.getPasswd());

        // Allow subclasses to set the "details" property
        setDetails(request, authRequest);

        return this.getAuthenticationManager().authenticate(authRequest);
    }
   protected String preStringdeal(String str){
       if (str == null) {
           str = "";
       }
       return str.trim();
   }


    protected void setDetails(HttpServletRequest request,
                              AbstractAuthenticationToken authRequest) {
        authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
    }

}
