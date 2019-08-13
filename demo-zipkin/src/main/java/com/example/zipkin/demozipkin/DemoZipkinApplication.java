package com.example.zipkin.demozipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class DemoZipkinApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoZipkinApplication.class, args);
    }

}
