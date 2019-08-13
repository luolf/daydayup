package com.linewell.license.platform.common.api;

import com.linewell.license.platform.common.dto.TranslateObject;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-06
 * Time 16:59
 */
public interface TranslateErrorApi {
    public String getErrorMsg(TranslateObject translateObject, String language);
    public String getErrorMsg(TranslateObject translateObject);


}
