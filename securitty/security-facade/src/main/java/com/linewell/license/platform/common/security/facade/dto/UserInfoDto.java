package com.linewell.license.platform.common.security.facade.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-12
 * Time 14:21
 */
@Setter
@Getter
@ToString
public class UserInfoDto {
    private String username;
    private String password;
    private String userId;

    private List<SysRoleDto> roleList = new ArrayList<>();
}
