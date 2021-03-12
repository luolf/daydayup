package com.gugee.ins.common.model.mysql.statistics;

import javax.persistence.*;

@Table(name = "ins_st_blogger_race")
public class InsStBloggerRace {
    @Id
    private Long id;

    /**
     * 博主id
     */
    private Long uid;

    /**
     * 人种
     */
    private String race;

    /**
     * 人种占比
     */
    @Column(name = "race_rate")
    private Double raceRate;

    /**
     * 人种占比排名
     */
    @Column(name = "race_rank")
    private Byte raceRank;

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
     * 获取人种
     *
     * @return race - 人种
     */
    public String getRace() {
        return race;
    }

    /**
     * 设置人种
     *
     * @param race 人种
     */
    public void setRace(String race) {
        this.race = race == null ? null : race.trim();
    }

    /**
     * 获取人种占比
     *
     * @return race_rate - 人种占比
     */
    public Double getRaceRate() {
        return raceRate;
    }

    /**
     * 设置人种占比
     *
     * @param raceRate 人种占比
     */
    public void setRaceRate(Double raceRate) {
        this.raceRate = raceRate;
    }

    /**
     * 获取人种占比排名
     *
     * @return race_rank - 人种占比排名
     */
    public Byte getRaceRank() {
        return raceRank;
    }

    /**
     * 设置人种占比排名
     *
     * @param raceRank 人种占比排名
     */
    public void setRaceRank(Byte raceRank) {
        this.raceRank = raceRank;
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