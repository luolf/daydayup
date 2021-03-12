package com.gugee.ins.common.model.mysql.statistics;

import javax.persistence.*;

@Table(name = "ins_st_blogger_generation")
public class InsStBloggerGeneration {
    @Id
    private Long id;

    /**
     * 博主id
     */
    private Long uid;

    /**
     * 年龄段
     */
    private String generation;

    /**
     * 年龄段占比
     */
    @Column(name = "generation_rate")
    private Double generationRate;

    /**
     * 年龄段占比排名
     */
    @Column(name = "generation_rank")
    private Byte generationRank;

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
     * 获取年龄段
     *
     * @return generation - 年龄段
     */
    public String getGeneration() {
        return generation;
    }

    /**
     * 设置年龄段
     *
     * @param generation 年龄段
     */
    public void setGeneration(String generation) {
        this.generation = generation == null ? null : generation.trim();
    }

    /**
     * 获取年龄段占比
     *
     * @return generation_rate - 年龄段占比
     */
    public Double getGenerationRate() {
        return generationRate;
    }

    /**
     * 设置年龄段占比
     *
     * @param generationRate 年龄段占比
     */
    public void setGenerationRate(Double generationRate) {
        this.generationRate = generationRate;
    }

    /**
     * 获取年龄段占比排名
     *
     * @return generation_rank - 年龄段占比排名
     */
    public Byte getGenerationRank() {
        return generationRank;
    }

    /**
     * 设置年龄段占比排名
     *
     * @param generationRank 年龄段占比排名
     */
    public void setGenerationRank(Byte generationRank) {
        this.generationRank = generationRank;
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