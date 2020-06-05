package org.study.llf.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2020-05-29
 * Time 9:22
 */
public class JdkProxyHandler2 implements InvocationHandler {
    private Object targetObject;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println(String.format("%s:执行 方法前 ",method.getName()));
        Object result = method.invoke(targetObject, args);
        System.out.println(String.format("%s:执行方法结果=%s ",method.getName(),result));
        System.out.println(String.format("%s:执行方法后 ",method.getName()));
        return result;
    }

    /**
     * 根据委托类动态产生代理类
     * @param targetObject 委托类对象
     * @return 代理类
     */
    public Object createPorxy(Object targetObject){
        this.targetObject = targetObject;
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader()
                ,targetObject.getClass().getInterfaces(),this);
    }
}