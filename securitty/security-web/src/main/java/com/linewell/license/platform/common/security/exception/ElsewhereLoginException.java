package com.linewell.license.platform.common.security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * 它处登录
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-26
 * Time 16:02
 */
public class ElsewhereLoginException extends AuthenticationException {

    public ElsewhereLoginException(String msg, Throwable t) {
        super(msg, t);
    }

    public ElsewhereLoginException(String msg) {
        super(msg);
    }
}
