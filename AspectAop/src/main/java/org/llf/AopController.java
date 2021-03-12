package org.llf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: luolifeng
 * Date: 2021-01-11 19:27
 */

@RestController
@RequestMapping("/aop")
public class AopController {

    @RequestMapping("/test")
    public String testAop(String key){
        return "testAop: key = " + key;
    }

    @RequestMapping("testAfterThrowing")
    public String testAfterThrowing(String key){
        int a=1/0;
        return "1/0";
    }


    @RequestMapping("/testAround")
    public String testAround(String key){
        return "环绕通知：key = " + key;
    }
}
