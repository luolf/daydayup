package org.llf.dubbo.test;

import com.linewell.license.ops.api.DemoService;
import com.linewell.license.roo.common.exception.core.RooBaseException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-05-09
 * Time 16:37
 */
public class TestInvocation2 {
    public static void main(String [] args){
        ClassPathXmlApplicationContext classPathXmlApplicationContext=new ClassPathXmlApplicationContext("classpath:consumer.xml");
        DemoService demoService =(DemoService) classPathXmlApplicationContext.getBean(DemoService.class);
        demoService.sayHello("error");

    }
    public  void hello(){
        throw new RooBaseException();
    }
}