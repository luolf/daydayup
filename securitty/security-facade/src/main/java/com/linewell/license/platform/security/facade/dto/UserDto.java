package com.linewell.license.platform.security.facade.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author wusy
 * Company: 南威软件股份有限公司
 * Createtime : 2019-07-16 22:05
 * Description :
 */
public class UserDto implements Serializable {

    @ApiModelProperty("用户id")
    private Long userId;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("姓名")
    private String nickName;

    @ApiModelProperty("身份证号码")
    private String identityNumber;

    @ApiModelProperty("性别")
    private Integer sex;

    @ApiModelProperty("排序")
    private Integer sort;

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("用户状态")
    private Integer status;

    @ApiModelProperty("锁定状态")
    private Integer lockStatus;

    @ApiModelProperty("用户密码")
    private String password;

    @ApiModelProperty("所属组织机构id")
    private Long belongOrgId;

    @ApiModelProperty("所属机构名称")
    private String belongOrgName;

    @ApiModelProperty("所属区域id")
    private Long belongAreaId;

    @ApiModelProperty("所属区域名称")
    private String belongAreaName;

    @ApiModelProperty("角色对象名")
    private String roleNames;

    @ApiModelProperty("工位对象名")
    private String workStationNames;


    @ApiModelProperty("用户关联的角色id")
    private String roleIds;

    @ApiModelProperty("用户关联的工位id")
    private String workStationIds;

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

    public String getWorkStationIds() {
        return workStationIds;
    }

    public void setWorkStationIds(String workStationIds) {
        this.workStationIds = workStationIds;
    }

    public String getRoleNames() {
        return roleNames;
    }

    public void setRoleNames(String roleNames) {
        this.roleNames = roleNames;
    }

    public String getWorkStationNames() {
        return workStationNames;
    }

    public void setWorkStationNames(String workStationNames) {
        this.workStationNames = workStationNames;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBelongOrgId() {
        return belongOrgId;
    }

    public void setBelongOrgId(Long belongOrgId) {
        this.belongOrgId = belongOrgId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBelongOrgName() {
        return belongOrgName;
    }

    public void setBelongOrgName(String belongOrgName) {
        this.belongOrgName = belongOrgName;
    }

    public Long getBelongAreaId() {
        return belongAreaId;
    }

    public void setBelongAreaId(Long belongAreaId) {
        this.belongAreaId = belongAreaId;
    }

    public String getBelongAreaName() {
        return belongAreaName;
    }

    public void setBelongAreaName(String belongAreaName) {
        this.belongAreaName = belongAreaName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getLockStatus() {
        return lockStatus;
    }

    public void setLockStatus(Integer lockStatus) {
        this.lockStatus = lockStatus;
    }
}
