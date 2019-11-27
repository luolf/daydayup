package org.study.llf.oauth2.deploy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-11-15
 * Time 10:38
 */
@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages={"org.study.llf"})
public class AuthoAppStart {

    private static Logger logger = LoggerFactory.getLogger(AuthoAppStart.class);
    public static void main(String[] args) {
        SpringApplication.run(AuthoAppStart.class, args);
        logger.info("************************* AuthoAppStart started!**************************");
    }

}
