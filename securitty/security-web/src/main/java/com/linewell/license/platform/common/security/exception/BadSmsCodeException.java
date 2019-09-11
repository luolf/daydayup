package com.linewell.license.platform.common.security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * 短信码错误
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-26
 * Time 16:01
 */
public class BadSmsCodeException extends AuthenticationException {

    public BadSmsCodeException(String msg, Throwable t) {
        super(msg, t);
    }

    public BadSmsCodeException(String msg) {
        super(msg);
    }
}

