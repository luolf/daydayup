package com.linewell.license.platform.common.security.authen;

import com.linewell.license.platform.common.security.facade.api.UserDetailsFacade;
import com.linewell.license.platform.common.security.facade.dto.UserInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-12
 * Time 13:46
 */
@Component("customUserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserDetailsFacade userDetailsFacade;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserInfoDto userInfoDto= userDetailsFacade.findUserInfoByName(userName);
        if(userInfoDto==null){
            throw new UsernameNotFoundException("用户名不对");
        }
        return new JwtUserDetails(userInfoDto);
    }
}
