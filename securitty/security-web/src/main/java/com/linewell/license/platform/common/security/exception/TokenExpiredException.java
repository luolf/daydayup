package com.linewell.license.platform.common.security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * 过期
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-26
 * Time 16:02
 */
public class TokenExpiredException extends AuthenticationException {

    public TokenExpiredException(String msg, Throwable t) {
        super(msg, t);
    }

    public TokenExpiredException(String msg) {
        super(msg);
    }
}
