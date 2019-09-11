package com.linewell.license.platform.common.security.service;

import com.linewell.license.platform.common.model.constants.security.SecurityConstants;
import com.linewell.license.platform.common.model.session.SessionInfo;
import com.linewell.license.platform.common.security.authen.JwtUserDetails;
import com.linewell.license.platform.common.security.exception.ElsewhereLoginException;
import com.linewell.license.platform.common.security.exception.TokenExpiredException;
import com.linewell.license.platform.common.security.exception.TokenIllegalException;
import com.linewell.license.platform.common.security.exception.UnloginException;
import com.linewell.license.platform.common.security.util.UserCheckUtil;
import com.linewell.license.platform.security.facade.dto.UserDetailDto;
import com.linewell.license.platform.security.facade.service.AuthenCallBackFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.stereotype.Service;

/**
 * 本地服务
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-29
 * Time 17:39
 */
@Service
public class UserCheckService {
    @Autowired
    AuthenCallBackFacade authenCallBackFacade;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    public SessionInfo checkUser(String authToken) {
        SessionInfo sessionInfo =null;
        UserDetailDto userDetailDto =null;

        try {
             sessionInfo = UserCheckUtil.checkToken(authToken);
            //查询数据库中用户信息，
             userDetailDto = authenCallBackFacade.findUserByUserName(sessionInfo.getUserName()).getData();
            UserCheckUtil.checkUserState(new JwtUserDetails(userDetailDto));
            String redisTokenId = redisTemplate.opsForValue().get(SecurityConstants.REDIS_TOKEN + sessionInfo.getUserId());
            UserCheckUtil.checkToken(redisTokenId, authToken);
            return sessionInfo;
        } catch (AccountExpiredException | LockedException | DisabledException e) {
            //账户过期 账户被锁定 账户被禁用
            if(sessionInfo!=null) {
                redisTemplate.delete(SecurityConstants.REDIS_TOKEN + sessionInfo.getUserId());
            }
        } catch (TokenExpiredException e) {
            //token已过期
        } catch (TokenIllegalException e) {
            //非法token
        } catch (ElsewhereLoginException e) {
            //用户已在别处登录

        } catch (UnloginException e) {
            //用户未登录:用户非正常退出
        }finally {
            return null;
        }
            //todo 构建异常抛出去
    }
}