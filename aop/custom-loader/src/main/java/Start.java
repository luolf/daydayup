import javassist.ClassPool;
import javassist.Loader;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-07-19
 * Time 13:36
 */
public class Start {
    public static void main(String[] args) throws Throwable {
        //获取存放CtClass的容器ClassPool
        ClassPool cp = ClassPool.getDefault();
//创建一个类加载器
        Loader cl = new Loader();
//增加一个转换器
        cl.addTranslator(cp, new MyTranslator());
//启动MyTranslator的main函数
        cl.run("MyTranslator", args);
    }
}
