package com.linewell.license.platform.security.facade.constants;

/**
 * 被认证者类型
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-21
 * Time 13:58
 */
public enum AuthenticationPrincipalType {
    /**
     * 普通用户
     */
    NORMAL_USER( "normalUser"),
    /**
     * 手机号
     */
    MOBILE_PHONE_NUM("mobilePhoneNum"),

    /**
     * 第三方应用、客户端
     */
    CLIENT("client");
    private final String value;

    AuthenticationPrincipalType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
