package com.linewell.license.platform.security.facade.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author mybatis-generator
 * Company: 南威软件股份有限公司
 * Create Time: 2019-08-02 09:18:26
 * Description: ls_role_menu Model
 **/
public class RoleMenuDto implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty("主键")
    private Long id;
    @ApiModelProperty("角色id")
    private Long roleId;
    @ApiModelProperty("菜单id")
    private Long menuId;
    @ApiModelProperty("是否删除 0-非删除 1-已删除")
    private Integer isDeleted;
    @ApiModelProperty("更新时间")
    private Date updateTime;
    @ApiModelProperty("更新人id")
    private Long updateUserId;
    @ApiModelProperty("更新人名称")
    private String updateUserName;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("创建人id")
    private Long createUserId;
    @ApiModelProperty("创建人名称")
    private String createUserName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName == null ? null : updateUserName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof RoleMenuDto) {
            return ((RoleMenuDto) obj).getRoleId().equals(this.getRoleId()) && ((RoleMenuDto) obj).getMenuId().equals(this.getMenuId());
        }
        return super.equals(obj);
    }
}