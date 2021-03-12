package com.gugee.ins.common.model.mysql.blogger;

import javax.persistence.*;

@Table(name = "ins_blogger_collect")
public class InsBloggerCollect {
    @Id
    private Long id;

    /**
     * 博主id
     */
    private Long uid;

    /**
     * 用户名
     */
    private String username;

    /**
     * 全名
     */
    @Column(name = "full_name")
    private String fullName;

    /**
     * 头像地址
     */
    @Column(name = "pic_url")
    private String picUrl;

    /**
     * 其他主页链接
     */
    @Column(name = "external_url")
    private String externalUrl;

    /**
     * 个人简述
     */
    private String biography;

    /**
     * 关注数
     */
    @Column(name = "following_count")
    private Integer followingCount;

    /**
     * 粉丝数
     */
    @Column(name = "follower_count")
    private Long followerCount;

    /**
     * 帖子数
     */
    @Column(name = "media_count")
    private Integer mediaCount;

    /**
     * igtv数
     */
    @Column(name = "igtv_count")
    private Integer igtvCount;

    /**
     * 标记数
     */
    @Column(name = "following_tag_count")
    private Integer followingTagCount;

    /**
     * 被标记数
     */
    @Column(name = "usertags_count")
    private Integer usertagsCount;

    /**
     * 是否私有
     */
    @Column(name = "is_private")
    private Boolean isPrivate;

    /**
     * 是否认证
     */
    @Column(name = "is_verified")
    private Boolean isVerified;

    /**
     * 是否商业账号
     */
    @Column(name = "is_business")
    private Boolean isBusiness;

    /**
     * 账号类型(未认证：1；认证且商业：2；认证非商业：3)
     */
    @Column(name = "account_type")
    private Integer accountType;

    /**
     * 分类
     */
    private String category;

    /**
     * 联系电话
     */
    @Column(name = "contact_phone_number")
    private String contactPhoneNumber;

    /**
     * 公开邮箱
     */
    @Column(name = "public_email")
    private String publicEmail;

    /**
     * 公开电话国家码
     */
    @Column(name = "public_phone_country_code")
    private String publicPhoneCountryCode;

    /**
     * 公开电话
     */
    @Column(name = "public_phone_number")
    private String publicPhoneNumber;

    /**
     * 经度
     */
    private Double latitude;

    /**
     * 纬度
     */
    private Double longitude;

    /**
     * 国家
     */
    private String country;

    /**
     * 城市
     */
    private String city;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Long createTime;

    /**
     * 最近采集接口时间
     */
    @Column(name = "last_collect_time")
    private Long lastCollectTime;

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
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 获取全名
     *
     * @return full_name - 全名
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * 设置全名
     *
     * @param fullName 全名
     */
    public void setFullName(String fullName) {
        this.fullName = fullName == null ? null : fullName.trim();
    }

    /**
     * 获取头像地址
     *
     * @return pic_url - 头像地址
     */
    public String getPicUrl() {
        return picUrl;
    }

    /**
     * 设置头像地址
     *
     * @param picUrl 头像地址
     */
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    /**
     * 获取其他主页链接
     *
     * @return external_url - 其他主页链接
     */
    public String getExternalUrl() {
        return externalUrl;
    }

    /**
     * 设置其他主页链接
     *
     * @param externalUrl 其他主页链接
     */
    public void setExternalUrl(String externalUrl) {
        this.externalUrl = externalUrl == null ? null : externalUrl.trim();
    }

    /**
     * 获取个人简述
     *
     * @return biography - 个人简述
     */
    public String getBiography() {
        return biography;
    }

    /**
     * 设置个人简述
     *
     * @param biography 个人简述
     */
    public void setBiography(String biography) {
        this.biography = biography == null ? null : biography.trim();
    }

    /**
     * 获取关注数
     *
     * @return following_count - 关注数
     */
    public Integer getFollowingCount() {
        return followingCount;
    }

