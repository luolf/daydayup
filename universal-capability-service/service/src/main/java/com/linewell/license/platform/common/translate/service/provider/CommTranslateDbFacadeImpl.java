package com.linewell.license.platform.common.translate.service.provider;

import com.linewell.license.platform.common.translate.facade.api.CommTranslateDbFacade;
import com.linewell.license.platform.common.translate.facade.dto.CommTrsMessageDto;
import com.linewell.license.platform.common.translate.facade.dto.CommTrsParameterDto;
import com.linewell.license.platform.common.translate.service.dao.CommTrsMessageMapper;
import com.linewell.license.platform.common.translate.service.dao.CommTrsParameterMapper;
import com.linewell.license.platform.common.translate.service.pojo.CommTrsMessage;
import com.linewell.license.platform.common.translate.service.pojo.CommTrsParameter;
import com.linewell.license.platform.common.translate.service.util.ConvertUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-09
 * Time 12:03
 */
public class CommTranslateDbFacadeImpl implements CommTranslateDbFacade {

    @Autowired
    CommTrsMessageMapper commTrsMessageMapper;
    @Autowired
    CommTrsParameterMapper commTrsParameterMapper;

    @Override
    public CommTrsMessageDto findCommTrsMessageByCode(String code, String language) {
        CommTrsMessage query=new CommTrsMessage();
        query.setCode(code);
        query.setLanguage(language);
        CommTrsMessage commTrsMessage=commTrsMessageMapper.selectOne(query);

        CommTrsMessageDto commTrsMessageDto=new CommTrsMessageDto();
        BeanUtils.copyProperties(commTrsMessage,commTrsMessageDto);
        return commTrsMessageDto;
    }


    @Override
    public List<CommTrsParameterDto> findCommTrsParametersByCodes(List<String> codes, String language) throws InstantiationException, IllegalAccessException {

        List<CommTrsParameter>  commTrsParameterList=  commTrsParameterMapper.findCommTrsParametersByCodes(codes,language);
        return ConvertUtil.listTolist(commTrsParameterList,CommTrsParameterDto.class);

    }


}
