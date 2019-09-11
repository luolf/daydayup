package com.linewell.license.platform.common.security.facade.dto;

import com.linewell.license.platform.security.facade.dto.UserRoleDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.HashSet;
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
    private Long userId;
    private String phone;
    private Set<Long> roleList =  new HashSet<>();
    private Set<Long> systemList =  new HashSet<>();
}
