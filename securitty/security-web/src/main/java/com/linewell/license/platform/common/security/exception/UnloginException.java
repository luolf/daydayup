package com.linewell.license.platform.common.security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * 未登录
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-26
 * Time 16:02
 */
public class UnloginException extends AuthenticationException {

    public UnloginException(String msg, Throwable t) {
        super(msg, t);
    }

    public UnloginException(String msg) {
        super(msg);
    }
}
