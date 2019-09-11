package com.linewell.license.platform.common.security.provider;

import com.linewell.license.platform.common.model.constants.security.SecurityConstants;
import com.linewell.license.platform.common.security.authen.JwtUserDetails;
import com.linewell.license.platform.common.security.token.MidAuthenticationToken;
import com.linewell.license.platform.common.security.token.MobileCodeAuthenticationToken;
import com.linewell.license.platform.security.facade.dto.UserDetailDto;
import com.linewell.license.platform.security.facade.service.AuthenCallBackFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
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
    AuthenCallBackFacade authenCallBackFacade;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public Authentication authenticate(Authentication authentication)  {
        String mobile = (authentication.getPrincipal() == null) ? "NONE_PROVIDED" : authentication.getName();
        String code = (String) authentication.getCredentials();
        if (StringUtils.isEmpty(code)) {
            throw new BadCredentialsException("验证码不能为空");
        }
        UserDetailDto userDetailDto = authenCallBackFacade.findUserByTelephone(mobile).getData();
        if (null == userDetailDto) {
            throw new BadCredentialsException("用户不存在");
        }
        String key= SecurityConstants.REDIS_CODE_MOBILE + mobile;
        String captcha = redisTemplate.opsForValue().get(key);
        if (StringUtils.isEmpty(captcha) || !captcha.equalsIgnoreCase(code) ) {
            throw new BadCredentialsException("验证码不正确");
        }
        if(redisTemplate.hasKey(key)){
            redisTemplate.delete(key);
        }
        JwtUserDetails jwtUserDetails=new JwtUserDetails(userDetailDto);
        MidAuthenticationToken result = new MidAuthenticationToken(jwtUserDetails, code,jwtUserDetails.getAuthorities());
//        Set<UserRoleDto> roleList = new HashSet<>(userInfoDto.getRoles());
//        MobileCodeAuthenticationToken result = new MobileCodeAuthenticationToken(new UserPrincipal(userInfoDto.getUserName(),listUserGrantedAuthorities(roleList)), code, listUserGrantedAuthorities(roleList));
        result.setDetails(authentication.getDetails());
        return result;
    }

    @Override
    public boolean supports(Class<?> authentication) {

        return (MobileCodeAuthenticationToken.class.isAssignableFrom(authentication));
    }

}
