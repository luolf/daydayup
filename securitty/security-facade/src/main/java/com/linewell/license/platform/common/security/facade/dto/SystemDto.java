package com.linewell.license.platform.common.security.facade.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author mybatis-generator
 * Company: 南威软件股份有限公司
 * Create Time: 2019-07-29 10:05:11
 * Description: ls_system Model
 **/
@Setter
@Getter
public class SystemDto {
    @ApiModelProperty("主键")
    private Long systemId;

    @ApiModelProperty("系统名称")
    private String systemName;

    @ApiModelProperty("系统简称")
    private String systemShortName;

    public SystemDto(Long systemId, String systemName, String systemShortName) {
        this.systemId = systemId;
        this.systemName = systemName;
        this.systemShortName = systemShortName;
    }
//    @ApiModelProperty("系统说明")
//    private String systemDesc;

//    @ApiModelProperty("系统首页")
//    private String indexUrl;

//    @ApiModelProperty("排序")
//    private Integer sort;

//    @ApiModelProperty("系统状态 1-启用 0-不启用")
//    private Integer status;
//
//    @ApiModelProperty("是否默认系统 1-默认 0-非默认")
//    private Integer isDefault;

//    @ApiModelProperty("是否删除 0-非删除 1-已删除")
//    private Integer isDeleted;

//    @ApiModelProperty("更新时间")
//    private Date updateTime;

//    @ApiModelProperty("更新人id")
//    private Long updateUserId;

//    @ApiModelProperty("更新人名称")
//    private String updateUserName;
//
//    @ApiModelProperty("创建时间")
//    private Date createTime;
//
//    @ApiModelProperty("创建人id")
//    private Long createUserId;
//
//    @ApiModelProperty("创建人名称")
//    private String createUserName;


}