package com.linewell.license.platform.common.security.authen;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.linewell.license.platform.common.security.facade.dto.SysRoleDto;
import com.linewell.license.platform.common.security.facade.dto.UserInfoDto;
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
    private final String username;
    private final String password;
    private final String userId;

    private final Date lastPasswordResetDate;
    private List<SysRoleDto> roleList ;

    public JwtUserDetails(UserInfoDto userInfoDto) {

        this.username = userInfoDto.getUsername();
        this.password = userInfoDto.getUsername();
        this.roleList = userInfoDto.getRoleList();
        this.userId = userInfoDto.getUserId();
        this.lastPasswordResetDate=null;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> authorities = new ArrayList<>();
        for (SysRoleDto role : roleList) {
            authorities.add(new SimpleGrantedAuthority(role.getId().toString()));
        }
        return authorities;
    }

    @JsonIgnore
    public String getUserId() {
        return userId;
    }
    @Override
    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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
        return true;
    }

    // 密码是否未过期
    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 账户是否激活
    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }

    // 这个是自定义的，返回上次密码重置日期
    @JsonIgnore
    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }
}
