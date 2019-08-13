package com.example.demoservicec;

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
public class DemoServiceCApplication {
    @Reference(check = false)
    ServiceA serviceA;
    public static void main(String[] args) {
//        new SpringApplicationBuilder(DemoServiceCApplication.class).web(WebApplicationType.NONE).run(args);
        SpringApplication.run(DemoServiceCApplication.class, args);

    }

    @GetMapping(value = "/c-hi", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public String restSayHelloUseC(String name) {
        return "restSayMoniUseC:Thanks [" + serviceA.sayHelloUseA(name) + "], response form provider: " + RpcContext.getContext().getLocalAddress();
    }
    @GetMapping(value = "/c-moni", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public String restSayMoniUseC(String name) {
        return "restSayMoniUseC:Thanks [" + serviceA.sayMoniUseA(name) + "], response form provider: " + RpcContext.getContext().getLocalAddress();
    }
}
