package com.example.demoserviceb;

import com.example.dubboapi.ServiceA;
import com.example.dubboapi.ServiceB;
import com.example.dubboapi.ServiceC;
import com.linewell.license.roo.common.exception.core.RooBaseException;
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

    public String sayHelloUseB(String name) {
        try {
            return "sayHelloUseB:Thanks [" + serviceC.sayHelloUseC(name) + "], response form provider: " + RpcContext.getContext().getLocalAddress();
        } catch (RooBaseException e) {
            System.out.println("发生异常"+e.getErrMsg());
            return  e.getErrMsg();
        }
    }


    public String sayMoniUseB(String name) {
        return "sayMoniUseB:Thanks [" + serviceC.sayMoniUseC(name) + "], response form provider: " + RpcContext.getContext().getLocalAddress();
    }
}
