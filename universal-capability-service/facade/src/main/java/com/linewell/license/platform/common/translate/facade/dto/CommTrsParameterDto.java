package com.linewell.license.platform.common.translate.facade.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommTrsParameterDto {
    /**
     * 参数码 
     */

    private String code;

    /**
     * 语言 
     */
    private String language;

    /**
     * 参数值
     */
    private String value;

    /**
     * 参数类型 :日期、数值、字符串、货币
     */
    private String type;


}