package com.example.demoservicea;

import com.example.dubboapi.ServiceA;
import com.example.dubboapi.ServiceB;
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
public class ServiceAImpl implements ServiceA {
    @Reference
    ServiceB serviceB;

    public String sayHelloUseA(String name) {

            return "sayHelloUseA:Thanks [" + serviceB.sayHelloUseB(name) + "], response form provider: " + RpcContext.getContext().getLocalAddress();

    }


    public String sayMoniUseA(String name) {
        return "sayMoniUseA:Thanks [" + serviceB.sayMoniUseB(name) + "], response form provider: " + RpcContext.getContext().getLocalAddress();
    }
}
