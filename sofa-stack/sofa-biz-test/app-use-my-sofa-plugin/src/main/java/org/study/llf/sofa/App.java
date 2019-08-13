package org.study.llf.sofa;

import com.alipay.sofa.ark.support.startup.SofaArkBootstrap;
import org.study.llf.sofa.service.Haha;
import org.study.llf.sofa.service.Hehe;

/**
 * Description 类描述,对于普通的 Java 应用需要在工程 main 方法最开始处，执行容器启动.
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-07-08
 * Time 16:41
 */
public class App {
    public static void main(String[] args) throws Exception {

        //对于普通的 Java 应用需要在工程 main 方法最开始处，执行容器启动.发现注释掉也可用，估计是0.6.0版本做了处理
        //注意要运行打包后的jar才有效果。
//        SofaArkBootstrap.launch(args);
//        SofaArkBootstrap.prepareContainerForTest(App.class);
        com.alipay.sofa.ark.bootstrap.ArkLauncher.main(args);
        new Hehe().test();
        System.out.println("================================================");
        new Haha().test();
    }
}
