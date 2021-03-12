package com.gugee.ins.common.model.mysql.media;

import javax.persistence.*;

@Table(name = "ins_rel_media_sponsor_user")
public class InsRelMediaSponsorUser {
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
     * 博主的uid
     */
    private Long uid;

    /**
     * 赞助者的uid
     */
    @Column(name = "sponsor_uid")
    private Long sponsorUid;

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
     * 获取博主的uid
     *
     * @return uid - 博主的uid
     */
    public Long getUid() {
        return uid;
    }

    /**
     * 设置博主的uid
     *
     * @param uid 博主的uid
     */
    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * 获取赞助者的uid
     *
     * @return sponsor_uid - 赞助者的uid
     */
    public Long getSponsorUid() {
        return sponsorUid;
    }

    /**
     * 设置赞助者的uid
     *
     * @param sponsorUid 赞助者的uid
     */
    public void setSponsorUid(Long sponsorUid) {
        this.sponsorUid = sponsorUid;
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