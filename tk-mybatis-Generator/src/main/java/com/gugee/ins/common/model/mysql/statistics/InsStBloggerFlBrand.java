package com.gugee.ins.common.model.mysql.statistics;

import javax.persistence.*;

@Table(name = "ins_st_blogger_fl_brand")
public class InsStBloggerFlBrand {
    @Id
    private Long id;

    /**
     * 博主uid
     */
    private Long uid;

    /**
     * 活跃粉丝关注品牌的uid
     */
    @Column(name = "brand_uid")
    private Long brandUid;

    /**
     * 活跃粉丝关注该品牌的人数
     */
    @Column(name = "brand_follower_count")
    private Integer brandFollowerCount;

    /**
     * 活跃粉丝关注品牌的排名
     */
    @Column(name = "brand_rank")
    private Byte brandRank;

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
     * 获取博主uid
     *
     * @return uid - 博主uid
     */
    public Long getUid() {
        return uid;
    }

    /**
     * 设置博主uid
     *
     * @param uid 博主uid
     */
    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * 获取活跃粉丝关注品牌的uid
     *
     * @return brand_uid - 活跃粉丝关注品牌的uid
     */
    public Long getBrandUid() {
        return brandUid;
    }

    /**
     * 设置活跃粉丝关注品牌的uid
     *
     * @param brandUid 活跃粉丝关注品牌的uid
     */
    public void setBrandUid(Long brandUid) {
        this.brandUid = brandUid;
    }

    /**
     * 获取活跃粉丝关注该品牌的人数
     *
     * @return brand_follower_count - 活跃粉丝关注该品牌的人数
     */
    public Integer getBrandFollowerCount() {
        return brandFollowerCount;
    }

    /**
     * 设置活跃粉丝关注该品牌的人数
     *
     * @param brandFollowerCount 活跃粉丝关注该品牌的人数
     */
    public void setBrandFollowerCount(Integer brandFollowerCount) {
        this.brandFollowerCount = brandFollowerCount;
    }

    /**
     * 获取活跃粉丝关注品牌的排名
     *
     * @return brand_rank - 活跃粉丝关注品牌的排名
     */
    public Byte getBrandRank() {
        return brandRank;
    }

    /**
     * 设置活跃粉丝关注品牌的排名
     *
     * @param brandRank 活跃粉丝关注品牌的排名
     */
    public void setBrandRank(Byte brandRank) {
        this.brandRank = brandRank;
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