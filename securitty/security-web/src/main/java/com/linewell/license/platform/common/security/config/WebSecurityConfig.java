package com.linewell.license.platform.common.security.config;

import com.linewell.license.platform.common.security.author.CustomMetadataSource;
import com.linewell.license.platform.common.security.authen.MyPasswordEncoder;
import com.linewell.license.platform.common.security.handler.AuthenticationAccessDeniedHandler;
import com.linewell.license.platform.common.security.author.UrlAccessDecisionManager;
import com.linewell.license.platform.common.security.handler.CustomAuthenticationFailureHandler;
import com.linewell.license.platform.common.security.handler.CustomAuthenticationSuccessHandler;
import com.linewell.license.platform.common.security.handler.CustomLogoutSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;



@Order(2147483643)
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    SecurityConfigBean securityConfigBean;

    /**
     * 默认实现有4个，和自定义实现，要区分
     */
    @Autowired
    @Qualifier("customUserDetailsService")
    UserDetailsService userDetailsService;
    @Autowired
    CustomMetadataSource customMetadataSource ;
    @Autowired
    UrlAccessDecisionManager urlAccessDecisionManager;
    @Autowired
    AuthenticationAccessDeniedHandler deniedHandler;

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService)
//                .passwordEncoder(new MyPasswordEncoder());
//    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(
                "/index.html",
                "/static/**",
                "/login_p",
                "/favicon.ico",
                "/css/**","/js/**","/image/**","/lib/**","/images/**","/img/**","/service/token",
                "/webapp/**","/META-INF/resources/**"
        );

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 允许对于网站静态资源的无授权访问
//                .antMatchers(
//                        HttpMethod.GET,
//                        "/",
//                        "/*.html",
//                        "/favicon.ico",
//                        "/**/*.html",
//                        "/**/*.css",
//                        "/**/*.js"
//                ).permitAll()

                // 对于获取token的rest api要允许匿名访问
                .antMatchers("/auth/**","/login").permitAll()
                // 除上面外的所有请求全部需要鉴权认证
                .anyRequest().authenticated()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <T extends FilterSecurityInterceptor> T postProcess(T o) {
                        o.setSecurityMetadataSource(customMetadataSource);
                        o.setAccessDecisionManager(urlAccessDecisionManager);
                        return o;
                    }
                 })
                .and()
                .formLogin()
                    .loginPage(securityConfigBean.getLoginPage())
                    .loginProcessingUrl(securityConfigBean.getLoginProcessingUrl())
                    .usernameParameter(securityConfigBean.getUsernameParameter()).passwordParameter(securityConfigBean.getPasswordParameter())
                    .failureHandler(new CustomAuthenticationFailureHandler())
                    .successHandler(new CustomAuthenticationSuccessHandler() )
                    .permitAll()
                .and()
                .logout()
                    .logoutUrl(securityConfigBean.getLogoutUrl())
                    .logoutSuccessHandler(new CustomLogoutSuccessHandler())
                    .permitAll()
                .and().csrf().disable()
                // 基于token，所以不需要session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .exceptionHandling().accessDeniedHandler(deniedHandler);
    }
}
