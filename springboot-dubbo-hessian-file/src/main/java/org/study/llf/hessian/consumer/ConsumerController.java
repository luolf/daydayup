package org.study.llf.hessian.consumer;

import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.rpc.cluster.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.study.llf.hessian.facade.BookVo;
import org.study.llf.hessian.facade.DemoHessianService;
import org.study.llf.hessian.facade.DemoService;
import org.study.llf.hessian.facade.Result;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-10-18
 * Time 11:17
 */
@Controller
@RequestMapping("/books")
public class ConsumerController {
    private static final Logger log = LoggerFactory.getLogger(ConsumerController.class.getName());
    @Reference(check = false, version = "1.0.0", loadbalance = Constants.DEFAULT_LOADBALANCE, timeout = 12000)
    private DemoService demoService;
    @Reference(check = false, version = "1.0.0", loadbalance = Constants.DEFAULT_LOADBALANCE, timeout = 12000)
    private DemoHessianService demoHessianService;

    @RequestMapping(value="/list",method=RequestMethod.GET)
    @ResponseBody
    public Result<List<BookVo>> list() {
        List<BookVo> list = demoService.findAllBook(null);
        return Result.success(list, list.size());
    }

    /**
     * 测试上传并保存文件
     * @return
     */
    @RequestMapping(value="/testSaveFile")
    @ResponseBody
    public Result<String> testSaveFile(@RequestParam("file") MultipartFile file) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+file.getOriginalFilename()+"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        try {
            String fileMD5 = demoHessianService.testSaveFile(file.getOriginalFilename(),file.getInputStream());
            return Result.success("文件保存成功",fileMD5);
        } catch (IOException e) {
            log.error("查询失败："+e.getMessage());
            e.printStackTrace();
        }

        return Result.failed();
    }

    /**
     * 测试获取文件
     * @return
     */
    @RequestMapping(value="/testGetFile",method= RequestMethod.GET)
    public void testGetFile(HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=new.jpg");
        byte[] buffer = new byte[1024];
        int len = 0;
        try {
            InputStream nis = demoHessianService.testGetFile("");
            OutputStream nos = response.getOutputStream();
            while((len=nis.read(buffer))!=-1) {
                nos.write(buffer, 0, len);
            }
            nis.close();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("获取文件失败: "+e.getMessage());
        }
    }

    @RequestMapping(value="/testMe",method=RequestMethod.GET)
    @ResponseBody
    public Result<String> testMe() {
        String str = demoService.testMe(null);
        return Result.success("成功",str);
    }

}
