package org.study.llf.spring.elasticsearch;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

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

    RestTemplate restTemplate=new RestTemplate();
    public void tt(){
        Map<String,Object> body = new HashMap<>();
        body.put("lang","english");
        body.put("filterstopwords","1");
        body.put("filtertags","title");
        Map<String,Object> content = new HashMap<>();
        content.put("0","ge ge hh");
        content.put("1","we just heard ~join us~");
        body.put("content",content);
        ResponseEntity<Rop> responseEntity = restTemplate.postForEntity("http://innermlapi.xiguaji.com/getsegbulkstrsforeign", body, Rop.class);
        System.out.println(responseEntity.getBody());
    }

    public class Rop{
        String message;
        int code;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }
    }
    public MyApp(){

    }
    public static void main(String[] args) {
//        MyApp a=new MyApp();
        String pp="{\"business_type\":6,\"shop_link\":{\"keyword\":\"Mental Health Movement Shirt\",\"url\":\"https://teespring.com/stores/mental-health-movement-2\"},\"anchor_info\":{\"keyword\":\"Mental Health Movement Shirt\",\"url\":\"https://teespring.com/stores/mental-health-movement-2\",\"extra\":\"{\\\"product_type\\\":\\\"teespring\\\"}\"}}";
        if(!StringUtils.isEmpty(pp)  && !pp.equals("NONE")){
            System.out.println("true");
        }else{
            System.out.println("false");
        }

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
