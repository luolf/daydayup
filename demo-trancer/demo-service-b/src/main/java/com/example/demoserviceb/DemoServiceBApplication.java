package com.example.demoserviceb;

import com.example.dubboapi.ServiceA;
import com.example.dubboapi.ServiceB;
import com.example.dubboapi.ServiceC;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDubbo(scanBasePackages = {"com.example"})
public class DemoServiceBApplication {
    @Reference(check = false)
    ServiceA serviceA;
    @Reference(check = false)
    ServiceB serviceB;
    @Reference(check = false)
    ServiceC serviceC;
    public static void main(String[] args) {
//        new SpringApplicationBuilder(DemoServiceBApplication.class).web(WebApplicationType.NONE).run(args);
        SpringApplication.run(DemoServiceBApplication.class, args);
    }

    @GetMapping(value = "/b-hi", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public String restSayHelloUseB(String name) {
        return "restSayHelloUseB:Thanks [" + serviceC.sayHelloUseC(name) + "], response form provider: " + RpcContext.getContext().getLocalAddress();
    }
    @GetMapping(value = "/b-moni", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public String restSayMoniUseB(String name) {
        return "restSayHelloUseB:Thanks [" + serviceC.sayMoniUseC(name) + "], response form provider: " + RpcContext.getContext().getLocalAddress();
    }
}
