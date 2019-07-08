package org.llf.dubbo.test;

import com.linewell.license.roo.common.exception.core.RooBaseException;

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
public class TestInvocation {
    public static void main(String [] args){
        A a=new A();
        a.setName("llf");

        B b=new B();
        b.setAge(62);
        b.setName("hh");


        System.out.println(b);
        A a1=(A)b;

        System.out.println(a1);
        B b1=(B)a1;
        System.out.println(b1);



//        try {
//            Class<?> clazz = Class.forName("org.llf.dubbo.test.TestInvocation");
//            Method method = clazz.getMethod("hello");
//            method.invoke(clazz.newInstance());
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SecurityException e) {
//            e.printStackTrace();
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (IllegalArgumentException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            System.out.println("此处接收被调用方法内部未被捕获的异常");
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        }


    }
    public  void hello(){
        throw new RooBaseException();
    }
}