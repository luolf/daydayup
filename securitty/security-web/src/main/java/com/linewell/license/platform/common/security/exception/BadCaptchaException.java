package com.linewell.license.platform.common.security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * 图片验证码错误
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-26
 * Time 16:02
 */
public class BadCaptchaException extends AuthenticationException {

    public BadCaptchaException(String msg, Throwable t) {
        super(msg, t);
    }

    public BadCaptchaException(String msg) {
        super(msg);
    }
}
