package org.study.llf.aop.dynamic1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-07-19
 * Time 11:23
 */
public class LogInvocationHandler implements InvocationHandler {

    private Object target;//目标对象

    public LogInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //执行织入的日志，你可以控制哪些方法执行切入逻辑
        if (method.getName().equals("doSomeThing2")) {
            System.out.println("开始调用doSomeThing2");
        }
        //执行原有逻辑
        Object recv = method.invoke(target, args);
        if (method.getName().equals("doSomeThing2")) {
            System.out.println("调用结束doSomeThing2");
        }
        return recv;
    }
}
