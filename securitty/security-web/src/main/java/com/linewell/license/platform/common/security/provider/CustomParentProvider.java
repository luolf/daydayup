package com.linewell.license.platform.common.security.provider;

import com.linewell.license.platform.security.facade.dto.UserRoleDto;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.HashSet;
import java.util.Set;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-15
 * Time 9:48
 */
public class CustomParentProvider {
    protected Set<GrantedAuthority> listUserGrantedAuthorities(Set<UserRoleDto> roles) {
        Set<GrantedAuthority> authorities = new HashSet<>();
        if (null==roles || roles.isEmpty()) {
            return authorities;
        }

        for(UserRoleDto role :roles){
            authorities.add(new SimpleGrantedAuthority(role.getRoleId().toString()));
        }
        return authorities;
    }
}
