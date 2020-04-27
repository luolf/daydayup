package org.llf.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URLClassLoader;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2020-03-04
 * Time 17:19
 */

//@SpringBootApplication

public class AppStart {
    public static void main(String[] args) {
//        SpringApplication.run(AppStart.class, args);
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`````");
        System.out.println(System.getProperty("java.ext.dirs"));


    }
}
