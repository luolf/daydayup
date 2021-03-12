package com.gugee.ins.common.model.mysql.blogger;

import javax.persistence.*;

@Table(name = "ins_blogger_main")
public class InsBloggerMain {
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
     * 关注品牌数
     */
    @Column(name = "following_brand_count")
    private Integer followingBrandCount;

    /**
     * 粉丝数
     */
    @Column(name = "follower_count")
    private Long followerCount;

    /**
     * 粉丝量级(关联量级表)
     */
    @Column(name = "follower_size")
    private Integer followerSize;

    /**
     * 真实粉丝占比
     */
    @Column(name = "real_follower_rate")
    private Double realFollowerRate;

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
     * 是否是僵尸粉
     */
    @Column(name = "is_zombie")
    private Boolean isZombie;

    /**
     * 账号类型(未认证：1；认证且商业：2；认证非商业：3)
     */
    @Column(name = "account_type")
    private Integer accountType;

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
     * fackbook id
     */
    private Long fbid;

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
     * 国家(城市名称截取来的)
     */
    private String region;

    /**
     * 城市id
     */
    @Column(name = "city_id")
    private Long cityId;

    /**
     * 城市名称
     */
    @Column(name = "city_name")
    private String cityName;

    /**
     * 国家(映射分析出来的)
     */
    private String nation;

    /**
     * 年龄(0:未分析;1:未知;其余的该是几岁就几岁)
     */
    private Integer age;

    /**
     * 出生年（用来后面每年更新已经分析过的年龄）
     */
    private Integer birthday;

    /**
     * 性别(0:未分析;1:未知;2:女;3:男;4:qps_full;5:pic_error;6:impl_error)
     */
    private Integer gender;

    /**
     * 语言
     */
    private String language;

    /**
     * 人种
     */
    private String race;

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
     * 获取关注品牌数
     *
     * @return following_brand_count - 关注品牌数
     */
    public Integer getFollowingBrandCount() {
        return followingBrandCount;
    }

    /**
     * 设置关注品牌数
     *
     * @param followingBrandCount 关注品牌数
     */
    public void setFollowingBrandCount(Integer followingBrandCount) {
        this.followingBrandCount = followingBrandCount;
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
     * 获取粉丝量级(关联量级表)
     *
     * @return follower_size - 粉丝量级(关联量级表)
     */
    public Integer getFollowerSize() {
        return followerSize;
    }

    /**
     * 设置粉丝量级(关联量级表)
     *
     * @param followerSize 粉丝量级(关联量级表)
     */
    public void setFollowerSize(Integer followerSize) {
        this.followerSize = followerSize;
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
     * 获取是否是僵尸粉
     *
     * @return is_zombie - 是否是僵尸粉
     */
    public Boolean getIsZombie() {
        return isZombie;
    }

    /**
     * 设置是否是僵尸粉
     *
     * @param isZombie 是否是僵尸粉
     */
    public void setIsZombie(Boolean isZombie) {
        this.isZombie = isZombie;
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
     * 获取fackbook id
     *
     * @return fbid - fackbook id
     */
    public Long getFbid() {
        return fbid;
    }

    /**
     * 设置fackbook id
     *
     * @param fbid fackbook id
     */
    public void setFbid(Long fbid) {
        this.fbid = fbid;
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
     * 获取国家(城市名称截取来的)
     *
     * @return region - 国家(城市名称截取来的)
     */
    public String getRegion() {
        return region;
    }

    /**
     * 设置国家(城市名称截取来的)
     *
     * @param region 国家(城市名称截取来的)
     */
    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    /**
     * 获取城市id
     *
     * @return city_id - 城市id
     */
    public Long getCityId() {
        return cityId;
    }

    /**
     * 设置城市id
     *
     * @param cityId 城市id
     */
    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    /**
     * 获取城市名称
     *
     * @return city_name - 城市名称
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * 设置城市名称
     *
     * @param cityName 城市名称
     */
    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    /**
     * 获取国家(映射分析出来的)
     *
     * @return nation - 国家(映射分析出来的)
     */
    public String getNation() {
        return nation;
    }

    /**
     * 设置国家(映射分析出来的)
     *
     * @param nation 国家(映射分析出来的)
     */
    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    /**
     * 获取年龄(0:未分析;1:未知;其余的该是几岁就几岁)
     *
     * @return age - 年龄(0:未分析;1:未知;其余的该是几岁就几岁)
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置年龄(0:未分析;1:未知;其余的该是几岁就几岁)
     *
     * @param age 年龄(0:未分析;1:未知;其余的该是几岁就几岁)
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取出生年（用来后面每年更新已经分析过的年龄）
     *
     * @return birthday - 出生年（用来后面每年更新已经分析过的年龄）
     */
    public Integer getBirthday() {
        return birthday;
    }

    /**
     * 设置出生年（用来后面每年更新已经分析过的年龄）
     *
     * @param birthday 出生年（用来后面每年更新已经分析过的年龄）
     */
    public void setBirthday(Integer birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取性别(0:未分析;1:未知;2:女;3:男;4:qps_full;5:pic_error;6:impl_error)
     *
     * @return gender - 性别(0:未分析;1:未知;2:女;3:男;4:qps_full;5:pic_error;6:impl_error)
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * 设置性别(0:未分析;1:未知;2:女;3:男;4:qps_full;5:pic_error;6:impl_error)
     *
     * @param gender 性别(0:未分析;1:未知;2:女;3:男;4:qps_full;5:pic_error;6:impl_error)
     */
    public void setGender(Integer gender) {
        this.gender = gender;
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