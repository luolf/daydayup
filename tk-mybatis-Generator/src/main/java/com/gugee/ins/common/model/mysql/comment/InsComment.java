package com.gugee.ins.common.model.mysql.comment;

import javax.persistence.*;

@Table(name = "ins_comment")
public class InsComment {
    /**
     * id
     */
    @Id
    private Long id;

    /**
     * 评论人的uid
     */
    @Column(name = "c_uid")
    private Long cUid;

    /**
     * 帖子所有者的uid
     */
    @Column(name = "m_uid")
    private Long mUid;

    /**
     * 帖子编码
     */
    private String shortcode;

    /**
     * 内容
     */
    private String text;

    /**
     * 评论创建时间
     */
    @Column(name = "created_at")
    private Long createdAt;

    /**
     * 活跃天
     */
    @Column(name = "week_day")
    private Byte weekDay;

    /**
     * 活跃小时
     */
    @Column(name = "day_hour")
    private Byte dayHour;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Long createTime;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取评论人的uid
     *
     * @return c_uid - 评论人的uid
     */
    public Long getcUid() {
        return cUid;
    }

    /**
     * 设置评论人的uid
     *
     * @param cUid 评论人的uid
     */
    public void setcUid(Long cUid) {
        this.cUid = cUid;
    }

    /**
     * 获取帖子所有者的uid
     *
     * @return m_uid - 帖子所有者的uid
     */
    public Long getmUid() {
        return mUid;
    }

    /**
     * 设置帖子所有者的uid
     *
     * @param mUid 帖子所有者的uid
     */
    public void setmUid(Long mUid) {
        this.mUid = mUid;
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
     * 获取内容
     *
     * @return text - 内容
     */
    public String getText() {
        return text;
    }

    /**
     * 设置内容
     *
     * @param text 内容
     */
    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    /**
     * 获取评论创建时间
     *
     * @return created_at - 评论创建时间
     */
    public Long getCreatedAt() {
        return createdAt;
    }

    /**
     * 设置评论创建时间
     *
     * @param createdAt 评论创建时间
     */
    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * 获取活跃天
     *
     * @return week_day - 活跃天
     */
    public Byte getWeekDay() {
        return weekDay;
    }

    /**
     * 设置活跃天
     *
     * @param weekDay 活跃天
     */
    public void setWeekDay(Byte weekDay) {
        this.weekDay = weekDay;
    }

    /**
     * 获取活跃小时
     *
     * @return day_hour - 活跃小时
     */
    public Byte getDayHour() {
        return dayHour;
    }

    /**
     * 设置活跃小时
     *
     * @param dayHour 活跃小时
     */
    public void setDayHour(Byte dayHour) {
        this.dayHour = dayHour;
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