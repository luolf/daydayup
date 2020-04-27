package org.study.llf;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2020-04-09
 * Time 17:09
 */
public class App {
    public static void main(String[] args) {
        int threadNum=4;
        if (args.length>0 ){
            try {
                threadNum= Integer.parseInt(args[0]);
            }catch (Exception e){

            }

        }
        for(int i=0;i<threadNum;i++){
            new Thread(new FullThread()).start();
        }
        System.out.println(threadNum+"个线程启动完毕！");
    }
}
