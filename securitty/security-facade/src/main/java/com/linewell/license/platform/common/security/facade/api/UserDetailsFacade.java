package com.linewell.license.platform.common.security.facade.api;

import com.linewell.license.platform.common.security.facade.dto.RolePermissionDto;
import com.linewell.license.platform.common.security.facade.dto.UserInfoDto;

import java.util.List;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-12
 * Time 14:19
 */
public interface UserDetailsFacade {
    public UserInfoDto findUserInfoByName(String userName);
    public List<RolePermissionDto> findAllPermissions();
}
