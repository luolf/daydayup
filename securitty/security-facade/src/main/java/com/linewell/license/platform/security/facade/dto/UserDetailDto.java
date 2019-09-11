package com.linewell.license.platform.security.facade.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author wusy
 * Company: 南威软件股份有限公司
 * Createtime : 2019/8/22 14:25
 * Description :
 */
@Setter
@Getter
public class UserDetailDto implements Serializable {
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 用户账户
     */
    private String userName;
    /**
     * 用户账户
     */
    private String password;
    /**
     * 用户手机号码
     */
    private String telephone;
    /**
     * 用户密码过期时间
     */
    private Date expireTime;
    /**
     * 用户是否启用 0不启用 1-启用
     */
    private Integer enabled;
    /**
     * 用户锁定状态 0-未锁定 1-已锁定
     */
    private Integer isLock;

    /**
     * 用户锁定状态 1 初始状态  1非初始状态
     */
    private Integer initial;
    /**
     * 解锁时间
     */
    private Date unlockTime;
    /**
     * 用户登录失败次数
     */
    private Integer loginFailNum;
    /**
     * 用户角色信息
     */
    private List<UserRoleDto> roles;

    /**
     * 用户组织机构
     */
    private UserOrgDto org;

    /**
     * 用户区域信息
     */
    private UserAreaDto area;

}
