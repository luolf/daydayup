package org.study.llf.spring.elasticsearch;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-03-29
 * Time 9:34
 */
@SpringBootApplication
@RestController
public class MyApp {
    public MyApp(){
        System.out.println("myid="+this);
    }
    public static void main(String[] args) {
        SpringApplication.run(MyApp.class, args);
    }
    @Autowired
    HttpServletRequest request1;//这样使用，request1每次进来都是Current Request

    @RequestMapping("/test1")
    public void test(){
        System.out.println("test1request1:"+request1.hashCode());
        System.out.println("test1"+request1.getParameter("name"));
    }

    @RequestMapping("/test2")
    public void test2(String name){
        System.out.println("request2request2:"+request1.hashCode());
        System.out.println("test2"+request1.getParameter("name"));
    }

    @RequestMapping("/test3")
    public void test3(HttpServletRequest request){
        //这样进来request每次都不一样

        System.out.println("request:"+request.hashCode());
        System.out.println("request1:"+request1.hashCode());

    }
    @GetMapping("/")
    public HashMap<String,String>  he(HttpServletRequest request, ServletRequest servletRequest) {
//        JSON.toJSONString();

        HttpServletRequest request2 = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request2.getSession();
        System.out.println("request:"+request.hashCode()+";request2:"+request.hashCode());

        HashMap<String,String> rst=new HashMap<>();
//        rst.put("request.RequestedSessionId",request.getRequestedSessionId());
        rst.put("request.hashCode",request.hashCode()+"");
//        rst.put("request",request.toString());
//        rst.put("servletRequest",servletRequest.toString());
        rst.put("request.currentThread.Name()",Thread.currentThread().getName());
//        rst.put("request.getSession.Id",request.getSession().getId());
//        rst.put("request.getRemoteAddr()",request.getRemoteAddr());

        return rst;
    }

}
