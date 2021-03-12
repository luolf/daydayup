package com.gugee.ins.common.model.mysql.blogger;

import javax.persistence.*;

@Table(name = "ins_rel_blogger_following")
public class InsRelBloggerFollowing {
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
     * 被关注者id
     */
    @Column(name = "f_uid")
    private Long fUid;

    /**
     * 关注人类型（0:未录入;1:品牌;2:非品牌;3:录入但未调用更新接口）
     */
    @Column(name = "f_type")
    private Byte fType;

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
     * 获取被关注者id
     *
     * @return f_uid - 被关注者id
     */
    public Long getfUid() {
        return fUid;
    }

    /**
     * 设置被关注者id
     *
     * @param fUid 被关注者id
     */
    public void setfUid(Long fUid) {
        this.fUid = fUid;
    }

    /**
     * 获取关注人类型（0:未录入;1:品牌;2:非品牌;3:录入但未调用更新接口）
     *
     * @return f_type - 关注人类型（0:未录入;1:品牌;2:非品牌;3:录入但未调用更新接口）
     */
    public Byte getfType() {
        return fType;
    }

    /**
     * 设置关注人类型（0:未录入;1:品牌;2:非品牌;3:录入但未调用更新接口）
     *
     * @param fType 关注人类型（0:未录入;1:品牌;2:非品牌;3:录入但未调用更新接口）
     */
    public void setfType(Byte fType) {
        this.fType = fType;
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