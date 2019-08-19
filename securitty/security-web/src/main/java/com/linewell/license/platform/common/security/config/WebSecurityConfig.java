package com.linewell.license.platform.common.security.config;

import com.linewell.license.platform.common.security.author.CustomMetadataSource;
import com.linewell.license.platform.common.security.authen.MyPasswordEncoder;
import com.linewell.license.platform.common.security.filter.JwtAuthenticationTokenFilter;
import com.linewell.license.platform.common.security.filter.MobileCodeAuthenticationProcessingFilter;
import com.linewell.license.platform.common.security.handler.*;
import com.linewell.license.platform.common.security.author.UrlAccessDecisionManager;
import com.linewell.license.platform.common.security.provider.MobileCodeAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-13
 * Time 9:08
 */
@Order(2147483643)
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;
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
    CustomAuthenticationAccessDeniedHandler deniedHandler;

    @Autowired
    MyPasswordEncoder myPasswordEncoder;

    @Autowired
    MobileCodeAuthenticationProvider mobileCodeAuthenticationProvider;
    @Autowired
    CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
    @Autowired
   CustomAuthenticationFailureHandler customAuthenticationFailureHandler;

    /**
     * Description 未指定Provider后，则会有默认的实现
     * @return void 返回值说明
     * @param auth 参数说明
     * @author luolifeng
     * Date  2019/8/15
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) {

        auth.authenticationProvider(mobileCodeAuthenticationProvider)
        .authenticationProvider(daoAuthenticationProvider());
//        .userDetailsService(userDetailsService)
//                .passwordEncoder(myPasswordEncoder);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(
                "/index.html",
                "/static/**",
                "/login_p",
//                "/login",
//                "/mobileLogin",
                "/error",
                "/auth/**",
                "/favicon.ico",
                "/css/**",
                "/js/**",
                "/image/**",
                "/lib/**",
                "/images/**",
                "/img/**",
                "/service/token",
                "/webapp/**",
                "/META-INF/resources/**"
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

                // 对于获取token的rest api要允许匿名访问，没看到效果
//                .antMatchers("/auth/**","/auth/captcha/**","/login").permitAll()
                // 除上面外的所有请求全部需要鉴权认证
//                .anyRequest().authenticated()
//                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
//                    @Override
//                    public <T extends FilterSecurityInterceptor> T postProcess(T o) {
//                        o.setSecurityMetadataSource(customMetadataSource);
//                        o.setAccessDecisionManager(urlAccessDecisionManager);
//                        return o;
//                    }
//                 })
                .and()
                .formLogin()
                    .loginPage(securityConfigBean.getLoginPage())
                    .loginProcessingUrl(securityConfigBean.getLoginProcessingUrl())
                    .usernameParameter(securityConfigBean.getUsernameParameter()).passwordParameter(securityConfigBean.getPasswordParameter())
                    .failureHandler(customAuthenticationFailureHandler)
                    .successHandler(customAuthenticationSuccessHandler )
                    .permitAll()
                .and()
                .logout()
                    .logoutUrl(securityConfigBean.getLogoutUrl())
                    .logoutSuccessHandler(new CustomLogoutSuccessHandler())
                    .permitAll()
                .and().csrf().disable()
                // 基于token，所以不需要session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .exceptionHandling().accessDeniedHandler(deniedHandler).authenticationEntryPoint(customLoginUrlAuthenticationEntryPoint());

        http.addFilterBefore(mobileCodeAuthenticationProcessingFilter(), UsernamePasswordAuthenticationFilter.class);
        http.addFilterBefore(jwtAuthenticationTokenFilter(),UsernamePasswordAuthenticationFilter.class);
    }
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    @Bean
    public MobileCodeAuthenticationProcessingFilter mobileCodeAuthenticationProcessingFilter() {
        MobileCodeAuthenticationProcessingFilter filter = new MobileCodeAuthenticationProcessingFilter();
        filter.setAuthenticationManager(authenticationManager);
        filter.setAuthenticationSuccessHandler(customAuthenticationSuccessHandler);
        filter.setAuthenticationFailureHandler(customAuthenticationFailureHandler);

        return filter;
    }

    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() {
        return new JwtAuthenticationTokenFilter();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(myPasswordEncoder);

        return   daoAuthenticationProvider;
    }

    @Bean
    public AuthenticationEntryPoint customLoginUrlAuthenticationEntryPoint() {
        return new CustomLoginUrlAuthenticationEntryPoint(securityConfigBean.getLoginPage());
    }

}
