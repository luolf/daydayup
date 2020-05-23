package org.llf.sofaboot.demo;

import org.llf.sofaboot.demo.facade.SampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

@ImportResource({"classpath*:META-INF/llf-sofaboot-demo/*.xml"})
@org.springframework.boot.autoconfigure.SpringBootApplication
public class SOFABootSpringApplication {
    private static final Logger logger = LoggerFactory.getLogger(SOFABootSpringApplication.class);

    public static void main(String[] args){

        SpringApplication springApplication = new SpringApplication(SOFABootSpringApplication.class);
        ApplicationContext applicationContext = springApplication.run(args);
        SampleService sampleService = applicationContext.getBean(SampleService.class);

        if (logger.isInfoEnabled()){
            logger.info("Sample Service Result = " + sampleService.message());
            logger.info("Current Application Context : " + applicationContext);
        }
    }
}
