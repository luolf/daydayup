package org.study.llf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 * @author luolifeng
 * @version 1.0.0
 * Date 2020-04-27
 * Time 17:54
 */
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        System.out.println("启动服务完成。。。。");
    }
}
