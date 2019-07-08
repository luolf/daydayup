package org.study.llf.sofa.service;

import org.study.llf.sofa.say.Say;

import static java.lang.System.out;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-07-08
 * Time 16:32
 */
public class Haha {
    public void test() {
        out.println("s1:"+this.getClass().getClassLoader()+"...loading me...");
        Say say = new Say();
        say.hello();
    }


}
