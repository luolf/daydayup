package com.gugee.ins.common.model.mysql.statistics;

import javax.persistence.*;

@Table(name = "ins_st_blogger_fl_brand_category")
public class InsStBloggerFlBrandCategory {
    @Id
    private Long id;

    /**
     * 博主uid
     */
    private Long uid;

    /**
     * 分类名称
     */
    @Column(name = "category_name")
    private String categoryName;

    /**
     * 分类占比
     */
    @Column(name = "category_rate")
    private Double categoryRate;

    /**
     * 分类排名
     */
    @Column(name = "category_rank")
    private Byte categoryRank;

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
     * 获取分类名称
     *
     * @return category_name - 分类名称
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * 设置分类名称
     *
     * @param categoryName 分类名称
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    /**
     * 获取分类占比
     *
     * @return category_rate - 分类占比
     */
    public Double getCategoryRate() {
        return categoryRate;
    }

    /**
     * 设置分类占比
     *
     * @param categoryRate 分类占比
     */
    public void setCategoryRate(Double categoryRate) {
        this.categoryRate = categoryRate;
    }

    /**
     * 获取分类排名
     *
     * @return category_rank - 分类排名
     */
    public Byte getCategoryRank() {
        return categoryRank;
    }

    /**
     * 设置分类排名
     *
     * @param categoryRank 分类排名
     */
    public void setCategoryRank(Byte categoryRank) {
        this.categoryRank = categoryRank;
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