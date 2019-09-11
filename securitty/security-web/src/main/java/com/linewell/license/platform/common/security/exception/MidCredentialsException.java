package com.linewell.license.platform.common.security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-26
 * Time 15:58
 */
public class MidCredentialsException extends AuthenticationException {

    public MidCredentialsException(String msg, Throwable t) {
        super(msg, t);
    }

    public MidCredentialsException(String msg) {
        super(msg);
    }
}
