package com.linewell.license.platform.common.security.facade.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-12
 * Time 11:59
 */
@Setter
@Getter
public class SysRoleDto {
    /** id */
    private Integer id;

    /** 角色名称 */
    private String roleName;

    /** 备注 */
    private String remark;
}
