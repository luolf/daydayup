package com.example.demoservicec;

import com.example.dubboapi.ServiceA;
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
public class ServiceCImpl implements ServiceC {
//    @Reference
//    ServiceA serviceA;
    public ServiceCImpl(){
        ;
    }
    public ServiceCImpl(String s){
        this();
    }
    public String sayHelloUseC(String name) {
        if(name.equals("error")){
            RooBaseException rooBaseException= new RooBaseException();
            rooBaseException.setErrCode("234");
            rooBaseException.setErrMsg("sayHelloUseC");
            throw rooBaseException;
        }
        return "sayHelloUseC:Thanks " + name + ", response from provider: " + RpcContext.getContext().getLocalAddress();
    }


    public String sayMoniUseC(String name) {


        return "";
//        return "sayMoniUseC:Thanks [" + serviceA.sayHelloUseA(name) + "], response form provider: " + RpcContext.getContext().getLocalAddress();
    }



}


