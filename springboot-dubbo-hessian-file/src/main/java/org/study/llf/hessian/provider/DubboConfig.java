package org.study.llf.hessian.provider;

import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.remoting.http.servlet.DispatcherServlet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * hessian 协议配置与注册
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-10-18
 * Time 10:44
 */

@Configuration
public class DubboConfig {

    @Value("${dubbo.custom.hessian.port:8081}")
    private String hessianPort;
    @Value("${dubbo.custom.servlet.contextpath:}")
    private String servletContextpath;
    @Bean(name = "hessian")
    public ProtocolConfig protocolConfig() {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setId("hessian");
        protocolConfig.setName("hessian");
        protocolConfig.setPort(8081);
        protocolConfig.setServer("servlet");
        protocolConfig.setContextpath(servletContextpath);
        return protocolConfig;
    }

    @Bean
    public ServletRegistrationBean<DispatcherServlet> servletRegistrationBean() {
        return new ServletRegistrationBean<>(new DispatcherServlet(), "/*");
    }
}