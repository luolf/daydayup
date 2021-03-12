package com.gugee.ins.common.model.mysql.media;

import javax.persistence.*;

@Table(name = "ins_rel_media_children")
public class InsRelMediaChildren {
    @Id
    private Long id;

    /**
     * 子帖子id
     */
    private Long mid;

    /**
     * 父帖子shortcode
     */
    @Column(name = "parent_shortcode")
    private String parentShortcode;

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
     * 帖子类型
     */
    private String typename;

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
     * 获取子帖子id
     *
     * @return mid - 子帖子id
     */
    public Long getMid() {
        return mid;
    }

    /**
     * 设置子帖子id
     *
     * @param mid 子帖子id
     */
    public void setMid(Long mid) {
        this.mid = mid;
    }

    /**
     * 获取父帖子shortcode
     *
     * @return parent_shortcode - 父帖子shortcode
     */
    public String getParentShortcode() {
        return parentShortcode;
    }

    /**
     * 设置父帖子shortcode
     *
     * @param parentShortcode 父帖子shortcode
     */
    public void setParentShortcode(String parentShortcode) {
        this.parentShortcode = parentShortcode == null ? null : parentShortcode.trim();
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