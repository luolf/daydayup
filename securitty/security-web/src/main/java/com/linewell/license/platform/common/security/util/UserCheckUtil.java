package com.linewell.license.platform.common.security.util;

import com.linewell.license.platform.common.model.session.SessionInfo;
import com.linewell.license.platform.common.security.authen.JwtUserDetails;
import com.linewell.license.platform.common.security.exception.ElsewhereLoginException;
import com.linewell.license.platform.common.security.exception.TokenExpiredException;
import com.linewell.license.platform.common.security.exception.TokenIllegalException;
import com.linewell.license.platform.common.security.exception.UnloginException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;

/**
 *  多种校验，每一种校验异常都需要清除redis中相应用户信息、token
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-29
 * Time 17:03
 */

public class UserCheckUtil {
    public static void checkToken(String redisTokenId,String authToken) {
        //用户未登录:用户非正常退出
        if(redisTokenId==null){
            throw new UnloginException("Token合法，用户未登录:用户非正常退出");
        }
        //用户在别处登录
        if(!redisTokenId.equals(JwtTokenUtil.getTokenId(authToken))){
            throw new ElsewhereLoginException("Token合法，用户已在别处登录！");
        }
    }

    public static SessionInfo checkToken(String authToken) {
        try {
            return JwtTokenUtil.parseToken(authToken);
        } catch (SignatureException | MalformedJwtException e) {
            throw new TokenIllegalException("非法token");
        } catch (ExpiredJwtException e) {
            throw new TokenExpiredException("token已过期");
        }
    }

    public static void checkUserState(JwtUserDetails jwtUserDetails) {

        if (!jwtUserDetails.isEnabled()) {
            throw new DisabledException("账户被禁用，请联系管理员!");
        }
        if (!jwtUserDetails.isAccountNonLocked()) {
            throw new LockedException("账户被锁定，请联系管理员!");
        }
        if (!jwtUserDetails.isAccountNonExpired()) {
            throw new AccountExpiredException("账户过期，请联系管理员!");
        }
    }
}
