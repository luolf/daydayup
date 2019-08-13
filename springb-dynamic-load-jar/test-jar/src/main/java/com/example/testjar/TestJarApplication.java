package com.example.testjar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@SpringBootApplication
@ComponentScan(basePackages = {"org.llf.spb.plugin"})
public class TestJarApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestJarApplication.class, args);

    }

}
