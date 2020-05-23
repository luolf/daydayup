package org.llf.sofaboot.demo.web;

import org.llf.sofaboot.demo.web.endpoint.facade.SampleRestFacade;
import org.llf.sofaboot.demo.web.endpoint.impl.SampleRestFacadeRestImpl;
import org.llf.sofaboot.demo.web.endpoint.model.DemoUserModel;
import org.llf.sofaboot.demo.web.endpoint.response.RestSampleFacadeResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

@ImportResource({"classpath*:META-INF/llf-sofaboot-demo-web/*.xml"})
@org.springframework.boot.autoconfigure.SpringBootApplication
public class SOFABootWebSpringApplication {

    private static final Logger logger = LoggerFactory.getLogger(SOFABootWebSpringApplication.class);

    public static void main(String[] args){

        SpringApplication springApplication = new SpringApplication(SOFABootWebSpringApplication.class);
        ApplicationContext applicationContext = springApplication.run(args);

        if (logger.isInfoEnabled()){
            logger.info("application start");
        }

        SampleRestFacade sampleRestFacade = applicationContext.getBean("sampleRestFacadeRest", SampleRestFacadeRestImpl.class);

        DemoUserModel demoUserModel = new DemoUserModel();
        demoUserModel.setUserId(12);
        demoUserModel.setRealName("realName");
        demoUserModel.setUserName("userName");

        RestSampleFacadeResp<Integer> resp =  sampleRestFacade.addUserInfo(demoUserModel);

        if (logger.isInfoEnabled()) {
            logger.info("the resp id is " + resp.getData());
        }

    }
}
