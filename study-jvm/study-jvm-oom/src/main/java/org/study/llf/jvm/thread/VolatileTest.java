package org.study.llf.jvm.thread;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2020-05-22
 * Time 15:38
 */

public class VolatileTest {
//    public volatile Boolean stop=false;
    public  Boolean stop=false;
    public static void main(String[] args) {
           VolatileTest vt=new VolatileTest();
           Thread thread= new Thread(() -> {
               while (!vt.stop){

               }
               System.out.println("stop");
           });

        Thread thread2= new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("stop set");
            vt.setStop(true);
        });
        thread.start();
        thread2.start();

    }
    public void setStop(Boolean stop){
        this.stop=stop;
    }
}
