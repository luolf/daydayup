package org.study.llf;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-10-12
 * Time 16:52
 */
@SpringBootApplication
@EnableAdminServer
public class AdminSer {
    public static void main(String[] args) {
        SpringApplication.run(AdminSer.class, args);
    }
}
