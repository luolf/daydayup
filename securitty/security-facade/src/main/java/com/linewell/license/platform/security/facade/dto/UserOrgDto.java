package com.linewell.license.platform.security.facade.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author wusy
 * Company: 南威软件股份有限公司
 * Createtime : 2019/8/22 15:23
 * Description : 用户组织机构信息
 */
@Setter
@Getter
public class UserOrgDto {
    /**
     * 用户组织机构id
     */
    private Long orgId;
    /**
     * 用户组织机构名称
     */
    private String orgName;
}
