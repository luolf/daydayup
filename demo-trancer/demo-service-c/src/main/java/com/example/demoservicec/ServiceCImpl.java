package com.example.demoservicec;

import com.example.dubboapi.ServiceA;
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
public class ServiceCImpl implements ServiceC {
    @Reference
    ServiceA serviceA;
    @Override
    public String sayHelloUseC(String name) {
        return "sayHelloUseC:Thanks " + name + ", response form provider: " + RpcContext.getContext().getLocalAddress();
    }

    @Override
    public String sayMoniUseC(String name) {
        return "sayMoniUseC:Thanks [" + serviceA.sayHelloUseA(name) + "], response form provider: " + RpcContext.getContext().getLocalAddress();
    }
}
