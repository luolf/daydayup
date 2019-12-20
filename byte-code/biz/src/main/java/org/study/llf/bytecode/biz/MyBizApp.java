package org.study.llf.bytecode.biz;

import org.study.llf.bytecode.biz.HelloWorld;

import java.lang.management.ManagementFactory;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-12-20
 * Time 18:02
 */
public class MyBizApp {
    public static void main(String[] args) {
        String name = ManagementFactory.getRuntimeMXBean().getName();
        String s = name.split("@")[0];
        //打印当前Pid
        System.out.println("pid:"+s);
        while (true) {
            try {
                Thread.sleep(5000L);
            } catch (Exception e) {
                break;
            }
            new HelloWorld().hello("llf");
        }
    }
}
