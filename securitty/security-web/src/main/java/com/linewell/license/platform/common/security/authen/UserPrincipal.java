package com.linewell.license.platform.common.security.authen;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.linewell.license.platform.common.security.facade.dto.SysRoleDto;
import com.linewell.license.platform.common.security.facade.dto.UserInfoDto;
import com.linewell.license.platform.common.security.facade.dto.UserPrincipalDto;
import lombok.Getter;
import lombok.Setter;
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
@Setter
@Getter
public class UserPrincipal   {

    private static final long serialVersionUID = 133L;
    private final String username;
    private Collection<? extends GrantedAuthority> authorities ;


  public UserPrincipal(String username,Collection<? extends GrantedAuthority> authorities ){
      this.username=username;
      this.authorities=authorities;
  }


}
