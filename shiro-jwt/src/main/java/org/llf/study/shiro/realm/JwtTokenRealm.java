package org.llf.study.shiro.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * author: luolifeng
 * Date: 2019-03-18
 * Time: 15:33
 */
public class JwtTokenRealm   implements Realm {
    private static final Logger log = LoggerFactory.getLogger(JwtTokenRealm.class);
    public String getName() {
        return "JwtTokenRealm";
    }

    public boolean supports(AuthenticationToken authenticationToken) {
        return authenticationToken instanceof UsernamePasswordToken;
    }

    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //得到用户名 得到密码
        String username = (String)authenticationToken.getPrincipal();
        String password = new String((char[])authenticationToken.getCredentials());
        //如果用户名错误
        if(!"zhang".equals(username)) {
            throw new UnknownAccountException();
        }
        //如果密码错误
        if(!"1234".equals(password)) {
            throw new IncorrectCredentialsException();
        }
        //如果身份认证验证成功，返回一个AuthenticationInfo实现；
        log.info("************:{}","身份认证验证成功");
        return new SimpleAuthenticationInfo(username, password, getName());
    }
}

