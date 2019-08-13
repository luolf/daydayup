package com.linewell.license.platform.common.translate.service.pojo;

import javax.persistence.*;

@Table(name = "comm_trs_parameter")
public class CommTrsParameter {
    /**
     * 参数码 
     */
    @Id
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

    /**
     * id
     */
    private Long id;

    /**
     * 获取参数码 
     *
     * @return code - 参数码 
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置参数码 
     *
     * @param code 参数码 
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
     * 获取参数值
     *
     * @return value - 参数值
     */
    public String getValue() {
        return value;
    }

    /**
     * 设置参数值
     *
     * @param value 参数值
     */
    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    /**
     * 获取参数类型 :日期、数值、字符串、货币
     *
     * @return type - 参数类型 :日期、数值、字符串、货币
     */
    public String getType() {
        return type;
    }

    /**
     * 设置参数类型 :日期、数值、字符串、货币
     *
     * @param type 参数类型 :日期、数值、字符串、货币
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