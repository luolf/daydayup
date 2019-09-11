package com.linewell.license.platform.security.facade.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wusy
 * Company: 南威软件股份有限公司
 * Createtime : 2019/7/25 14:15
 * Description :区域或单位选择框数据模型
 */
public class RegionDto {

    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("父级id")
    private String pid;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("类型 1 区域 2单位")
    private Integer type;

    @ApiModelProperty("区域详情")
    private AreaDto area;

    @ApiModelProperty("组织机构详情")
    private OrgDto org;

    @ApiModelProperty("下级条目")
    private List<RegionDto> items = new ArrayList();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public AreaDto getArea() {
        return area;
    }

    public void setArea(AreaDto area) {
        this.area = area;
    }

    public OrgDto getOrg() {
        return org;
    }

    public void setOrg(OrgDto org) {
        this.org = org;
    }

    public List<RegionDto> getItems() {
        return items;
    }

    public void setItems(List<RegionDto> items) {
        this.items = items;
    }
}
