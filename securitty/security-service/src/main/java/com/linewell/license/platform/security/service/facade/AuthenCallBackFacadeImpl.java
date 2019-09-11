package com.linewell.license.platform.security.service.facade;

import com.linewell.license.platform.common.model.result.ResultObjectModel;
import com.linewell.license.platform.common.security.facade.constants.LogoutFailueType;
import com.linewell.license.platform.common.security.facade.dto.RolePermissionDto;
import com.linewell.license.platform.security.facade.constants.AuthenModeType;
import com.linewell.license.platform.security.facade.constants.AuthenticationFailureType;
import com.linewell.license.platform.security.facade.dto.*;
import com.linewell.license.platform.security.facade.service.AuthenCallBackFacade;

import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author wusy
 * Company: 南威软件股份有限公司
 * Createtime : 2019/8/22 11:34
 * Description :
 */
@Service
public class AuthenCallBackFacadeImpl implements AuthenCallBackFacade {
    private static Set<RolePermissionDto> rolePermissionDtoList = new HashSet<>(2);
    private static Map<String, UserDetailDto> userInfoDtoMap = new HashMap<>(3);
    private static Map<String, UserDetailDto> phoneUserInfoDtoMap = new HashMap<>(3);


    static Date unlockTime;
    static String passwd = "$2a$10$joUZZKzNMxP00YR8cuzzpOu1wpQyW/SKox1xk1honVIp9gDGL4PIO";
    static int loginFailNum = 1;
    static int locked = 1;
    static int unlock = 0;
    static int lockState = unlock;
    static Date expireTime;


    static {

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MINUTE, -5);
        unlockTime = cal.getTime();

        cal.setTime(new Date());
        cal.add(Calendar.MINUTE, 1);
        expireTime = cal.getTime();

        List<UserRoleDto> simpleRoles = new ArrayList<>();
        UserRoleDto role = new UserRoleDto();
        role.setRoleId(1000L);
        role.setRoleName("ROLE_ADMIN");
        simpleRoles.add(role);
          role = new UserRoleDto();
        role.setRoleId(2000L);
        role.setRoleName("ROLE_ADMIN2");
        simpleRoles.add(role);



        //---------------llf-----ROLE_ADMIN(1000L)--------
        UserDetailDto detail = new UserDetailDto();
        detail.setUserName("llf");
        detail.setUserId(110L);
        detail.setUnlockTime(unlockTime);
        detail.setTelephone("17720719802");
        detail.setPassword(passwd);
        detail.setLoginFailNum(loginFailNum);
        detail.setIsLock(lockState);
        detail.setExpireTime(expireTime);
        detail.setEnabled(1);
        detail.setRoles(simpleRoles);
        userInfoDtoMap.put(detail.getUserName(), detail);
        phoneUserInfoDtoMap.put(detail.getTelephone(), detail);
        //---------------guest------none(1001)-------

        simpleRoles = new ArrayList<>();
        role = new UserRoleDto();
        role.setRoleId(1001L);
        role.setRoleName("ROLE_HA");
        simpleRoles.add(role);

        detail = new UserDetailDto();
        detail.setUserName("guest");
        detail.setUserId(120L);
        detail.setUnlockTime(unlockTime);
        detail.setTelephone("17720719801");
        detail.setPassword(passwd);
        detail.setLoginFailNum(loginFailNum);
        detail.setIsLock(lockState);
        detail.setExpireTime(expireTime);
        detail.setEnabled(0);
        detail.setRoles(simpleRoles);
        userInfoDtoMap.put(detail.getUserName(), detail);
        phoneUserInfoDtoMap.put(detail.getTelephone(), detail);


        //所有的角色权限信息
        Set<Integer> anoyRoles = new HashSet<>(1);

        anoyRoles.add(-1);//匿名可访问标记
        RolePermissionDto rolePermissionDto = new RolePermissionDto();
        rolePermissionDto.setUrl("/user/findUsers");
        rolePermissionDto.setRoles(anoyRoles);
        rolePermissionDtoList.add(rolePermissionDto);


        Set<Integer> roles = new HashSet<>(2);
        roles.add(1000);
        roles.add(1001);
        RolePermissionDto rolePermissionDto2 = new RolePermissionDto();
        rolePermissionDto2.setUrl("/user/findUsers");
        rolePermissionDto2.setRoles(roles);
        rolePermissionDtoList.add(rolePermissionDto);


        roles = new HashSet<>(1);
        roles.add(0);//登陆可访问标记
        rolePermissionDto = new RolePermissionDto();
        rolePermissionDto.setUrl("/user/edit");
        rolePermissionDto.setRoles(roles);
        rolePermissionDtoList.add(rolePermissionDto);

        roles = new HashSet<>(1);
        roles.add(1001);
        roles.add(1000);

        rolePermissionDto = new RolePermissionDto();
        rolePermissionDto.setUrl("/user/delete");
        rolePermissionDto.setRoles(roles);
        rolePermissionDtoList.add(rolePermissionDto);


    }

    @Override
    public void onAuthenticationFailure(PrincipalDto principal, AuthenModeType authenMode, AuthenticationFailureType failureMsg) {
        System.out.println("onAuthenticationFailure call back");
    }

    @Override
    public void onAuthenticationSuccess(PrincipalDto principal, AuthenModeType authenMode) {
        System.out.println("onAuthenticationSuccess call back");
    }

    @Override
    public ResultObjectModel<UserDetailDto> findUserByUserName(String userName)  {
        return ResultObjectModel.success(userInfoDtoMap.get(userName));
    }

    @Override
    public ResultObjectModel<UserDetailDto> findUserByTelephone(String telephone)  {

        return ResultObjectModel.success(phoneUserInfoDtoMap.get(telephone));
    }

    @Override
    public ResultObjectModel<GrantedAuthorityDto> getGrantedAuthority(String userId) {
        return null;
    }

    @Override
    public ResultObjectModel<Set<RolePermissionDto>> findAllPermissions() {
        return ResultObjectModel.success(rolePermissionDtoList);
    }
    public void logout(PrincipalDto principal){

    }
}
