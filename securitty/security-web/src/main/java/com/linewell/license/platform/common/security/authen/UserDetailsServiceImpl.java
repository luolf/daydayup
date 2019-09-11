package com.linewell.license.platform.common.security.authen;

import com.linewell.license.platform.security.facade.dto.UserDetailDto;
import com.linewell.license.platform.security.facade.service.AuthenCallBackFacade;
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
   AuthenCallBackFacade authenCallBackFacade;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserDetailDto userDetailDto= authenCallBackFacade.findUserByUserName(userName).getData();
        if(userDetailDto==null){
            throw new UsernameNotFoundException("用户名不对");
        }
         return new JwtUserDetails(userDetailDto);
    }
}
