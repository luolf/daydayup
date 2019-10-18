package org.study.llf.hessian.facade;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-10-18
 * Time 11:15
 */
import java.io.InputStream;

public interface DemoHessianService {

    String testSaveFile(String fileName,InputStream nis);

    InputStream testGetFile(String fileId);

}
