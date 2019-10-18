package org.study.llf;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-10-14
 * Time 15:39
 */

public class TestController {
    @GetMapping("/hello")
    public void get(){
        return ;
    }
}
