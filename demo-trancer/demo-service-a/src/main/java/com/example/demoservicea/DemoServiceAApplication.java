package com.example.demoservicea;

import com.example.dubboapi.ServiceA;
import com.example.dubboapi.ServiceB;
import com.example.dubboapi.ServiceC;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDubbo
public class DemoServiceAApplication {

    @Reference(check = false)
    ServiceA serviceA;
    @Reference(check = false)
    ServiceB serviceB;
    @Reference(check = false)
    ServiceC serviceC;
    public static void main(String[] args) {
        SpringApplication.run(DemoServiceAApplication.class, args);
    }

    @GetMapping(value = "/a-hi", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public String restSayHelloUseA(String name) {
        return "restSayHelloUseA:Thanks " + serviceA.sayHelloUseA(name)+ ", response form provider: " + RpcContext.getContext().getLocalAddress();
    }
    @GetMapping(value = "/a-moni", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public String restSayMoniUseA(String name) {
        return "restSayHelloUseA:Thanks " + serviceA.sayMoniUseA(name) + ", response form provider: " + RpcContext.getContext().getLocalAddress();
    }


}
