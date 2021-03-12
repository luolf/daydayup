package com.gugee.ins.common.model.mysql.statistics;

import javax.persistence.*;

@Table(name = "ins_st_blogger_real_following")
public class InsStBloggerRealFollowing {
    @Id
    private Long id;

    /**
     * 博主id
     */
    private Long uid;

    /**
     * 一级分类
     */
    @Column(name = "overall_category_name")
    private String overallCategoryName;

    /**
     * 二级分类
     */
    @Column(name = "category_name")
    private String categoryName;

    /**
     * 粉丝量级
     */
    @Column(name = "follower_size")
    private Integer followerSize;

    /**
     * 粉丝数
     */
    @Column(name = "follower_count")
    private Long followerCount;

    /**
     * 预估真实粉丝数
     */
    @Column(name = "real_follower_count")
    private Long realFollowerCount;

    /**
     * 真实粉丝占比
     */
    @Column(name = "real_follower_rate")
    private Double realFollowerRate;

    /**
     * 粉丝样本数
     */
    @Column(name = "real_follower_sample_count")
    private Integer realFollowerSampleCount;

    /**
     * 活跃粉丝成人占比
     */
    @Column(name = "adult_rate")
    private Double adultRate;

    /**
     * 活跃粉丝性别、年龄分析样本数
     */
    @Column(name = "gender_sample_count")
    private Integer genderSampleCount;

    /**
     * 活跃粉丝女性占比
     */
    @Column(name = "female_rate")
    private Double femaleRate;

    /**
     * 品牌帖子的平均参与率
     */
    @Column(name = "brand_media_er")
    private Double brandMediaEr;

    /**
     * 品牌帖子在所有帖子中的占比
     */
    @Column(name = "brand_media_rate")
    private Double brandMediaRate;

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
     * 获取一级分类
     *
     * @return overall_category_name - 一级分类
     */
    public String getOverallCategoryName() {
        return overallCategoryName;
    }

    /**
     * 设置一级分类
     *
     * @param overallCategoryName 一级分类
     */
    public void setOverallCategoryName(String overallCategoryName) {
        this.overallCategoryName = overallCategoryName == null ? null : overallCategoryName.trim();
    }

    /**
     * 获取二级分类
     *
     * @return category_name - 二级分类
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * 设置二级分类
     *
     * @param categoryName 二级分类
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    /**
     * 获取粉丝量级
     *
     * @return follower_size - 粉丝量级
     */
    public Integer getFollowerSize() {
        return followerSize;
    }

    /**
     * 设置粉丝量级
     *
     * @param followerSize 粉丝量级
     */
    public void setFollowerSize(Integer followerSize) {
        this.followerSize = followerSize;
    }

    /**
     * 获取粉丝数
     *
     * @return follower_count - 粉丝数
     */
    public Long getFollowerCount() {
        return followerCount;
    }

    /**
     * 设置粉丝数
     *
     * @param followerCount 粉丝数
     */
    public void setFollowerCount(Long followerCount) {
        this.followerCount = followerCount;
    }

    /**
     * 获取预估真实粉丝数
     *
     * @return real_follower_count - 预估真实粉丝数
     */
    public Long getRealFollowerCount() {
        return realFollowerCount;
    }

    /**
     * 设置预估真实粉丝数
     *
     * @param realFollowerCount 预估真实粉丝数
     */
    public void setRealFollowerCount(Long realFollowerCount) {
        this.realFollowerCount = realFollowerCount;
    }

    /**
     * 获取真实粉丝占比
     *
     * @return real_follower_rate - 真实粉丝占比
     */
    public Double getRealFollowerRate() {
        return realFollowerRate;
    }

    /**
     * 设置真实粉丝占比
     *
     * @param realFollowerRate 真实粉丝占比
     */
    public void setRealFollowerRate(Double realFollowerRate) {
        this.realFollowerRate = realFollowerRate;
    }

    /**
     * 获取粉丝样本数
     *
     * @return real_follower_sample_count - 粉丝样本数
     */
    public Integer getRealFollowerSampleCount() {
        return realFollowerSampleCount;
    }

    /**
     * 设置粉丝样本数
     *
     * @param realFollowerSampleCount 粉丝样本数
     */
    public void setRealFollowerSampleCount(Integer realFollowerSampleCount) {
        this.realFollowerSampleCount = realFollowerSampleCount;
    }

    /**
     * 获取活跃粉丝成人占比
     *
     * @return adult_rate - 活跃粉丝成人占比
     */
    public Double getAdultRate() {
        return adultRate;
    }

    /**
     * 设置活跃粉丝成人占比
     *
     * @param adultRate 活跃粉丝成人占比
     */
    public void setAdultRate(Double adultRate) {
        this.adultRate = adultRate;
    }

    /**
     * 获取活跃粉丝性别、年龄分析样本数
     *
     * @return gender_sample_count - 活跃粉丝性别、年龄分析样本数
     */
    public Integer getGenderSampleCount() {
        return genderSampleCount;
    }

    /**
     * 设置活跃粉丝性别、年龄分析样本数
     *
     * @param genderSampleCount 活跃粉丝性别、年龄分析样本数
     */
    public void setGenderSampleCount(Integer genderSampleCount) {
        this.genderSampleCount = genderSampleCount;
    }

    /**
     * 获取活跃粉丝女性占比
     *
     * @return female_rate - 活跃粉丝女性占比
     */
    public Double getFemaleRate() {
        return femaleRate;
    }

    /**
     * 设置活跃粉丝女性占比
     *
     * @param femaleRate 活跃粉丝女性占比
     */
    public void setFemaleRate(Double femaleRate) {
        this.femaleRate = femaleRate;
    }

    /**
     * 获取品牌帖子的平均参与率
     *
     * @return brand_media_er - 品牌帖子的平均参与率
     */
    public Double getBrandMediaEr() {
        return brandMediaEr;
    }

    /**
     * 设置品牌帖子的平均参与率
     *
     * @param brandMediaEr 品牌帖子的平均参与率
     */
    public void setBrandMediaEr(Double brandMediaEr) {
        this.brandMediaEr = brandMediaEr;
    }

    /**
     * 获取品牌帖子在所有帖子中的占比
     *
     * @return brand_media_rate - 品牌帖子在所有帖子中的占比
     */
    public Double getBrandMediaRate() {
        return brandMediaRate;
    }

    /**
     * 设置品牌帖子在所有帖子中的占比
     *
     * @param brandMediaRate 品牌帖子在所有帖子中的占比
     */
    public void setBrandMediaRate(Double brandMediaRate) {
        this.brandMediaRate = brandMediaRate;
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