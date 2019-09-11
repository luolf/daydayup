package com.linewell.license.platform.security.facade.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

/**
 * @author mybatis-generator
 * Company: 南威软件股份有限公司
 * Create Time: 2019-07-29 10:05:11
 * Description: ls_system Model
 **/
public class SystemDto implements Comparable<SystemDto> {
    @ApiModelProperty("主键")
    private Long systemId;

    @ApiModelProperty("系统名称")
    private String systemName;

    @ApiModelProperty("系统简称")
    private String systemShortName;

    @ApiModelProperty("系统说明")
    private String systemDesc;

    @ApiModelProperty("系统首页")
    private String indexUrl;

    @ApiModelProperty("排序")
    private Integer sort;

    @ApiModelProperty("系统状态 1-启用 0-不启用")
    private Integer status;

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

    @ApiModelProperty("联系人ID列表")
    private List<Long> headUserIdList;

    @ApiModelProperty("联系人ID列表")
    private String headUserIds;

    @ApiModelProperty("联系人名称列表")
    private String headUserNames;

    @Override
    public int compareTo(SystemDto o) {
        //降序
        if(o.sort.equals(this.sort)){
            Long time = o.updateTime.getTime() - this.updateTime.getTime();
            return Integer.parseInt(String.valueOf(time));
        }else {
            return this.sort - o.sort;
        }
    }

    public Long getSystemId() {
        return systemId;
    }

    public void setSystemId(Long systemId) {
        this.systemId = systemId;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName == null ? null : systemName.trim();
    }

    public String getSystemShortName() {
        return systemShortName;
    }

    public void setSystemShortName(String systemShortName) {
        this.systemShortName = systemShortName == null ? null : systemShortName.trim();
    }

    public String getSystemDesc() {
        return systemDesc;
    }

    public void setSystemDesc(String systemDesc) {
        this.systemDesc = systemDesc == null ? null : systemDesc.trim();
    }

    public String getIndexUrl() {
        return indexUrl;
    }

    public void setIndexUrl(String indexUrl) {
        this.indexUrl = indexUrl == null ? null : indexUrl.trim();
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

    public List<Long> getHeadUserIdList() {
        return headUserIdList;
    }

    public void setHeadUserIdList(List<Long> headUserIdList) {
        this.headUserIdList = headUserIdList;
    }

    public String getHeadUserIds() {
        return headUserIds;
    }

    public void setHeadUserIds(String headUserIds) {
        this.headUserIds = headUserIds;
    }

    public String getHeadUserNames() {
        return headUserNames;
    }

    public void setHeadUserNames(String headUserNames) {
        this.headUserNames = headUserNames;
    }
}