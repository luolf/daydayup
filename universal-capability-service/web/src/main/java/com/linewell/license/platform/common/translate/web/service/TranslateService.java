package com.linewell.license.platform.common.translate.web.service;


import com.linewell.license.platform.common.translate.facade.dto.TranslateObject;

/**
 * Description 消息转换
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-06
 * Time 16:59
 */
public interface TranslateService {
    public String getMsg(TranslateObject translateObject) throws InstantiationException, IllegalAccessException;
}
