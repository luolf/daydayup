package com.linewell.license.platform.common.security.facade.api;



/**
 *
 */
public interface CaptchaService {
    /**
     *
     * @param captchaID
     * @param inputCaptcha
     * @return
     * @throws
     */
    boolean captchaValidate(String captchaID, String captchaText) ;


}
