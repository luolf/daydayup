package org.study.llf.sofa.say;

import static java.lang.System.out;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-07-08
 * Time 15:52
 */
public class Say {
    static{
        out.println("v2:"+Say.class.getClassLoader()+"...loading me...");
    }
    public Say(){
        out.println("v2:Say()");
    }
    public void hello(){
        out.println("v2:****************************************");
        out.println("v2:"+this.getClass().getClassLoader()+"...loading me...");
        out.println("v2:****************************************");
    }
}
