package com.gugee.ins.common.model.mysql.blogger;

import javax.persistence.*;

@Table(name = "ins_rel_blogger_active_follower")
public class InsRelBloggerActiveFollower {
    /**
     * id
     */
    @Id
    private Long id;

    /**
     * 博主id
     */
    private Long uid;

    /**
     * 活跃粉丝id
     */
    @Column(name = "f_uid")
    private Long fUid;

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
     * 获取活跃粉丝id
     *
     * @return f_uid - 活跃粉丝id
     */
    public Long getfUid() {
        return fUid;
    }

    /**
     * 设置活跃粉丝id
     *
     * @param fUid 活跃粉丝id
     */
    public void setfUid(Long fUid) {
        this.fUid = fUid;
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