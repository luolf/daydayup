package org.llf.security.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;

import java.util.Objects;


/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2020-03-13
 * Time 16:36
 */
public class Test  {
    Logger logger= LoggerFactory.getLogger(Test.class);
    public int num=0;

    @Override
    public String toString() {

//        logger.info("toString:{}",num);
        System.out.println(num);

        return  num +"";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null) {return false;}

        Boolean rst=this.toString().equals(o);
        num=num+1;
        return rst;
    }


    public static void main(String[] args) {
        equal();
    }
    @org.testng.annotations.Test
    public static void equal(){
        Test t=new Test();
        if(t.equals("0") && t.equals("1")&& t.equals("2")){
            System.out.println("true");
        }

    }




}
