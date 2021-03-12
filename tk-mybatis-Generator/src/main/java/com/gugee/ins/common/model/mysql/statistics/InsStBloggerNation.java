package com.gugee.ins.common.model.mysql.statistics;

import javax.persistence.*;

@Table(name = "ins_st_blogger_nation")
public class InsStBloggerNation {
    @Id
    private Long id;

    /**
     * 博主id
     */
    private Long uid;

    /**
     * 国家
     */
    private String nation;

    /**
     * 国家占比
     */
    @Column(name = "nation_rate")
    private Double nationRate;

    /**
     * 国家占比排名
     */
    @Column(name = "nation_rank")
    private Byte nationRank;

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
     * 获取国家
     *
     * @return nation - 国家
     */
    public String getNation() {
        return nation;
    }

    /**
     * 设置国家
     *
     * @param nation 国家
     */
    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    /**
     * 获取国家占比
     *
     * @return nation_rate - 国家占比
     */
    public Double getNationRate() {
        return nationRate;
    }

    /**
     * 设置国家占比
     *
     * @param nationRate 国家占比
     */
    public void setNationRate(Double nationRate) {
        this.nationRate = nationRate;
    }

    /**
     * 获取国家占比排名
     *
     * @return nation_rank - 国家占比排名
     */
    public Byte getNationRank() {
        return nationRank;
    }

    /**
     * 设置国家占比排名
     *
     * @param nationRank 国家占比排名
     */
    public void setNationRank(Byte nationRank) {
        this.nationRank = nationRank;
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