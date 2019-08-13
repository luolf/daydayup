package com.linewell.license.platform.common.security.facade.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-12
 * Time 14:57
 */
@Setter
@Getter
public class RolePermissionDto {
    public String url;
    public List<Integer> roles;
}