    /**
     * 设置关注数
     *
     * @param followingCount 关注数
     */
    public void setFollowingCount(Integer followingCount) {
        this.followingCount = followingCount;
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
     * 获取帖子数
     *
     * @return media_count - 帖子数
     */
    public Integer getMediaCount() {
        return mediaCount;
    }

    /**
     * 设置帖子数
     *
     * @param mediaCount 帖子数
     */
    public void setMediaCount(Integer mediaCount) {
        this.mediaCount = mediaCount;
    }

    /**
     * 获取igtv数
     *
     * @return igtv_count - igtv数
     */
    public Integer getIgtvCount() {
        return igtvCount;
    }

    /**
     * 设置igtv数
     *
     * @param igtvCount igtv数
     */
    public void setIgtvCount(Integer igtvCount) {
        this.igtvCount = igtvCount;
    }

    /**
     * 获取标记数
     *
     * @return following_tag_count - 标记数
     */
    public Integer getFollowingTagCount() {
        return followingTagCount;
    }

    /**
     * 设置标记数
     *
     * @param followingTagCount 标记数
     */
    public void setFollowingTagCount(Integer followingTagCount) {
        this.followingTagCount = followingTagCount;
    }

    /**
     * 获取被标记数
     *
     * @return usertags_count - 被标记数
     */
    public Integer getUsertagsCount() {
        return usertagsCount;
    }

    /**
     * 设置被标记数
     *
     * @param usertagsCount 被标记数
     */
    public void setUsertagsCount(Integer usertagsCount) {
        this.usertagsCount = usertagsCount;
    }

    /**
     * 获取是否私有
     *
     * @return is_private - 是否私有
     */
    public Boolean getIsPrivate() {
        return isPrivate;
    }

    /**
     * 设置是否私有
     *
     * @param isPrivate 是否私有
     */
    public void setIsPrivate(Boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    /**
     * 获取是否认证
     *
     * @return is_verified - 是否认证
     */
    public Boolean getIsVerified() {
        return isVerified;
    }

    /**
     * 设置是否认证
     *
     * @param isVerified 是否认证
     */
    public void setIsVerified(Boolean isVerified) {
        this.isVerified = isVerified;
    }

    /**
     * 获取是否商业账号
     *
     * @return is_business - 是否商业账号
     */
    public Boolean getIsBusiness() {
        return isBusiness;
    }

    /**
     * 设置是否商业账号
     *
     * @param isBusiness 是否商业账号
     */
    public void setIsBusiness(Boolean isBusiness) {
        this.isBusiness = isBusiness;
    }

    /**
     * 获取账号类型(未认证：1；认证且商业：2；认证非商业：3)
     *
     * @return account_type - 账号类型(未认证：1；认证且商业：2；认证非商业：3)
     */
    public Integer getAccountType() {
        return accountType;
    }

    /**
     * 设置账号类型(未认证：1；认证且商业：2；认证非商业：3)
     *
     * @param accountType 账号类型(未认证：1；认证且商业：2；认证非商业：3)
     */
    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    /**
     * 获取分类
     *
     * @return category - 分类
     */
    public String getCategory() {
        return category;
    }

    /**
     * 设置分类
     *
     * @param category 分类
     */
    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    /**
     * 获取联系电话
     *
     * @return contact_phone_number - 联系电话
     */
    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    /**
     * 设置联系电话
     *
     * @param contactPhoneNumber 联系电话
     */
    public void setContactPhoneNumber(String contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber == null ? null : contactPhoneNumber.trim();
    }

    /**
     * 获取公开邮箱
     *
     * @return public_email - 公开邮箱
     */
    public String getPublicEmail() {
        return publicEmail;
    }

    /**
     * 设置公开邮箱
     *
     * @param publicEmail 公开邮箱
     */
    public void setPublicEmail(String publicEmail) {
        this.publicEmail = publicEmail == null ? null : publicEmail.trim();
    }

    /**
     * 获取公开电话国家码
     *
     * @return public_phone_country_code - 公开电话国家码
     */
    public String getPublicPhoneCountryCode() {
        return publicPhoneCountryCode;
    }

    /**
     * 设置公开电话国家码
     *
     * @param publicPhoneCountryCode 公开电话国家码
     */
    public void setPublicPhoneCountryCode(String publicPhoneCountryCode) {
        this.publicPhoneCountryCode = publicPhoneCountryCode == null ? null : publicPhoneCountryCode.trim();
    }

    /**
     * 获取公开电话
     *
     * @return public_phone_number - 公开电话
     */
    public String getPublicPhoneNumber() {
        return publicPhoneNumber;
    }

    /**
     * 设置公开电话
     *
     * @param publicPhoneNumber 公开电话
     */
    public void setPublicPhoneNumber(String publicPhoneNumber) {
        this.publicPhoneNumber = publicPhoneNumber == null ? null : publicPhoneNumber.trim();
    }

    /**
     * 获取经度
     *
     * @return latitude - 经度
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * 设置经度
     *
     * @param latitude 经度
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    /**
     * 获取纬度
     *
     * @return longitude - 纬度
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * 设置纬度
     *
     * @param longitude 纬度
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    /**
     * 获取国家
     *
     * @return country - 国家
     */
    public String getCountry() {
        return country;
    }

    /**
     * 设置国家
     *
     * @param country 国家
     */
    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    /**
     * 获取城市
     *
     * @return city - 城市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置城市
     *
     * @param city 城市
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
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
     * 获取最近采集接口时间
     *
     * @return last_collect_time - 最近采集接口时间
     */
    public Long getLastCollectTime() {
        return lastCollectTime;
    }

    /**
     * 设置最近采集接口时间
     *
     * @param lastCollectTime 最近采集接口时间
     */
    public void setLastCollectTime(Long lastCollectTime) {
        this.lastCollectTime = lastCollectTime;
    }
}