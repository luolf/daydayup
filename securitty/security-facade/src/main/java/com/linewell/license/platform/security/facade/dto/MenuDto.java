package com.linewell.license.platform.security.facade.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author wusy
 * Company: 南威软件股份有限公司
 * Createtime : 2019-07-16 22:05
 * Description :
 */
public class MenuDto implements Comparable<MenuDto> {

    @ApiModelProperty("主键")
    private Long menuId;

    @ApiModelProperty("系统id")
    private Long systemId;

    @ApiModelProperty("系统名称")
    private String systemName;

    @ApiModelProperty("父id")
    private Long parentMenuId;

    @ApiModelProperty("父名称")
    private String parentMenuName;

    @ApiModelProperty("菜单名称")
    private String menuName;

    @ApiModelProperty("菜单地址")
    private String menuUrl;

    @ApiModelProperty("菜单图片")
    private String menuImg;

    @ApiModelProperty("菜单类型 1 菜单 2按钮")
    private Integer menuCategor;

    @ApiModelProperty("菜单参数")
    private String menuData;

    @ApiModelProperty("菜单类型 1-普通菜单 2-内嵌网页")
    private Integer menuType;

    @ApiModelProperty("排序")
    private Integer sort;

    @ApiModelProperty("系统状态 1-启用 0-禁用")
    private Integer status;

    @ApiModelProperty("权限控制")
    private String permission;

    @ApiModelProperty("资源标准、目录数据、数据开放中在js和jsp绑定的值")
    private String domId;

    @ApiModelProperty("是否默认系统 1-默认 0-非默认")
    private Integer isDefault;

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

    @ApiModelProperty("是否最后一级：0是，1否")
    private String lastLevel;

    @ApiModelProperty("在本级之后关闭")
    private Long showLevel;

    @ApiModelProperty("是否属于系统")
    private String isSystem;

    @ApiModelProperty("该菜单下的按钮详情")
    private List<MenuDto> button;

    @ApiModelProperty("菜单下的按钮是否全选 1-普通选中，2-全选 ")
    private Integer type;

    @Override
    public int compareTo(MenuDto o) {
        //降序
        if(o.sort.equals(this.sort)){
            Long time = o.updateTime.getTime() - this.updateTime.getTime();
            return Integer.parseInt(String.valueOf(time));
        }else {
            return this.sort - o.sort;
        }
    }

    public Long getShowLevel() {
        return showLevel;
    }

    public void setShowLevel(Long showLevel) {
        this.showLevel = showLevel;
    }

    public String getLastLevel() {
        return lastLevel;
    }

    public void setLastLevel(String lastLevel) {
        this.lastLevel = lastLevel;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Long getSystemId() {
        return systemId;
    }

    public void setSystemId(Long systemId) {
        this.systemId = systemId;
    }

    public Long getParentMenuId() {
        return parentMenuId;
    }

    public void setParentMenuId(Long parentMenuId) {
        this.parentMenuId = parentMenuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getMenuImg() {
        return menuImg;
    }

    public void setMenuImg(String menuImg) {
        this.menuImg = menuImg;
    }

    public Integer getMenuCategor() {
        return menuCategor;
    }

    public void setMenuCategor(Integer menuCategor) {
        this.menuCategor = menuCategor;
    }

    public String getMenuData() {
        return menuData;
    }

    public void setMenuData(String menuData) {
        this.menuData = menuData;
    }

    public Integer getMenuType() {
        return menuType;
    }

    public void setMenuType(Integer menuType) {
        this.menuType = menuType;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getDomId() {
        return domId;
    }

    public void setDomId(String domId) {
        this.domId = domId;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
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
        this.updateUserName = updateUserName;
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
        this.createUserName = createUserName;
    }

    public String getIsSystem() {
        return isSystem;
    }

    public void setIsSystem(String isSystem) {
        this.isSystem = isSystem;
    }

    public String getParentMenuName() {
        return parentMenuName;
    }

    public void setParentMenuName(String parentMenuName) {
        this.parentMenuName = parentMenuName;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public List<MenuDto> getButton() {
        if(button == null){
            button = new ArrayList<MenuDto>();
        }
        return button;
    }

    public void setButton(List<MenuDto> button) {
        this.button = button;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
