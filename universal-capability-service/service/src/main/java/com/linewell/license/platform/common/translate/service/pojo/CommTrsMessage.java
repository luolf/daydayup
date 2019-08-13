package com.linewell.license.platform.common.translate.service.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "comm_trs_message")
public class CommTrsMessage {
    /**
     * 消息码 
     */
    @Id
    private String code;

    /**
     * 语言 
     */
    private String language;

    /**
     * 消息模板
     */
    @Column(name = "msg_template")
    private String msgTemplate;

    /**
     * 消息类型 :提示消息、异常消息
     */
    private String type;

    /**
     * id
     */
    private Long id;

    /**
     * 获取消息码 
     *
     * @return code - 消息码 
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置消息码 
     *
     * @param code 消息码 
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取语言 
     *
     * @return language - 语言 
     */
    public String getLanguage() {
        return language;
    }

    /**
     * 设置语言 
     *
     * @param language 语言 
     */
    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }

    /**
     * 获取消息模板
     *
     * @return msg_template - 消息模板
     */
    public String getMsgTemplate() {
        return msgTemplate;
    }

    /**
     * 设置消息模板
     *
     * @param msgTemplate 消息模板
     */
    public void setMsgTemplate(String msgTemplate) {
        this.msgTemplate = msgTemplate == null ? null : msgTemplate.trim();
    }

    /**
     * 获取消息类型 :提示消息、异常消息
     *
     * @return type - 消息类型 :提示消息、异常消息
     */
    public String getType() {
        return type;
    }

    /**
     * 设置消息类型 :提示消息、异常消息
     *
     * @param type 消息类型 :提示消息、异常消息
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 获取id
     *
     * @return id - id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }
}