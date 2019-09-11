package com.linewell.license.platform.security.facade.service;

import com.linewell.license.platform.common.model.result.ResultObjectModel;
import com.linewell.license.platform.common.security.facade.constants.LogoutFailueType;
import com.linewell.license.platform.common.security.facade.dto.RolePermissionDto;
import com.linewell.license.platform.security.facade.constants.AuthenModeType;
import com.linewell.license.platform.security.facade.constants.AuthenticationFailureType;
import com.linewell.license.platform.security.facade.dto.*;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Set;

/**
 * 认证后续处理回调接口
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-21
 * Time 14:40
 */
public interface AuthenCallBackFacade {
    /**
     * Description
     * @return 返回值说明
     * @param principal 用户
     * @param authenMode 认证方式
     * @param failureMsg 失败原因
     * @author luolifeng
     * Date  2019/8/21
     */
    public void onAuthenticationFailure(PrincipalDto principal, AuthenModeType authenMode, AuthenticationFailureType failureMsg);
    /**
     * Description
     * @return 返回值说明
     * @param principal 用户
     * @param authenMode 认证方式
     * @author luolifeng
     * Date  2019/8/21
     */
    public void onAuthenticationSuccess(PrincipalDto principal, AuthenModeType authenMode);

    /**
     * 根据登录账户获取用户信息
     * @param userName 用户登录账户
     * @return 用户信息
     * @throws Exception
     */
    ResultObjectModel<UserDetailDto> findUserByUserName(String userName) ;

    /**
     * 根据电话号码获取用户信息
     * @param telephone 用户电话号码
     * @return 用户信息
     * @throws Exception
     */
    ResultObjectModel<UserDetailDto> findUserByTelephone(String telephone) ;

    /**
     * 根据用户id获取当前权限信息包括角色，菜单，以及拥有的url列表
     * @param userId 用户id
     * @return 当前权限信息包括角色，菜单，以及拥有的url列表
     * @throws Exception
     */
    ResultObjectModel<GrantedAuthorityDto> getGrantedAuthority(String userId)  ;
    /**
     * 获取url与角色的对应关系列表
     * @return url与角色的对应关系列表
     */
    public ResultObjectModel<Set<RolePermissionDto>> findAllPermissions() ;


    /**
     *  用户退出
     * @return
     */
    public void logout(PrincipalDto principal) ;
}
