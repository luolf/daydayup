package com.linewell.license.platform.common.security;

import com.linewell.license.platform.common.security.util.JwtTokenUti;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
public class SpringSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApplication.class, args);
    }
    @GetMapping("/hello")
    public String hello(){

        return JwtTokenUti.TOKEN_EXPIRED_TIME+"";
    }
}
