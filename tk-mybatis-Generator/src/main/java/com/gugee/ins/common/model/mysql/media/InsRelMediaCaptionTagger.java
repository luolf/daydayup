package com.gugee.ins.common.model.mysql.media;

import javax.persistence.*;

@Table(name = "ins_rel_media_caption_tagger")
public class InsRelMediaCaptionTagger {
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
     * @的username
     */
    @Column(name = "caption_tagger_name")
    private String captionTaggerName;

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
     * 获取@的username
     *
     * @return caption_tagger_name - @的username
     */
    public String getCaptionTaggerName() {
        return captionTaggerName;
    }

    /**
     * 设置@的username
     *
     * @param captionTaggerName @的username
     */
    public void setCaptionTaggerName(String captionTaggerName) {
        this.captionTaggerName = captionTaggerName == null ? null : captionTaggerName.trim();
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