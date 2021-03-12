package com.gugee.ins.common.model.mysql.blogger;

import javax.persistence.*;

@Table(name = "ins_blogger_ext")
public class InsBloggerExt {
    @Id
    private Long id;

    /**
     * 博主id
     */
    private Long uid;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Long createTime;

    /**
     * 最近博主信息采集时间
     */
    @Column(name = "last_collect_time")
    private Long lastCollectTime;

    /**
     * 最近帖子采集时间
     */
    @Column(name = "last_media_collect_time")
    private Long lastMediaCollectTime;

    /**
     * 最近评论采集时间
     */
    @Column(name = "last_comment_collect_time")
    private Long lastCommentCollectTime;

    /**
     * 采集评论数
     */
    @Column(name = "comment_collect_count")
    private Integer commentCollectCount;

    /**
     * 最近ai年龄、性别分析时间
     */
    @Column(name = "last_gender_analysis_time")
    private Long lastGenderAnalysisTime;

    /**
     * 最近ai语言分析时间
     */
    @Column(name = "last_language_analysis_time")
    private Long lastLanguageAnalysisTime;

    /**
     * 最近国家分析时间
     */
    @Column(name = "last_region_analysis_time")
    private Long lastRegionAnalysisTime;

    /**
     * 最近关注列表采集时间
     */
    @Column(name = "last_following_collect_time")
    private Long lastFollowingCollectTime;

    /**
     * 最近粉丝列表采集时间
     */
    @Column(name = "last_follower_collect_time")
    private Long lastFollowerCollectTime;

    /**
     * 最近地理位置采集时间
     */
    @Column(name = "last_location_collect_time")
    private Long lastLocationCollectTime;

    /**
     * 最近性别、年龄统计时间
     */
    @Column(name = "last_gender_st_time")
    private Long lastGenderStTime;

    /**
     * 最近真实粉丝统计时间
     */
    @Column(name = "last_real_follower_st_time")
    private Long lastRealFollowerStTime;

    /**
     * 最近国家统计时间
     */
    @Column(name = "last_nation_st_time")
    private Long lastNationStTime;

    /**
     * 最近语言统计时间
     */
    @Column(name = "last_language_st_time")
    private Long lastLanguageStTime;

    /**
     * 最近人种统计时间
     */
    @Column(name = "last_race_st_time")
    private Long lastRaceStTime;

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

    /**
     * 获取最近博主信息采集时间
     *
     * @return last_collect_time - 最近博主信息采集时间
     */
    public Long getLastCollectTime() {
        return lastCollectTime;
    }

    /**
     * 设置最近博主信息采集时间
     *
     * @param lastCollectTime 最近博主信息采集时间
     */
    public void setLastCollectTime(Long lastCollectTime) {
        this.lastCollectTime = lastCollectTime;
    }

    /**
     * 获取最近帖子采集时间
     *
     * @return last_media_collect_time - 最近帖子采集时间
     */
    public Long getLastMediaCollectTime() {
        return lastMediaCollectTime;
    }

    /**
     * 设置最近帖子采集时间
     *
     * @param lastMediaCollectTime 最近帖子采集时间
     */
    public void setLastMediaCollectTime(Long lastMediaCollectTime) {
        this.lastMediaCollectTime = lastMediaCollectTime;
    }

    /**
     * 获取最近评论采集时间
     *
     * @return last_comment_collect_time - 最近评论采集时间
     */
    public Long getLastCommentCollectTime() {
        return lastCommentCollectTime;
    }

    /**
     * 设置最近评论采集时间
     *
     * @param lastCommentCollectTime 最近评论采集时间
     */
    public void setLastCommentCollectTime(Long lastCommentCollectTime) {
        this.lastCommentCollectTime = lastCommentCollectTime;
    }

    /**
     * 获取采集评论数
     *
     * @return comment_collect_count - 采集评论数
     */
    public Integer getCommentCollectCount() {
        return commentCollectCount;
    }

    /**
     * 设置采集评论数
     *
     * @param commentCollectCount 采集评论数
     */
    public void setCommentCollectCount(Integer commentCollectCount) {
        this.commentCollectCount = commentCollectCount;
    }

    /**
     * 获取最近ai年龄、性别分析时间
     *
     * @return last_gender_analysis_time - 最近ai年龄、性别分析时间
     */
    public Long getLastGenderAnalysisTime() {
        return lastGenderAnalysisTime;
    }

    /**
     * 设置最近ai年龄、性别分析时间
     *
     * @param lastGenderAnalysisTime 最近ai年龄、性别分析时间
     */
    public void setLastGenderAnalysisTime(Long lastGenderAnalysisTime) {
        this.lastGenderAnalysisTime = lastGenderAnalysisTime;
    }

