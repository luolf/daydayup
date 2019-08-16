package com.linewell.license.platform.common.security.provider;

import com.linewell.license.platform.common.security.authen.MyPasswordEncoder;
import com.linewell.license.platform.common.security.facade.api.UserDetailsFacade;
import com.linewell.license.platform.common.security.facade.dto.UserInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


/**
 * 可以使用自带的DaoAuthenticationProvider类，也可用使用该类来代替DaoAuthenticationProvider
 * 该类直接在内部做密码校验和身份信息查询
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-14
 * Time 17:40
 */
@Component
public class UsernamePasswordAuthenticationProvider  extends CustomParentProvider  implements AuthenticationProvider{
    @Autowired
    private UserDetailsFacade userDetailsFacade;
    @Autowired
    private MyPasswordEncoder myPasswordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = (authentication.getPrincipal() == null) ? "NONE_PROVIDED" : authentication.getName();
        String password = (String) authentication.getCredentials();
        if (StringUtils.isEmpty(password)) {
            throw new BadCredentialsException("密码不能为空");
        }
        UserInfoDto userInfoDto = userDetailsFacade.findUserInfoByName(username);
        if (null == userInfoDto) {
            throw new BadCredentialsException("用户不存在");
        }

        if (!myPasswordEncoder.matches(password,userInfoDto.getPassword())) {
            throw new BadCredentialsException("用户名或密码不正确");
        }
        UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(username, password, listUserGrantedAuthorities(userInfoDto.getRoleList()));
        result.setDetails(authentication.getDetails());
        return result;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        System.out.println(this.getClass().getName() + "---supports");
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }


}