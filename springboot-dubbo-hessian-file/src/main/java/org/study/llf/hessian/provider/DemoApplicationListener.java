package org.study.llf.hessian.provider;


import java.util.List;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.remoting.zookeeper.ChildListener;
import org.apache.dubbo.remoting.zookeeper.curator.CuratorZookeeperClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * zookeeper节点监听器测试
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-10-18
 * Time 11:11
 */
@Component
public class DemoApplicationListener implements ApplicationListener<ApplicationEvent>{
    public static final String configPath="/fxqyDemoConfig";
    @Value("${dubbo.registry.address}")
    private String zookeeperAddress;
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if(event instanceof ApplicationReadyEvent) {
            CuratorZookeeperClient client = new CuratorZookeeperClient(URL.valueOf(zookeeperAddress));
            client.createPersistent(configPath);
            client.addChildListener(configPath, new ChildListener() {

                @Override
                public void childChanged(String path, List<String> children) {
                    System.out.println("----------------configPath changed----------------"+path);
                    for (String string : children) {
                        System.out.println("----------------configPath children----------------"+string+": "
                                +client.getContent(path+"/"+string));
                    }

                }
            });
            ProviderApplication.zookeeperClient=client;
        }
    }

}