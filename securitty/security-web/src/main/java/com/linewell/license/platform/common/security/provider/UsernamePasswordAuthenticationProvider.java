//package com.linewell.license.platform.common.security.provider;
//
//import com.linewell.license.platform.security.facade.dto.UserDetailDto;
//import com.linewell.license.platform.security.facade.dto.UserRoleDto;
//import com.linewell.license.platform.security.facade.service.AuthenCallBackFacade;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//
//import java.util.HashSet;
//import java.util.Set;
//
//
///**
// * 可以使用自带的DaoAuthenticationProvider类，也可用使用该类来代替DaoAuthenticationProvider
// * 该类直接在内部做密码校验和身份信息查询
// * @author luolifeng
// * @version 1.0.0
// * Date 2019-08-14
// * Time 17:40
// */
//@Component
//public class UsernamePasswordAuthenticationProvider  extends CustomParentProvider  implements AuthenticationProvider{
//    @Autowired
//    AuthenCallBackFacade authenCallBackFacade;
//    @Autowired
//    @Qualifier("myPasswordEncoder")
//    private PasswordEncoder myPasswordEncoder;
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        String username = (authentication.getPrincipal() == null) ? "NONE_PROVIDED" : authentication.getName();
//        String password = (String) authentication.getCredentials();
//        if (StringUtils.isEmpty(password)) {
//            throw new BadCredentialsException("密码不能为空");
//        }
//        UserDetailDto userInfoDto = authenCallBackFacade.findUserByUserName(username).getData();
//        if (null == userInfoDto) {
//            throw new BadCredentialsException("用户不存在");
//        }
//
//        if (!myPasswordEncoder.matches(password,userInfoDto.getPassword())) {
//            throw new BadCredentialsException("用户名或密码不正确");
//        }
//
//        Set<UserRoleDto> roleList = new HashSet<>(userInfoDto.getRoles());
//        UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(username, password, listUserGrantedAuthorities(roleList));
//        result.setDetails(authentication.getDetails());
//        System.out.println("UsernamePasswordAuthenticationProvider:"+result);
//        return result;
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        System.out.println(this.getClass().getName() + "---supports");
//        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
//    }
//
//
//}