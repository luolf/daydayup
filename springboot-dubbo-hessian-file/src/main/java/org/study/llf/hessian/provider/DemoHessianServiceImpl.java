package org.study.llf.hessian.provider;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;

import org.apache.dubbo.config.annotation.Service;
import org.study.llf.hessian.facade.DemoHessianService;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-10-18
 * Time 11:13
 */
@Service(interfaceClass = DemoHessianService.class, protocol = "hessian", version = "1.0.0", timeout = 120000)
public class DemoHessianServiceImpl implements DemoHessianService {

    @Override
    public String testSaveFile(String fileName,InputStream nis) {
        OutputStream fos = null;
        byte[] buffer = new byte[4096];
        int len = 0;
        try {
            fos = new FileOutputStream("d:\\new.jpg");
            MessageDigest md = MessageDigest.getInstance("MD5");
            while((len=nis.read(buffer))!=-1) {
                fos.write(buffer, 0, len);
                md.update(buffer, 0, len);
            }
            BigInteger bi = new BigInteger(1,md.digest());
            return bi.toString(Character.MAX_RADIX);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("保存文件失败");
        }finally {
            try {
                if(fos!=null)fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public InputStream testGetFile(String fileId) {
        InputStream fis = null;
        try {
            fis = new FileInputStream("d:\\new.jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fis;
    }

}
