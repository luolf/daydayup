package com.linewell.license.platform.common.security.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-26
 * Time 14:59
 */
@Setter
@Getter
@ToString
public class MidLoginInfoBo {

    private String  smsCode;
    private String  account;
    private String  passwd ;
    private String  captcha ;
    private String  captchaId ;

    private Boolean isNeedCaptcha=false;
    public MidLoginInfoBo(Boolean isNeedCaptcha, String smsCode, String account, String passwd, String captcha,String captchaId) {
        this.isNeedCaptcha = isNeedCaptcha;
        this.smsCode = smsCode;
        this.account = account;
        this.passwd = passwd;
        this.captcha = captcha;
        this.captchaId = captchaId;
    }
}
