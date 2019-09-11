package com.linewell.license.platform.security.facade.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * File: AreaDto.java
 * Description: 描述信息
 * Company: 南威软件股份有限公司
 * CreateTime: 2019/7/22
 *
 * @author wgaohua
 */
public class AreaDto implements Serializable {
    @ApiModelProperty("区域id")
    private Long areaId;

    @ApiModelProperty("父级区域id")
    private Long parentAreaId;

    @ApiModelProperty("区域名称")
    private String areaName;

    @ApiModelProperty("区域编码")
    private String areaCode;

    @ApiModelProperty("区域级别")
    private Integer areaLevel;

    @ApiModelProperty("区域类型")
    private Integer areaType;

    @ApiModelProperty("排序")
    private Integer areaSort;

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Long getParentAreaId() {
        return parentAreaId;
    }

    public void setParentAreaId(Long parentAreaId) {
        this.parentAreaId = parentAreaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public Integer getAreaLevel() {
        return areaLevel;
    }

    public void setAreaLevel(Integer areaLevel) {
        this.areaLevel = areaLevel;
    }

    public Integer getAreaType() {
        return areaType;
    }

    public void setAreaType(Integer areaType) {
        this.areaType = areaType;
    }

    public Integer getAreaSort() {
        return areaSort;
    }

    public void setAreaSort(Integer areaSort) {
        this.areaSort = areaSort;
    }
}
