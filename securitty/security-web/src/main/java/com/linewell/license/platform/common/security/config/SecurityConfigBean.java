package com.linewell.license.platform.common.security.config;

import com.linewell.license.platform.common.security.util.JwtTokenUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-13
 * Time 10:09
 */

@Component
//@PropertySource(value = { "securityConfig.properties" })
@Getter
@Setter
@ToString
public class SecurityConfigBean {
    /**
     * 表单登录页面地址
     */
    @Value("${license.security.form.loginPage:/login.html}")
    private String loginPage;

    /**form表单POST请求url提交地址，默认为/login
     * 指定让UsernamePasswordAuthenticationFilter拦截器拦截的路径
     */
    @Value("${license.security.form.loginProcessingUrl:/login}")
    private String loginProcessingUrl;

    /**
     * form表单用户名参数名
     */
    @Value("${license.security.form.usernameParameter:username}")
    private String usernameParameter;

    /**
     * form表单密码参数名
     */
    @Value("${license.security.form.passwordParameter:passwrod}")
    private String passwordParameter;
    @Value("${license.security.form.logoutUrl:/logout}")
    private String logoutUrl;

    /**
     *   accessToken 过期时间，，使用时要转换为秒
     */
    @Value("#{${license.security.jwt.token.tokenExpired:60}*60}")
    public   long tokenExpiredTime ;

    /**
     *   reflushToken的过期时间，，使用时要转换为秒
     */
    @Value("#{${license.security.jwt.token.reflushTokenExpired:120}*60}")
    public   long reflushTokenExpiredTime ;
    /**
     * 选择了记住我之后的过期时间，默认为7天，使用时要转换为秒
     */
    @Value("#{${license.security.jwt.tokenExpiredRemember:7}*60*60*24}")
    private   long tokenExpiredTimeRemember;

    /**
     * accessToken 加密密钥
     */
    @Value("${license.security.jwt.secret:bGluZXdlbGwtbGljZW5zZS1yb28=}")
    private String jwtSecret;
    /**
     * token前缀
     */
    @Value("${license.security.jwt.tokenPrefix:Bearer }")
    private   String  tokenPrefix ;

    /**
     * token在浏览器端header存放位置
     */
    @Value("${license.security.jwt.tokenHeader:Authorization}")
    private   String  tokenHeader ;

    /**
     * 邮箱认证方式开启
     */
    @Value("${license.security.authentication.modes.email:false}")
    private   boolean  enableEmail ;


    /**
     * 手机短信验证方式开启
     */
    @Value("${license.security.authentication.modes.sms:false}")
    private   boolean  enableSms ;
    /**手机短信验证方式请求url提交地址，默认为/mobilLogin
     * 指定让UsernamePasswordAuthenticationFilter拦截器拦截的路径
     */
    @Value("${license.security.sms.loginProcessingUrl:/mobileLogin}")
    private String mobileLoginProcessingUrl;


    /**
     * 中台登录配置
     */
    @Value("${license.mid.security.account.loginProcessingUrl:/midLogin}")
    private String midLoginProcessingUrl;

    /**
     * 中台登出配置
     */
    @Value("${license.mid.security.form.logoutUrl:/logout}")
    private String midLogoutUrl;
    /**
     * 忽略处理的url或静态资源访问
     */
    @Value("${license.security.web.ignores:/login}")
    private   String[]  webIgnores ;

    /**
     * BCryptPasswordEncoder加密强度
     */
    @Value("${license.security.bcrypt.strength:10}")
    private int bcryptStrength;


    /**
     * 失败次数锁定条件
     */
    @Value("${license.security.handler.failedTimes4Lock:3}")
    private   Integer  failedTimes4Lock ;

    /**
     * 图片验证码功能开启
     */
    @Value("${license.security.handler.isCaptcha:false}")
    private   Boolean  isCaptcha ;
    /**
     * 短信验证码功能开启
     */
    @Value("${license.security.handler.isSmsCode:false}")
    private   Boolean  isSmsCode ;
    /**
     * 图片验证码功能开启情况下，认证失败次数满足阀值，前端强制开启图片验证码
     */
    @Value("${license.security.handler.failedTimes4Captcha:3}")
    private   Integer  failedTimes4Captcha ;

    /**
     * 锁定时长，单位分钟
     */
    @Value("${license.security.handler.lockPeriod:30}")
    private   Integer  lockPeriod ;


    @PostConstruct
    public void init(){
        System.out.println(this);
        JwtTokenUtil.setConfigInfo(this);
    }

}
