package com.linewell.license.platform.common.security.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * 验证码
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-26
 * Time 12:00
 */
@Getter
@Setter
public class CaptchaCodeBo {
    /**
     * 验证码
     */
    String code;
    /**
     * 类型：图片验证码、短信验证码
     */
    String codeType;
}
