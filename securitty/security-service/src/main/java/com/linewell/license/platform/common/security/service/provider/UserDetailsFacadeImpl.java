package com.linewell.license.platform.common.security.service.provider;

import com.linewell.license.platform.common.security.facade.api.UserDetailsFacade;
import com.linewell.license.platform.common.security.facade.dto.RolePermissionDto;
import com.linewell.license.platform.common.security.facade.dto.SysRoleDto;
import com.linewell.license.platform.common.security.facade.dto.SystemDto;
import com.linewell.license.platform.common.security.facade.dto.UserInfoDto;
import org.springframework.stereotype.Service;

import java.util.*;

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

    private static Set<RolePermissionDto> rolePermissionDtoList=new HashSet<>(2);
    private static Map<String,UserInfoDto> userInfoDtoMap=new HashMap<>(3);
    private static Map<String,UserInfoDto> phoneUserInfoDtoMap=new HashMap<>(3);
    static{
        UserInfoDto userInfoDto=new UserInfoDto();
        userInfoDto.setUsername("llf");
        userInfoDto.setPassword("llfpassword");
        userInfoDto.setPhone("17720719802");
        userInfoDto.setOrganization("组织机构1");

        SysRoleDto sysRoleDto=new SysRoleDto();
        sysRoleDto.setRoleName("ROLE_ADMIN");
        sysRoleDto.setId(1000);
        Set<SysRoleDto> roleList=new HashSet<>(2);

        roleList.add(sysRoleDto);

        userInfoDto.setRoleList(roleList);

        Set<SystemDto> systemDtos=new HashSet<>(1);
        systemDtos.add(new SystemDto(100L,"运维系统","运维"));
        userInfoDto.setSystemList(systemDtos);

        userInfoDtoMap.put(userInfoDto.getUsername(),userInfoDto);
        phoneUserInfoDtoMap.put(userInfoDto.getPhone(),userInfoDto);


          userInfoDto=new UserInfoDto();
        userInfoDto.setUsername("guest");
        userInfoDto.setPassword("guest");
        userInfoDto.setPhone("17720717802");
        userInfoDto.setOrganization("组织机构2");

                sysRoleDto=new SysRoleDto();
        sysRoleDto.setRoleName("ROLE_HA");
        sysRoleDto.setId(1001);

        roleList.add(sysRoleDto); ;
        userInfoDto.setRoleList(roleList);
        userInfoDto.setSystemList(systemDtos);

        userInfoDtoMap.put(userInfoDto.getUsername(),userInfoDto);
        phoneUserInfoDtoMap.put(userInfoDto.getPhone(),userInfoDto);

        userInfoDto=new UserInfoDto();
        userInfoDto.setUsername("nothing");
        userInfoDto.setPassword("guest");
        userInfoDto.setPhone("1234567890123");
        userInfoDto.setOrganization("组织机构3");
        userInfoDto.setSystemList(systemDtos);

        userInfoDtoMap.put(userInfoDto.getUsername(),userInfoDto);
        phoneUserInfoDtoMap.put(userInfoDto.getPhone(),userInfoDto);


      //所有的角色权限信息
        Set<Integer> anoyRoles=new HashSet<>(1);

        anoyRoles.add(-1);//匿名可访问标记
        RolePermissionDto rolePermissionDto=new RolePermissionDto();
        rolePermissionDto.setUrl("/user/findUsers");
        rolePermissionDto.setRoles(anoyRoles);
        rolePermissionDtoList.add(rolePermissionDto);


        Set<Integer> roles=new HashSet<>(2);
        roles.add(1000);
        roles.add(1001);
        RolePermissionDto rolePermissionDto2=new RolePermissionDto();
        rolePermissionDto2.setUrl("/user/findUsers");
        rolePermissionDto2.setRoles(roles);
        rolePermissionDtoList.add(rolePermissionDto);


        roles=new HashSet<>(1);
        roles.add(0);//登陆可访问标记
        rolePermissionDto=new RolePermissionDto();
        rolePermissionDto.setUrl("/user/edit");
        rolePermissionDto.setRoles(roles);
        rolePermissionDtoList.add(rolePermissionDto);

        roles=new HashSet<>(1);
        roles.add(1001);
        rolePermissionDto=new RolePermissionDto();
        rolePermissionDto.setUrl("/user/delete");
        rolePermissionDto.setRoles(roles);
        rolePermissionDtoList.add(rolePermissionDto);
    }
    @Override
    public UserInfoDto findUserInfoByName(String userName) {
        return userInfoDtoMap.get(userName);
    }
    @Override
    public UserInfoDto findUserInfoByPhone(String phone){
        return phoneUserInfoDtoMap.get(phone);
    }
    @Override
    public Set<RolePermissionDto> findAllPermissions() {

        return rolePermissionDtoList;
    }
}
