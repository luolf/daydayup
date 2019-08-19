package com.linewell.license.platform.security.oauth2.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-19
 * Time 15:00
 */

@Configuration
@EnableWebSecurity
public class  WebSecurityConfig  extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

//        http.csrf().disable()//禁用了 csrf 功能
//                .authorizeRequests()//限定签名成功的请求
//                .antMatchers("/decision/**","/govern/**").hasAnyRole("USER","ADMIN")//对decision和govern 下的接口 需要 USER 或者 ADMIN 权限
//                .antMatchers("/admin/login").permitAll()///admin/login 不限定
//                .antMatchers("/admin/**").hasRole("ADMIN")//对admin下的接口 需要ADMIN权限
//                .antMatchers("/oauth/**").permitAll()//不拦截 oauth 开放的资源
//                .anyRequest().permitAll()//其他没有限定的请求，允许访问
//                .and().anonymous()//对于没有配置权限的其他请求允许匿名访问
//                .and().formLogin()//使用 spring security 默认登录页面
//                .and().httpBasic();//启用http 基础验证

        http.csrf().disable();//禁用了 csrf 功能
        http.requestMatchers()//使HttpSecurity接收以"/login/","/oauth/"开头请求。
                .antMatchers("/oauth/**", "/login/**", "/logout/**")
                .and()
                .authorizeRequests()
                .antMatchers("/oauth/**").authenticated()
                .and()
                .formLogin();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean() ;
    }
}
