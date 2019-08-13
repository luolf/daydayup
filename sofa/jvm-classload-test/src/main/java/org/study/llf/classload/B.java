package org.study.llf.classload;

import static java.lang.System.out;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-07-18
 * Time 18:42
 */
public class B {
    public void Test(){
        out.println("B2:"+this.getClass().getClassLoader()+"...loading me...");
    }
}
