package com.linewell.license.platform.common.security.facade.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 用户核心主要信息
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-15
 * Time 16:20
 */
@Setter
@Getter
@ToString
public class UserPrincipalDto implements Serializable {
    public String username;
    public String organization;
    private String userId;
    private String phone;
    private Set<SysRoleDto> roleList =  new HashSet<>();
    private Set<SystemDto> systemList =  new HashSet<>();
}
