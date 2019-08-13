package com.linewell.license.platform.common.translate.service.dao;

import com.linewell.license.platform.common.translate.service.MyMapper;
import com.linewell.license.platform.common.translate.service.pojo.CommTrsParameter;

import java.util.List;

public interface CommTrsParameterMapper extends MyMapper<CommTrsParameter> {
    public List<CommTrsParameter> findCommTrsParametersByCodes(List<String> paramcodes,String language);
}