package com.gugee.ins.common.model.mysql.media;

import javax.persistence.*;

@Table(name = "ins_rel_media_caption_tag")
public class InsRelMediaCaptionTag {
    /**
     * 不允许自增id
     */
    @Id
    private Long id;

    /**
     * 帖子编码
     */
    private String shortcode;

    /**
     * 内容里#后面的内容
     */
    @Column(name = "caption_tag")
    private String captionTag;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Long createTime;

    /**
     * 获取不允许自增id
     *
     * @return id - 不允许自增id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置不允许自增id
     *
     * @param id 不允许自增id
     */
    public void setId(Long id) {
        this.id = id;
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
     * 获取内容里#后面的内容
     *
     * @return caption_tag - 内容里#后面的内容
     */
    public String getCaptionTag() {
        return captionTag;
    }

    /**
     * 设置内容里#后面的内容
     *
     * @param captionTag 内容里#后面的内容
     */
    public void setCaptionTag(String captionTag) {
        this.captionTag = captionTag == null ? null : captionTag.trim();
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