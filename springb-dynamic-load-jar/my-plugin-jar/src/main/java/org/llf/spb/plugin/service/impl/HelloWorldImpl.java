package org.llf.spb.plugin.service.impl;

import org.llf.spb.plugin.service.HelloWorld;
import org.springframework.stereotype.Service;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-04-18
 * Time 14:32
 */
@Service
public class HelloWorldImpl implements HelloWorld {
    @Override
    public String getName() {
        return "earth";
    }

    @Override
    public String sayHello(String name) {
        return "hello!"+name;
    }
}
