package com.linewell.license.platform.common.security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * 非法token
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-26
 * Time 16:02
 */
public class TokenIllegalException extends AuthenticationException {

    public TokenIllegalException(String msg, Throwable t) {
        super(msg, t);
    }

    public TokenIllegalException(String msg) {
        super(msg);
    }
}
