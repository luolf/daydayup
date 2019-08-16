package com.linewell.license.platform.common.security.author;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-13
 * Time 9:08
 */
@Component
public class UrlAccessDecisionManager implements AccessDecisionManager {
    @Override
    public void decide(Authentication auth, Object o, Collection<ConfigAttribute> cas){
        System.out.println("UrlAccessDecisionManager--------------------------------------------------"+o);
        System.out.println("UrlAccessDecisionManager auth--------------------------------------------------"+auth);
        System.out.println("UrlAccessDecisionManager cas--------------------------------------------------"+cas);


        AtomicBoolean pass= new AtomicBoolean(false);
        for(ConfigAttribute ca:cas){

            //当前请求需要的权限
            String needRole = ca.getAttribute();
            /**
             * 匿名可访问
             */
            if ("-1".equals(needRole)) {
                pass.set(true);
                break;
            }

            /**
             * 登陆可访问
             */
            if ("0".equals(needRole) && !(auth instanceof AnonymousAuthenticationToken)) {
                pass.set(true);
                break;
            }
            /**
             * 数据库未做授权配置
             */
            if ("ROLE_NONE".equals(needRole)  ) {
                throw new AccessDeniedException("未做授权配置!");
            }
        }

        if(pass.get()) {
            return;
        }
        if (auth instanceof AnonymousAuthenticationToken) {
//            throw new BadCredentialsException("请先登录");
            throw new AccessDeniedException("请先登录!");
        }
        Iterator<ConfigAttribute> iterator = cas.iterator();
        while (iterator.hasNext()) {
            ConfigAttribute ca = iterator.next();
            //当前请求需要的权限
            String needRole = ca.getAttribute();

            //当前用户所具有的角色
            Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
            for (GrantedAuthority authority : authorities) {
                if (authority.getAuthority().equals(needRole)) {
                    return;
                }
            }
        }


        throw new AccessDeniedException("权限不足o!");
    }
    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }
    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}