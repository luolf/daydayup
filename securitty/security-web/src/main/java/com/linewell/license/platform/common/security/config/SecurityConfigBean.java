package com.linewell.license.platform.common.security.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-13
 * Time 10:09
 */

@Component
@PropertySource(value = { "classpath:securityConfig.properties" })
@ConfigurationProperties(prefix="license.security.form")
@Getter
@Setter
@ToString
public class SecurityConfigBean {

    /**
     * 表单登录页面地址
     */
    private String loginPage;

    /**form表单POST请求url提交地址，默认为/login
     * 指定让UsernamePasswordAuthenticationFilter拦截器拦截的路径
     */
    private String loginProcessingUrl;

    /**
     * form表单用户名参数名
     */
    private String usernameParameter;


    /**
     * form表单密码参数名
     */
    private String passwordParameter;
    private String logoutUrl;


    /**
     * token过期步长，单位秒
     */
    private long    tokenExpired;

    /**
     * 记住我时token过期步长，单位秒
     */
    private long    tokenExpiredRemember;
}
