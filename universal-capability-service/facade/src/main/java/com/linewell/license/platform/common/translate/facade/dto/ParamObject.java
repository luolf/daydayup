package com.linewell.license.platform.common.translate.facade.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-06
 * Time 16:54
 */
@Setter
@Getter
public class ParamObject {
    //{paramCode:2001,paramDef:"动态原始值",isTranslated:false}
    private String paramCode;
    private String paramDef;
    private boolean isTranslated=false;

}
