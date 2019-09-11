package com.linewell.license.platform.security.facade.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * File: WorkStationDto.java
 * Description: 描述信息
 * Company: 南威软件股份有限公司
 * CreateTime: 2019/8/12
 *
 * @author wgaohua
 */
public class WorkStationDto implements Serializable {

    @ApiModelProperty("工位id")
    private Long workStationId;

    @ApiModelProperty("工位名称")
    private String workStationName;

    @ApiModelProperty("工位编码")
    private String workStationCode;

    @ApiModelProperty("工位说明")
    private String workStationDesc;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("用户id列表")
    private String userIds;

    @ApiModelProperty("用户所属机构列表")
    private String userBelongIds;

    public String getUserBelongIds() {
        return userBelongIds;
    }

    public void setUserBelongIds(String userBelongIds) {
        this.userBelongIds = userBelongIds;
    }

    public String getUserIds() {
        return userIds;
    }

    public void setUserIds(String userIds) {
        this.userIds = userIds;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getWorkStationId() {
        return workStationId;
    }

    public void setWorkStationId(Long workStationId) {
        this.workStationId = workStationId;
    }

    public String getWorkStationName() {
        return workStationName;
    }

    public void setWorkStationName(String workStationName) {
        this.workStationName = workStationName;
    }

    public String getWorkStationCode() {
        return workStationCode;
    }

    public void setWorkStationCode(String workStationCode) {
        this.workStationCode = workStationCode;
    }

    public String getWorkStationDesc() {
        return workStationDesc;
    }

    public void setWorkStationDesc(String workStationDesc) {
        this.workStationDesc = workStationDesc;
    }
}
