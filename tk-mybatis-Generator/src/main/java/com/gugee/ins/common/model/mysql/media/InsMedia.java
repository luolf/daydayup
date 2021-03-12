package com.gugee.ins.common.model.mysql.media;

import javax.persistence.*;

@Table(name = "ins_media")
public class InsMedia {
    @Id
    private Long id;

    /**
     * 帖子id
     */
    private Long mid;

    /**
     * 博主id
     */
    @Column(name = "owner_uid")
    private Long ownerUid;

    /**
     * 帖子编码
     */
    private String shortcode;

    /**
     * 封面地址
     */
    @Column(name = "display_url")
    private String displayUrl;

    /**
     * 是否视频
     */
    @Column(name = "is_video")
    private Boolean isVideo;

    /**
     * 视频地址
     */
    @Column(name = "video_url")
    private String videoUrl;

    /**
     * 视频观看数
     */
    @Column(name = "video_view_count")
    private Long videoViewCount;

    /**
     * 标题
     */
    private String caption;

    /**
     * 评论数
     */
    @Column(name = "comment_count")
    private Integer commentCount;

    /**
     * 点赞数
     */
    @Column(name = "like_count")
    private Long likeCount;

    /**
     * 是否不能评论
     */
    @Column(name = "comments_disabled")
    private Boolean commentsDisabled;

    /**
     * 帖子发表时间戳
     */
    @Column(name = "taken_time")
    private Long takenTime;

    /**
     * 地点id
     */
    @Column(name = "location_id")
    private Long locationId;

    /**
     * 地点
     */
    @Column(name = "location_name")
    private String locationName;

    /**
     * 帖子类型
     */
    private String typename;

    /**
     * 帖子来源类别
     */
    @Column(name = "product_type")
    private String productType;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Long createTime;

    /**
     * 采集评论数
     */
    @Column(name = "collect_comments_count")
    private Long collectCommentsCount;

    /**
     * 最近评论采集时间时间
     */
    @Column(name = "last_comment_collect_time")
    private Long lastCommentCollectTime;

    /**
     * 是否是广告帖
     */
    @Column(name = "is_ad")
    private Boolean isAd;

    /**
     * 参与率
     */
    private Double er;

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
     * 获取帖子id
     *
     * @return mid - 帖子id
     */
    public Long getMid() {
        return mid;
    }

    /**
     * 设置帖子id
     *
     * @param mid 帖子id
     */
    public void setMid(Long mid) {
        this.mid = mid;
    }

    /**
     * 获取博主id
     *
     * @return owner_uid - 博主id
     */
    public Long getOwnerUid() {
        return ownerUid;
    }

    /**
     * 设置博主id
     *
     * @param ownerUid 博主id
     */
    public void setOwnerUid(Long ownerUid) {
        this.ownerUid = ownerUid;
    }

    /**
     * 获取帖子编码
     *
     * @return shortcode - 帖子编码
     */
    public String getShortcode() {
        return shortcode;
    }

    /**
     * 设置帖子编码
     *
     * @param shortcode 帖子编码
     */
    public void setShortcode(String shortcode) {
        this.shortcode = shortcode == null ? null : shortcode.trim();
    }

    /**
     * 获取封面地址
     *
     * @return display_url - 封面地址
     */
    public String getDisplayUrl() {
        return displayUrl;
    }

    /**
     * 设置封面地址
     *
     * @param displayUrl 封面地址
     */
    public void setDisplayUrl(String displayUrl) {
        this.displayUrl = displayUrl == null ? null : displayUrl.trim();
    }

    /**
     * 获取是否视频
     *
     * @return is_video - 是否视频
     */
    public Boolean getIsVideo() {
        return isVideo;
    }

    /**
     * 设置是否视频
     *
     * @param isVideo 是否视频
     */
    public void setIsVideo(Boolean isVideo) {
        this.isVideo = isVideo;
    }

    /**
     * 获取视频地址
     *
     * @return video_url - 视频地址
     */
    public String getVideoUrl() {
        return videoUrl;
    }

