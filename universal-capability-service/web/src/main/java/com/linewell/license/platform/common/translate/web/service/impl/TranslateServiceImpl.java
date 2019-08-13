package com.linewell.license.platform.common.translate.web.service.impl;

import com.linewell.license.platform.common.translate.facade.api.CommTranslateDbFacade;
import com.linewell.license.platform.common.translate.facade.dto.CommTrsMessageDto;
import com.linewell.license.platform.common.translate.facade.dto.CommTrsParameterDto;
import com.linewell.license.platform.common.translate.facade.dto.TranslateObject;
import com.linewell.license.platform.common.translate.web.service.TranslateService;
import com.linewell.license.platform.common.translate.web.util.TranslateUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-06
 * Time 17:43
 */
public class TranslateServiceImpl implements TranslateService {

    @Autowired
    CommTranslateDbFacade commTranslateDbFacade;

    /**
     * 根据翻译对象完成消息组装，如果参数code未配置，将使用默认值
     * Description
     * @return 返回值说明
     * @param translateObject 待翻译对象
     * @author luolifeng
     * Date  2019/8/9
     */
    @Override
    public String getMsg(TranslateObject translateObject) throws InstantiationException, IllegalAccessException {

        CommTrsMessageDto commTrsMessageDto = findCommTrsMessageByCode(translateObject.getCode(), translateObject.getLanguage());
        if (translateObject.getParams() == null || translateObject.getParams().isEmpty()) {
            return commTrsMessageDto.getMsgTemplate();
        }

        String[] params;
        Map<String, CommTrsParameterDto> paramCodeMap = null;
        List<String> paramCodes = TranslateUtil.getNeedTranslatedParamCodes(translateObject);
        if (paramCodes != null && !paramCodes.isEmpty()) {
            List<CommTrsParameterDto> commTrsParameterDtoList = findCommTrsParametersByCodes(paramCodes, translateObject.getLanguage());
            paramCodeMap = TranslateUtil.convertList2Map(commTrsParameterDtoList);
        }

        params = TranslateUtil.createParamObjects(translateObject.getParams(), paramCodeMap);
        return MessageFormat.format(commTrsMessageDto.getMsgTemplate(), (Object[]) params);

    }


    /**
     * 注解为本地缓存管理
     * Description
     * @param code     消息码
     * @param language 语言
     * @return 返回值说明
     * @author luolifeng
     * Date  2019/8/9
     */
    private CommTrsMessageDto findCommTrsMessageByCode(String code, String language) {
        return commTranslateDbFacade.findCommTrsMessageByCode(code, language);
    }

    /**
     * 注解为本地缓存管理
     * Description
     * @param codes    参数码列表
     * @param language 语言
     * @return 返回值说明
     * @author luolifeng
     * Date  2019/8/9
     */
    private List<CommTrsParameterDto> findCommTrsParametersByCodes(List<String> codes, String language) throws IllegalAccessException, InstantiationException {
        return commTranslateDbFacade.findCommTrsParametersByCodes(codes, language);
    }

}
