package com.gugee.ins.common.model.mysql.statistics;

import javax.persistence.*;

@Table(name = "ins_st_blogger_language")
public class InsStBloggerLanguage {
    @Id
    private Long id;

    /**
     * 博主id
     */
    private Long uid;

    /**
     * 语言
     */
    private String language;

    /**
     * 语言占比
     */
    @Column(name = "language_rate")
    private Double languageRate;

    /**
     * 语言占比排名
     */
    @Column(name = "language_rank")
    private Byte languageRank;

    /**
     * 样本数
     */
    @Column(name = "sample_count")
    private Integer sampleCount;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Long createTime;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取博主id
     *
     * @return uid - 博主id
     */
    public Long getUid() {
        return uid;
    }

    /**
     * 设置博主id
     *
     * @param uid 博主id
     */
    public void setUid(Long uid) {
        this.uid = uid;
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
     * 获取语言占比
     *
     * @return language_rate - 语言占比
     */
    public Double getLanguageRate() {
        return languageRate;
    }

    /**
     * 设置语言占比
     *
     * @param languageRate 语言占比
     */
    public void setLanguageRate(Double languageRate) {
        this.languageRate = languageRate;
    }

    /**
     * 获取语言占比排名
     *
     * @return language_rank - 语言占比排名
     */
    public Byte getLanguageRank() {
        return languageRank;
    }

    /**
     * 设置语言占比排名
     *
     * @param languageRank 语言占比排名
     */
    public void setLanguageRank(Byte languageRank) {
        this.languageRank = languageRank;
    }

    /**
     * 获取样本数
     *
     * @return sample_count - 样本数
     */
    public Integer getSampleCount() {
        return sampleCount;
    }

    /**
     * 设置样本数
     *
     * @param sampleCount 样本数
     */
    public void setSampleCount(Integer sampleCount) {
        this.sampleCount = sampleCount;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}