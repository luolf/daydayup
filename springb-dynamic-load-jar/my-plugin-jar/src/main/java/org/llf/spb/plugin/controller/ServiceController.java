package org.llf.spb.plugin.controller;

import org.llf.spb.plugin.service.HelloWorld;
import org.llf.spb.plugin.util.TimeMgrUtil;
import org.llf.spb.plugin.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Date;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-04-18
 * Time 14:30
 */
@RestController
public class ServiceController {
    @Autowired
    HelloWorld helloWorld;

    @GetMapping(value = "/sayhello", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public String hi(User user) {
        System.out.println("GetMapping"+user);
        user.setUserName("GetMapping"+user.getUserName());
        try {
            user.setAge(TimeMgrUtil.dateTimeToDateString(new Date()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return user.toString();
    }

    @PostMapping(value = "/test", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public void test(User user) {
        try {
            System.out.println(TimeMgrUtil.dateTimeToDateString(new Date())+"PostMapping"+user);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
