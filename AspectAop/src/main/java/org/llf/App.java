package org.llf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.MessageFormat;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: luolifeng
 * Date: 2021-01-11 19:38
 */
@SpringBootApplication
public class App {
    public static void main(String[] args) {

        String url="http://tiktokapi.gugeedata.com:8083/api/Ins/UserInfoByUserId";
        int e = url.indexOf("?")>0?url.indexOf("?"):url.length();
        int s = url.lastIndexOf("/")+1;
        System.out.println(url.substring(s,e));

        SpringApplication.run(App.class, args);
        System.out.println("App started！");
        Object k=new Long(222L);
        StringBuilder fm= new StringBuilder("{0}");
        for (int i = 1; i <3 ; i++) {
            fm.append(":").append("{").append(i).append("}");

        }
        Object[] my = {new String("test"),new Long(22L),new App()};
        System.out.println(fm.toString());
        System.out.println(MessageFormat.format(fm.toString(),my));
    }
}
