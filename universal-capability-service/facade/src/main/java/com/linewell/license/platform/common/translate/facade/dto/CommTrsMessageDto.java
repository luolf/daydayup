package com.linewell.license.platform.common.translate.facade.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommTrsMessageDto {
    /**
     * 消息码 
     */

    private String code;

    /**
     * 语言 
     */
    private String language;

    /**
     * 消息模板
     */

    private String msgTemplate;

    /**
     * 消息类型 :提示消息、异常消息
     */
    private String type;


}