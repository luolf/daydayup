package com.linewell.license.platform.common.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RegLoginController {
    @RequestMapping("/login_p")
    public String login() {
        return  "尚未登录，请登录!";
    }
    @GetMapping("/login")
    public String hello() {
        return "hello";
    }
    @GetMapping("/employee/basic/hello")
    public String basicHello() {
        return "basicHello";
    }
}
