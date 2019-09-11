package com.linewell.license.platform.security.facade.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author wusy
 * Company: 南威软件股份有限公司
 * Createtime : 2019-07-16 22:05
 * Description :
 */
public class OrgDto implements Comparable<OrgDto> {

    @ApiModelProperty("主键")
    private Long orgId;

    @ApiModelProperty("上级组织机构id")
    private Long parentOrgId;

    @ApiModelProperty("所属区域id")
    private Long belongAreaId;

    @ApiModelProperty("机构名称")
    private String orgName;

    @ApiModelProperty("机构简称")
    private String orgShortName;

    @ApiModelProperty("机构代码")
    private String orgCode;

    @ApiModelProperty("机构统一信用代码")
    private String orgCreditCode;

    @ApiModelProperty("排序")
    private Integer orgSort;

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

    @ApiModelProperty("父级id")
    private Long parentId;

    @ApiModelProperty("区域id")
    private Long areaId;

    @ApiModelProperty("区域名称")
    private String areaName;

    @ApiModelProperty("是否最后一级：0是，1否")
    private String lastLevel;

    @ApiModelProperty("父级名称")
    private String parentName;

    @ApiModelProperty("单位地址")
    private String orgAddress;

    @ApiModelProperty("单位电话")
    private String orgTelephone;

    @ApiModelProperty("负责人id")
    private Long orgHeadUserId;

    @ApiModelProperty("负责人名字")
    private String orgHeadUserName;

    @ApiModelProperty("行业类型")
    private String orgIndustryCategory;

    @ApiModelProperty("在本级之后关闭")
    private Long showLevel;

    @Override
    public int compareTo(OrgDto o) {
        //降序
        if(o.orgSort.equals(this.orgSort)){
            Long time = o.updateTime.getTime() - this.updateTime.getTime();
            return Integer.parseInt(String.valueOf(time));
        }else {
            return this.orgSort - o.orgSort;
        }
        //升序
//        return this.age - o.age;
    }

    public Long getShowLevel() {
        return showLevel;
    }

    public void setShowLevel(Long showLevel) {
        this.showLevel = showLevel;
    }

    public String getOrgAddress() {
        return orgAddress;
    }

    public void setOrgAddress(String orgAddress) {
        this.orgAddress = orgAddress;
    }

    public String getOrgTelephone() {
        return orgTelephone;
    }

    public void setOrgTelephone(String orgTelephone) {
        this.orgTelephone = orgTelephone;
    }

    public Long getOrgHeadUserId() {
        return orgHeadUserId;
    }

    public void setOrgHeadUserId(Long orgHeadUserId) {
        this.orgHeadUserId = orgHeadUserId;
    }

    public String getOrgHeadUserName() {
        return orgHeadUserName;
    }

    public void setOrgHeadUserName(String orgHeadUserName) {
        this.orgHeadUserName = orgHeadUserName;
    }

    public String getOrgIndustryCategory() {
        return orgIndustryCategory;
    }

    public void setOrgIndustryCategory(String orgIndustryCategory) {
        this.orgIndustryCategory = orgIndustryCategory;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getLastLevel() {
        return lastLevel;
    }

    public void setLastLevel(String lastLevel) {
        this.lastLevel = lastLevel;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Long getParentOrgId() {
        return parentOrgId;
    }

    public void setParentOrgId(Long parentOrgId) {
        this.parentOrgId = parentOrgId;
    }

    public Long getBelongAreaId() {
        return belongAreaId;
    }

    public void setBelongAreaId(Long belongAreaId) {
        this.belongAreaId = belongAreaId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgShortName() {
        return orgShortName;
    }

    public void setOrgShortName(String orgShortName) {
        this.orgShortName = orgShortName;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgCreditCode() {
        return orgCreditCode;
    }

    public void setOrgCreditCode(String orgCreditCode) {
        this.orgCreditCode = orgCreditCode;
    }

    public Integer getOrgSort() {
        return orgSort;
    }

    public void setOrgSort(Integer orgSort) {
        this.orgSort = orgSort;
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

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
