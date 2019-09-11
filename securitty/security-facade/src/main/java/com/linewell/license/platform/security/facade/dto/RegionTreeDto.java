package com.linewell.license.platform.security.facade.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * File: RegionTreeDto.java
 * Description: 描述信息
 * Company: 南威软件股份有限公司
 * CreateTime: 2019/7/29
 *
 * @author wgaohua
 */
public class RegionTreeDto {

    public static final int AREA = 1;
    public static final int ORGANIZATION = 2;
    public static final int ORGANIZATION_AND_AREA = 3;
    public static final int ORGANIZATION_AND_AREA_AND_USER = 4;

    @ApiModelProperty("id")
    private String  id;

    @ApiModelProperty("父级id")
    private String pId;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("区域对象")
    private AreaDto areaDto;

    @ApiModelProperty("组织机构对象")
    private OrgDto orgDto;

    @ApiModelProperty("用户对象")
    private UserDto userDto;

    @ApiModelProperty("组织机构id")
    private Long orgId;

    @ApiModelProperty("用户id")
    private Long userId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AreaDto getAreaDto() {
        return areaDto;
    }

    public void setAreaDto(AreaDto areaDto) {
        this.areaDto = areaDto;
    }

    public OrgDto getOrgDto() {
        return orgDto;
    }

    public void setOrgDto(OrgDto orgDto) {
        this.orgDto = orgDto;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