    /**
     * 获取最近ai语言分析时间
     *
     * @return last_language_analysis_time - 最近ai语言分析时间
     */
    public Long getLastLanguageAnalysisTime() {
        return lastLanguageAnalysisTime;
    }

    /**
     * 设置最近ai语言分析时间
     *
     * @param lastLanguageAnalysisTime 最近ai语言分析时间
     */
    public void setLastLanguageAnalysisTime(Long lastLanguageAnalysisTime) {
        this.lastLanguageAnalysisTime = lastLanguageAnalysisTime;
    }

    /**
     * 获取最近国家分析时间
     *
     * @return last_region_analysis_time - 最近国家分析时间
     */
    public Long getLastRegionAnalysisTime() {
        return lastRegionAnalysisTime;
    }

    /**
     * 设置最近国家分析时间
     *
     * @param lastRegionAnalysisTime 最近国家分析时间
     */
    public void setLastRegionAnalysisTime(Long lastRegionAnalysisTime) {
        this.lastRegionAnalysisTime = lastRegionAnalysisTime;
    }

    /**
     * 获取最近关注列表采集时间
     *
     * @return last_following_collect_time - 最近关注列表采集时间
     */
    public Long getLastFollowingCollectTime() {
        return lastFollowingCollectTime;
    }

    /**
     * 设置最近关注列表采集时间
     *
     * @param lastFollowingCollectTime 最近关注列表采集时间
     */
    public void setLastFollowingCollectTime(Long lastFollowingCollectTime) {
        this.lastFollowingCollectTime = lastFollowingCollectTime;
    }

    /**
     * 获取最近粉丝列表采集时间
     *
     * @return last_follower_collect_time - 最近粉丝列表采集时间
     */
    public Long getLastFollowerCollectTime() {
        return lastFollowerCollectTime;
    }

    /**
     * 设置最近粉丝列表采集时间
     *
     * @param lastFollowerCollectTime 最近粉丝列表采集时间
     */
    public void setLastFollowerCollectTime(Long lastFollowerCollectTime) {
        this.lastFollowerCollectTime = lastFollowerCollectTime;
    }

    /**
     * 获取最近地理位置采集时间
     *
     * @return last_location_collect_time - 最近地理位置采集时间
     */
    public Long getLastLocationCollectTime() {
        return lastLocationCollectTime;
    }

    /**
     * 设置最近地理位置采集时间
     *
     * @param lastLocationCollectTime 最近地理位置采集时间
     */
    public void setLastLocationCollectTime(Long lastLocationCollectTime) {
        this.lastLocationCollectTime = lastLocationCollectTime;
    }

    /**
     * 获取最近性别、年龄统计时间
     *
     * @return last_gender_st_time - 最近性别、年龄统计时间
     */
    public Long getLastGenderStTime() {
        return lastGenderStTime;
    }

    /**
     * 设置最近性别、年龄统计时间
     *
     * @param lastGenderStTime 最近性别、年龄统计时间
     */
    public void setLastGenderStTime(Long lastGenderStTime) {
        this.lastGenderStTime = lastGenderStTime;
    }

    /**
     * 获取最近真实粉丝统计时间
     *
     * @return last_real_follower_st_time - 最近真实粉丝统计时间
     */
    public Long getLastRealFollowerStTime() {
        return lastRealFollowerStTime;
    }

    /**
     * 设置最近真实粉丝统计时间
     *
     * @param lastRealFollowerStTime 最近真实粉丝统计时间
     */
    public void setLastRealFollowerStTime(Long lastRealFollowerStTime) {
        this.lastRealFollowerStTime = lastRealFollowerStTime;
    }

    /**
     * 获取最近国家统计时间
     *
     * @return last_nation_st_time - 最近国家统计时间
     */
    public Long getLastNationStTime() {
        return lastNationStTime;
    }

    /**
     * 设置最近国家统计时间
     *
     * @param lastNationStTime 最近国家统计时间
     */
    public void setLastNationStTime(Long lastNationStTime) {
        this.lastNationStTime = lastNationStTime;
    }

    /**
     * 获取最近语言统计时间
     *
     * @return last_language_st_time - 最近语言统计时间
     */
    public Long getLastLanguageStTime() {
        return lastLanguageStTime;
    }

    /**
     * 设置最近语言统计时间
     *
     * @param lastLanguageStTime 最近语言统计时间
     */
    public void setLastLanguageStTime(Long lastLanguageStTime) {
        this.lastLanguageStTime = lastLanguageStTime;
    }

    /**
     * 获取最近人种统计时间
     *
     * @return last_race_st_time - 最近人种统计时间
     */
    public Long getLastRaceStTime() {
        return lastRaceStTime;
    }

    /**
     * 设置最近人种统计时间
     *
     * @param lastRaceStTime 最近人种统计时间
     */
    public void setLastRaceStTime(Long lastRaceStTime) {
        this.lastRaceStTime = lastRaceStTime;
    }
}