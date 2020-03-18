package org.llf.security;

//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2020-03-04
 * Time 17:15
 */
@RestController
public class AppController {
//    @RequestMapping("/hello")
//    String hello() {
//        return getLoginName()+" Hello ,spring security!";
//    }
//    @GetMapping("/")
//    String home() {
//        return "welcome "+getLoginName()+",spring security!";
//    }
    private void test(){
        System.out.println("");
    }
//    private String getLoginName(){
//        test();
//        Object principl = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if(principl instanceof UserDetails) {
//            return ((UserDetails)principl).getUsername();
//        }else {
//            return principl.toString();
//        }
//    }


}
