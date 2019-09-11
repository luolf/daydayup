package com.linewell.license.platform.common.security.facade.constants;

/**
 * 认证方式枚举
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-21
 * Time 13:58
 */
public enum AuthenModeType {

    /**
     * 中台用户密码、短信码认证
     */
    MID_USER_PHONE_PASSWORD( "midUserPhonePassword"),

    /**
     * 用户名密码认证
     */
    USERNAME_PASSWORD( "usernamePassword"),
    /**
     * 手机短信码认证
     */
    MOBILE_PHONE("mobilePhone"),

    /**
     * 双重认证
     */
    TWO_FACTOR_AUTHEN("twoFactorAuthen"),

    /**
     * USB KEY 认证
     */
    USBKEY("usbKey"),

    /**
     * 第三方应用oauth2 认证
     */
    OAUTH2("oauth2");
    private final String value;

    AuthenModeType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
