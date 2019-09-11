package com.linewell.license.platform.common.security.controller;

import com.linewell.license.platform.common.model.session.SessionContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-13
 * Time 9:08
 */
@RestController
public class RegLoginController {

    @RequestMapping("/login_p")
    public String login() {
        return  "controller返回:尚未登录，请登录!";
    }
    @GetMapping("/login")
    public String hello() {
        return "controller返回:GetMapping";
    }
    @PostMapping("/hello")
    public String hello2() {
        return "controller返回:PostMapping:"+ SessionContext.getSession();
    }
    @PostMapping("/user/findUsers")
    public String hello3() {

        return "findUsers controller返回:PostMapping";
    }

    @GetMapping("/user/edit")
    public String hello4() {
        return "edit controller返回:PostMapping";
    }

    @PostMapping("/user/delete")
    public String hello5() {
        return "delete controller返回:PostMapping"+ SessionContext.getSession();
    }
    @GetMapping("/user/delete")
    public String hello6() {
        return "GetMapping delete controller返回:PostMapping";
    }

}
