package com.linewell.license.platform.common.security.service.provider;

import com.linewell.license.platform.common.security.facade.api.UserDetailsFacade;
import com.linewell.license.platform.common.security.facade.dto.RolePermissionDto;
import com.linewell.license.platform.common.security.facade.dto.SysRoleDto;
import com.linewell.license.platform.common.security.facade.dto.UserInfoDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-12
 * Time 19:34
 */
@Service
public class UserDetailsFacadeImpl implements UserDetailsFacade {

    private static List<RolePermissionDto> rolePermissionDtoList=new ArrayList<>(2);
    private static Map<String,UserInfoDto> userInfoDtoMap=new HashMap<>(3);
    static{
        UserInfoDto userInfoDto=new UserInfoDto();
        userInfoDto.setUsername("llf");
        userInfoDto.setPassword("llf");
        SysRoleDto sysRoleDto=new SysRoleDto();
        sysRoleDto.setRoleName("ROLE_ADMIN");
        sysRoleDto.setId(1000);
        List<SysRoleDto> roleList=new ArrayList<>(2);
        roleList.add(sysRoleDto);
        sysRoleDto=new SysRoleDto();
        sysRoleDto.setRoleName("ROLE_HA");
        sysRoleDto.setId(1001);
        roleList.add(sysRoleDto);
        userInfoDto.setRoleList(roleList);
        userInfoDtoMap.put(userInfoDto.getUsername(),userInfoDto);

          userInfoDto=new UserInfoDto();
        userInfoDto.setUsername("guest");
        userInfoDto.setPassword("guest");

        roleList.add(sysRoleDto);
        userInfoDto.setRoleList(roleList);
        userInfoDtoMap.put(userInfoDto.getUsername(),userInfoDto);

        userInfoDto=new UserInfoDto();
        userInfoDto.setUsername("nothing");
        userInfoDto.setPassword("guest");
        userInfoDtoMap.put(userInfoDto.getUsername(),userInfoDto);



        List<Integer> roles=new ArrayList<>(2);
        roles.add(1000);
        roles.add(1001);
        RolePermissionDto rolePermissionDto=new RolePermissionDto();
        rolePermissionDto.setUrl("user/findUsers");
        rolePermissionDto.setRoles(roles);
        rolePermissionDtoList.add(rolePermissionDto);
        roles=new ArrayList<>(1);
        roles.add(1000);
          rolePermissionDto=new RolePermissionDto();
        rolePermissionDto.setUrl("user/deleteUsers");
        rolePermissionDto.setRoles(roles);
        rolePermissionDtoList.add(rolePermissionDto);
    }
    @Override
    public UserInfoDto findUserInfoByName(String userName) {
        return userInfoDtoMap.get(userName);
    }

    @Override
    public List<RolePermissionDto> findAllPermissions() {

        return rolePermissionDtoList;
    }
}
