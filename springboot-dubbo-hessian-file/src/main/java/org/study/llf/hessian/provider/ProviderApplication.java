package org.study.llf.hessian.provider;


import org.apache.dubbo.remoting.zookeeper.curator.CuratorZookeeperClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-10-18
 * Time 11:09
 */

@SpringBootApplication
public class ProviderApplication {
    public static CuratorZookeeperClient zookeeperClient =null;
    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }

}
