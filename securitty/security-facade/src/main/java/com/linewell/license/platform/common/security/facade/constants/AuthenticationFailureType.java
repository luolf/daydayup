package com.linewell.license.platform.common.security.facade.constants;

/**
 * 认证失败原因枚举
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-21
 * Time 14:30
 */
public enum AuthenticationFailureType {


    /**
     * 账户名或者密码输入错误
     */
    USERNAME_PASSWD_ERROR("usernamePasswdError"),
    /**
     * 账户过期
     */
    AccountExpired("accountExpired"),
    /**
     * 账户被禁用
     */
    DISABLE("disable"),
    /**
     * 账户被锁定
     */
    ACCOUNTLOCKED("accountLocked"),
    /**
     * 密码过期
     */
    PASSWD_EXPIRED("passwdExpired"),

    /**
     * 图片验证码错误
     */
    CAPTCHA_ERROR("captchaError"),
    /**
     * 短信验证码错误
     */
    SMS_CODE_ERROR("smsCodeError");
    private final String value;
    AuthenticationFailureType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
