package com.example.demoserviceb;

import com.example.dubboapi.ServiceA;
import com.example.dubboapi.ServiceB;
import com.example.dubboapi.ServiceC;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.rpc.RpcContext;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-05-20
 * Time 9:48
 */
@Service
public class ServiceBImpl implements ServiceB {
    @Reference
    ServiceC serviceC;
    @Override
    public String sayHelloUseB(String name) {
        return "sayHelloUseB:Thanks [" + serviceC.sayHelloUseC(name) + "], response form provider: " + RpcContext.getContext().getLocalAddress();
    }

    @Override
    public String sayMoniUseB(String name) {
        return "sayMoniUseB:Thanks [" + serviceC.sayMoniUseC(name) + "], response form provider: " + RpcContext.getContext().getLocalAddress();
    }
}
