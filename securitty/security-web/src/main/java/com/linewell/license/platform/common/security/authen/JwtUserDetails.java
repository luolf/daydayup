package com.linewell.license.platform.common.security.authen;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.linewell.license.platform.common.security.facade.dto.UserPrincipalDto;
import com.linewell.license.platform.security.facade.dto.UserDetailDto;
import com.linewell.license.platform.security.facade.dto.UserRoleDto;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-12
 * Time 11:54
 */
public class JwtUserDetails implements UserDetails {

    private static final long serialVersionUID = 133L;

    private UserPrincipalDto userPrincipal = new UserPrincipalDto();

    private Set<Long> roleList = new HashSet<>();
    private UserDetailDto userInfoDto = new UserDetailDto();
    private Long belongAreaId = -99L;
    private Long belongOrgId = -99L;

    public Long getBelongAreaId() {
        return belongAreaId;
    }

    public Long getBelongOrgId() {
        return belongOrgId;
    }
    public JwtUserDetails(UserDetailDto userInfoDto) {
        if (userInfoDto != null) {
            this.userInfoDto = userInfoDto;

            if(userInfoDto.getRoles()!=null && !userInfoDto.getRoles().isEmpty()){
                for(UserRoleDto userRoleDto:userInfoDto.getRoles()){
                    this.roleList.add(userRoleDto.getRoleId());
                }
            }
            UserPrincipalDto userPrincipalDto = new UserPrincipalDto();
            userPrincipalDto.setUsername(userInfoDto.getUserName());
            userPrincipalDto.setPhone(userInfoDto.getTelephone());
            userPrincipalDto.setUserId(userInfoDto.getUserId());
            userPrincipalDto.setRoleList(this.roleList);

            this.userPrincipal = userPrincipalDto;

            if(userInfoDto.getArea()!=null){
                this.belongAreaId= userInfoDto.getArea().getAreaId();
            }
            if(userInfoDto.getOrg()!=null){
                this.belongAreaId= userInfoDto.getOrg().getOrgId();
            }
        }

    }

    public Set<Long> getRoleList() {
        return roleList;
    }

    public UserDetailDto getUserInfoDto() {
        return userInfoDto;
    }

    public UserPrincipalDto getUserPrincipal() {
        return userPrincipal;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Long roleId : roleList) {
            authorities.add(new SimpleGrantedAuthority(roleId.toString()));
        }
        return authorities;
    }

    @JsonIgnore
    public Long getUserId() {
        return userInfoDto.getUserId();
    }

    @Override
    @JsonIgnore
    public String getPassword() {
        return userInfoDto.getPassword();
    }

    @Override
    public String getUsername() {
        return userInfoDto.getUserName();
    }

    // 账户是否未过期
    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {

        return true;
    }

    // 账户是否未锁定
    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return userInfoDto.getIsLock() == 0;
    }

    // spring security框架的前置密码是否未过期,在认证通过后再判断。
    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
//        return userInfoDto.getExpireTime() != null && userInfoDto.getExpireTime().after(new Date());
        return true;
    }

    //用户密码是否过期
    public boolean isPasswdExpired() {
        return userInfoDto.getExpireTime() != null && userInfoDto.getExpireTime().after(new Date());

    }
    // 账户是否激活
    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return userInfoDto.getEnabled() == 1;
    }


}
