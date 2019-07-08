package com.linewell.license.ops.plugin.mysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-06-21
 * Time 9:40
 */
 @SpringBootApplication
public class ApplicationMain {
    public static void main(String[] args) {
        //解决netty冲突
//        System.setProperty("es.set.netty.runtime.available.processors", "false");
        SpringApplication.run(ApplicationMain.class, args);

    }
}
