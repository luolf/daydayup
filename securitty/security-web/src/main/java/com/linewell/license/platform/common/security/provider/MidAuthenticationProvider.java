package com.linewell.license.platform.common.security.provider;

import com.linewell.license.platform.common.model.constants.security.SecurityConstants;
import com.linewell.license.platform.common.security.authen.JwtUserDetails;
import com.linewell.license.platform.common.security.bean.MidLoginInfoBo;
import com.linewell.license.platform.common.security.exception.BadCaptchaException;
import com.linewell.license.platform.common.security.exception.BadSmsCodeException;
import com.linewell.license.platform.common.security.token.MidAuthenticationToken;
import com.linewell.license.platform.security.facade.dto.UserDetailDto;
import com.linewell.license.platform.security.facade.service.AuthenCallBackFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;


/**
 * 手机短信验证码 验证逻辑提供者
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-14
 * Time 17:06
 */

public class MidAuthenticationProvider extends CustomParentProvider implements AuthenticationProvider {
    @Autowired
    AuthenCallBackFacade authenCallBackFacade;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    @Qualifier("myPasswordEncoder")
    private PasswordEncoder myPasswordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) {
        String account = (authentication.getPrincipal() == null) ? "NONE_PROVIDED" : authentication.getName();
        MidLoginInfoBo loginInfo = (MidLoginInfoBo) authentication.getPrincipal();
        UserDetailDto userDetailDto = authenCallBackFacade.findUserByUserName(account).getData();

        checkLogin(loginInfo, userDetailDto);
        MidAuthenticationToken result = checkUser(account, userDetailDto);
        result.setDetails(authentication.getDetails());
        return result;
    }

    /**
     * 登陆信息的校验
     * @param loginInfo
     * @param userDetailDto
     */
    private void checkLogin(MidLoginInfoBo loginInfo, UserDetailDto userDetailDto) {

        if (null == userDetailDto) {
            throw new BadCredentialsException("用户不存在");
        }
        System.out.println(loginInfo);
        String smsCodeKey = SecurityConstants.REDIS_CODE_MOBILE + userDetailDto.getTelephone();
        String smsCode = redisTemplate.opsForValue().get(smsCodeKey);
        if (redisTemplate.hasKey(smsCodeKey)) {
            redisTemplate.delete(smsCodeKey);
        }
        if (loginInfo.getIsNeedCaptcha()) {
            String captchaKey = SecurityConstants.REDIS_CODE_CAPTCHA + loginInfo.getCaptchaId();
            String captcha = redisTemplate.opsForValue().get(captchaKey);
            if (redisTemplate.hasKey(captchaKey)) {
                redisTemplate.delete(captchaKey);
            }
            if (StringUtils.isEmpty(loginInfo.getCaptcha())) {
                throw new BadCaptchaException("图片验证码不能为空");
            }
            if (StringUtils.isEmpty(captcha) || !captcha.equalsIgnoreCase(loginInfo.getCaptcha())) {
                throw new BadCaptchaException("图片验证码不正确");
            }
        }
        if (StringUtils.isEmpty(loginInfo.getSmsCode())) {
            throw new BadSmsCodeException("短信验证码不能为空");
        }

        if (StringUtils.isEmpty(smsCode) || !smsCode.equalsIgnoreCase(loginInfo.getSmsCode())) {
            throw new BadSmsCodeException("短信验证码不正确");
        }
        if (!myPasswordEncoder.matches(loginInfo.getPasswd(), userDetailDto.getPassword())) {
            throw new BadCredentialsException("用户名或密码不正确");
        }

    }

    /**
     * 检查用户在数据库中的状态
     * @param account
     * @param userDetailDto
     * @return
     */
    private MidAuthenticationToken checkUser(String account, UserDetailDto userDetailDto) {

        JwtUserDetails jwtUserDetails = new JwtUserDetails(userDetailDto);
        if (!jwtUserDetails.isEnabled()) {
            throw new RuntimeException(account + "账户已禁用");
        }
        if (!jwtUserDetails.isAccountNonLocked()) {
            throw new RuntimeException(account + "账户已锁定");
        }
        if (!jwtUserDetails.isAccountNonExpired()) {
            throw new RuntimeException(account + "账户已过期");
        }
        return new MidAuthenticationToken(jwtUserDetails, jwtUserDetails.getPassword(), jwtUserDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {

        return (MidAuthenticationToken.class.isAssignableFrom(authentication));
    }

}
