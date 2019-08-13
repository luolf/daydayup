package com.linewell.license.platform.common.translate.facade.api;

import com.linewell.license.platform.common.translate.facade.dto.CommTrsMessageDto;
import com.linewell.license.platform.common.translate.facade.dto.CommTrsParameterDto;

import java.util.List;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-09
 * Time 11:35
 */
public interface CommTranslateDbFacade {
    CommTrsMessageDto findCommTrsMessageByCode(String code, String language);
    List<CommTrsParameterDto> findCommTrsParametersByCodes(List<String> codes, String language) throws InstantiationException, IllegalAccessException;
}