    /**
     * 设置视频地址
     *
     * @param videoUrl 视频地址
     */
    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl == null ? null : videoUrl.trim();
    }

    /**
     * 获取视频观看数
     *
     * @return video_view_count - 视频观看数
     */
    public Long getVideoViewCount() {
        return videoViewCount;
    }

    /**
     * 设置视频观看数
     *
     * @param videoViewCount 视频观看数
     */
    public void setVideoViewCount(Long videoViewCount) {
        this.videoViewCount = videoViewCount;
    }

    /**
     * 获取标题
     *
     * @return caption - 标题
     */
    public String getCaption() {
        return caption;
    }

    /**
     * 设置标题
     *
     * @param caption 标题
     */
    public void setCaption(String caption) {
        this.caption = caption == null ? null : caption.trim();
    }

    /**
     * 获取评论数
     *
     * @return comment_count - 评论数
     */
    public Integer getCommentCount() {
        return commentCount;
    }

    /**
     * 设置评论数
     *
     * @param commentCount 评论数
     */
    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    /**
     * 获取点赞数
     *
     * @return like_count - 点赞数
     */
    public Long getLikeCount() {
        return likeCount;
    }

    /**
     * 设置点赞数
     *
     * @param likeCount 点赞数
     */
    public void setLikeCount(Long likeCount) {
        this.likeCount = likeCount;
    }

    /**
     * 获取是否不能评论
     *
     * @return comments_disabled - 是否不能评论
     */
    public Boolean getCommentsDisabled() {
        return commentsDisabled;
    }

    /**
     * 设置是否不能评论
     *
     * @param commentsDisabled 是否不能评论
     */
    public void setCommentsDisabled(Boolean commentsDisabled) {
        this.commentsDisabled = commentsDisabled;
    }

    /**
     * 获取帖子发表时间戳
     *
     * @return taken_time - 帖子发表时间戳
     */
    public Long getTakenTime() {
        return takenTime;
    }

    /**
     * 设置帖子发表时间戳
     *
     * @param takenTime 帖子发表时间戳
     */
    public void setTakenTime(Long takenTime) {
        this.takenTime = takenTime;
    }

    /**
     * 获取地点id
     *
     * @return location_id - 地点id
     */
    public Long getLocationId() {
        return locationId;
    }

    /**
     * 设置地点id
     *
     * @param locationId 地点id
     */
    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    /**
     * 获取地点
     *
     * @return location_name - 地点
     */
    public String getLocationName() {
        return locationName;
    }

    /**
     * 设置地点
     *
     * @param locationName 地点
     */
    public void setLocationName(String locationName) {
        this.locationName = locationName == null ? null : locationName.trim();
    }

    /**
     * 获取帖子类型
     *
     * @return typename - 帖子类型
     */
    public String getTypename() {
        return typename;
    }

    /**
     * 设置帖子类型
     *
     * @param typename 帖子类型
     */
    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

    /**
     * 获取帖子来源类别
     *
     * @return product_type - 帖子来源类别
     */
    public String getProductType() {
        return productType;
    }

    /**
     * 设置帖子来源类别
     *
     * @param productType 帖子来源类别
     */
    public void setProductType(String productType) {
        this.productType = productType == null ? null : productType.trim();
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
     * 获取采集评论数
     *
     * @return collect_comments_count - 采集评论数
     */
    public Long getCollectCommentsCount() {
        return collectCommentsCount;
    }

    /**
     * 设置采集评论数
     *
     * @param collectCommentsCount 采集评论数
     */
    public void setCollectCommentsCount(Long collectCommentsCount) {
        this.collectCommentsCount = collectCommentsCount;
    }

    /**
     * 获取最近评论采集时间时间
     *
     * @return last_comment_collect_time - 最近评论采集时间时间
     */
    public Long getLastCommentCollectTime() {
        return lastCommentCollectTime;
    }

    /**
     * 设置最近评论采集时间时间
     *
     * @param lastCommentCollectTime 最近评论采集时间时间
     */
    public void setLastCommentCollectTime(Long lastCommentCollectTime) {
        this.lastCommentCollectTime = lastCommentCollectTime;
    }

    /**
     * 获取是否是广告帖
     *
     * @return is_ad - 是否是广告帖
     */
    public Boolean getIsAd() {
        return isAd;
    }

    /**
     * 设置是否是广告帖
     *
     * @param isAd 是否是广告帖
     */
    public void setIsAd(Boolean isAd) {
        this.isAd = isAd;
    }

    /**
     * 获取参与率
     *
     * @return er - 参与率
     */
    public Double getEr() {
        return er;
    }

    /**
     * 设置参与率
     *
     * @param er 参与率
     */
    public void setEr(Double er) {
        this.er = er;
    }
}