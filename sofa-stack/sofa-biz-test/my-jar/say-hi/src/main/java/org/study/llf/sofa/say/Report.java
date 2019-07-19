package org.study.llf.sofa.say;

import static java.lang.System.out;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-07-18
 * Time 20:05
 */
public class Report {
    public void print() {
        System.out.println("test1 Base");
        out.println("Report:"+this.getClass().getClassLoader()+"...loading me...");
    }
}
