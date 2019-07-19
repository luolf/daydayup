package org.llf.controller;

import org.llf.common.Result;
import org.llf.pojo.User;
import org.llf.service.UserMgrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-07-15
 * Time 9:32
 */
@RestController
@RequestMapping("/v1/sysMgr")
public class MySystemMgr {

    @Autowired
    UserMgrService userMgrService;

    @PostMapping("/user/add")
    public Result<String> saveUser(User user){
        System.out.println(user);
        return userMgrService.add(user);

    }
}
