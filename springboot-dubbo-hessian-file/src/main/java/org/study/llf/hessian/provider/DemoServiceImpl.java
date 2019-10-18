package org.study.llf.hessian.provider;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-10-18
 * Time 11:12
 */
import java.util.ArrayList;
import java.util.List;
import org.apache.dubbo.config.annotation.Service;
import org.study.llf.hessian.facade.BookVo;
import org.study.llf.hessian.facade.DemoService;

@Service(interfaceClass = DemoService.class, protocol = "dubbo", version = "1.0.0", timeout = 120000)
public class DemoServiceImpl implements DemoService{

    @Override
    public List<BookVo> findAllBook(BookVo vo) {
        List<BookVo> books = new ArrayList<BookVo>();
        for(int k=0;k<50;k++) {
            books.add(new BookVo(1000+k,"The book of day"+k));
        }
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>findAllBook<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        return books;
    }

    @Override
    public String testMe(String value) {
        if(ProviderApplication.zookeeperClient.checkExists(DemoApplicationListener.configPath+"/configData1")) {
            ProviderApplication.zookeeperClient.delete(DemoApplicationListener.configPath+"/configData1");
            System.out.println("----------------Provider sayHi----------------delete");
        }
        ProviderApplication.zookeeperClient.create(DemoApplicationListener.configPath+"/configData1", "qqqqqqqqqqqq", true);
        System.out.println("----------------Provider sayHi----------------");
        return "testMe";
    }


}