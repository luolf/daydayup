package org.study.llf.sofa.say;

import static java.lang.System.*;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-07-08
 * Time 15:52
 */
public class Say implements SayFacade{
    static{
        out.println("v1:"+Say.class.getClassLoader()+"...loading me...");
    }
    public Say(){
        out.println("v1:Say()");
    }

    public void hello(){
        out.println("v1:****************************************");
        out.println("v1:"+this.getClass().getClassLoader()+"...loading me...");
        out.println("v1:****************************************");
        new Report().print();
    }
    public  void test(SayFacade sayFacade){
        out.println("test:"+this.getClass().getClassLoader()+"...loading me...");
        sayFacade.hello();

    }

}
