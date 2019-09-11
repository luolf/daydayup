package com.linewell.license.platform.common.security;

import com.linewell.license.platform.common.security.config.WebSecurityConfig;
import com.linewell.license.roo.common.web.SpringManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-12
 * Time 19:32
 */
@SpringBootApplication
@RestController
@ComponentScan(basePackages = {"com.linewell.license.platform.security.service.facade"})
@Import(WebSecurityConfig.class)
public class SpringSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApplication.class, args);

//        System.out.println(SpringManager.getBean("securityConfigBean"));
    }
    @GetMapping("/hello")
    public String hello(){

        return "刚分手的";
    }
}
