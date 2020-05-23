package org.study.llf.jvm.oom;

import java.util.LinkedList;
import java.util.List;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-09-26
 * Time 14:05
 */
public class ManyObject {
    volatile Integer name;
    public ManyObject(Integer name){
        this.name=name;
    }
    public  TestObject get(){
        TestObject t=  new TestObject();
        return t;
    }
    public static void get2(){
        new ManyObject(1);
    }

    /**
     * jps -lv
     * jmap -histo {pid}
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
         ManyObject  manyObject=new ManyObject(1);
//        Thread.sleep(20000);
        long start=System.currentTimeMillis();
        for (int i = 1; i < 300000000; i++) {
            if(i%1000==0){
                Thread.sleep(3000);
            }
            TestObject t=  manyObject.get();
        }
        System.out.println("run here:"+(System.currentTimeMillis()-start));
//        Thread.sleep(10000);
//         for (int i = 0; i < 1000000; i++) {
//             ManyObject.get2();
//        }
        Thread.sleep(6000000);
    }
}
