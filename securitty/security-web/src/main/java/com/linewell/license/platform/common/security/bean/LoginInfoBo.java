package com.linewell.license.platform.common.security.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-26
 * Time 11:55
 */
@Setter
@Getter
public class LoginInfoBo {
    /**
     * 账号
     */
    String account;
    /**
     * 密码
     */
    String password;
    /**
     * 验证码
     */
    CaptchaCodeBo captchaCodeBo;

}
