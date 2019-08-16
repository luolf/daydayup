package com.linewell.license.platform.common.security.provider;

import com.linewell.license.platform.common.security.authen.UserPrincipal;
import com.linewell.license.platform.common.security.facade.api.UserDetailsFacade;
import com.linewell.license.platform.common.security.facade.dto.UserInfoDto;
import com.linewell.license.platform.common.security.facade.dto.UserPrincipalDto;
import com.linewell.license.platform.common.security.token.MobileCodeAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


/**
 * 手机短信验证码 验证逻辑提供者
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-14
 * Time 17:06
 */
@Component
public class MobileCodeAuthenticationProvider  extends CustomParentProvider  implements AuthenticationProvider {
    @Autowired
    private UserDetailsFacade userDetailsFacade;


    @Override
    public Authentication authenticate(Authentication authentication)  {
        String mobile = (authentication.getPrincipal() == null) ? "NONE_PROVIDED" : authentication.getName();
        String code = (String) authentication.getCredentials();
        if (StringUtils.isEmpty(code)) {
            throw new BadCredentialsException("验证码不能为空");
        }
        UserInfoDto userInfoDto = userDetailsFacade.findUserInfoByPhone(mobile);
        if (null == userInfoDto) {
            throw new BadCredentialsException("用户不存在");
        }

        // 手机号验证码业务还没有开发，先用4个0验证
        if (!code.equals("0000")) {
            throw new BadCredentialsException("验证码不正确");
        }

        MobileCodeAuthenticationToken result = new MobileCodeAuthenticationToken(new UserPrincipal(userInfoDto.getUsername(),listUserGrantedAuthorities(userInfoDto.getRoleList())), code, listUserGrantedAuthorities(userInfoDto.getRoleList()));
        result.setDetails(authentication.getDetails());
        return result;
    }

    @Override
    public boolean supports(Class<?> authentication) {

        return (MobileCodeAuthenticationToken.class.isAssignableFrom(authentication));
    }

}
