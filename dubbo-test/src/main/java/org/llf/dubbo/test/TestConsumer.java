//package org.llf.dubbo.test;
//
//import com.linewell.license.ops.api.DemoService;
//import com.linewell.license.roo.common.web.SpringManager;
//
//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiImplicitParams;
//import io.swagger.annotations.ApiOperation;
//import org.apache.dubbo.config.annotation.Reference;
//import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.GetMapping;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//import java.lang.reflect.UndeclaredThrowableException;
//
//
///**
// * Description 类描述
// *
// * @author luolifeng
// * @version 1.0.0
// * Date 2019-05-09
// * Time 16:37
// */
//@EnableDubbo(scanBasePackages = {"com.linewell.license"})
//@SpringBootApplication
//@EnableSwagger2
//
//
//public class TestConsumer {
//    @Reference(version = "1.0", check = false)
//    DemoService demoService;
//    /**
//     * Created with IntelliJ IDEA.
//     * Description:sayHello
//     * return
//     * @param name 名字
//     * @author luolifeng
//     * Date: 2019-03-20
//     */
//    @ApiOperation(value = "打招呼", notes = "打招呼")
//    @GetMapping(value = "/sayhello", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "name", value = "名字", required = false, dataType = "String"),
//    })
//    public String sayHi(String name) {
//
//        String rsp="dddd";
//        try {
//            rsp = demoService.sayHello(name);
//        }catch(UndeclaredThrowableException e){
//            System.out.println(e.getUndeclaredThrowable());
//            Throwable a=e.getCause();
//            Throwable s=e.getUndeclaredThrowable().getCause();
//            e.printStackTrace();
//            rsp=e.getMessage();
//        }
//        DemoService ds  = (DemoService) SpringManager.getBean(DemoService.class);
//        rsp = ds.sayHello(name);
//
//        System.out.println("SpringManager.getBean:"+ds);
//        System.out.println("Reference:"+demoService);
//        return "ok";
//    }
//
//    public static void main(String[] args) {
//        //解决netty冲突
//        System.setProperty("es.set.netty.runtime.available.processors", "false");
//        SpringApplication.run(TestConsumer.class, args);
//    }
//}
