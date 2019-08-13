

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 使用cglib动态代理
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-07-19
 * Time 12:03
 */
public class BookFacadeCglib implements MethodInterceptor {

    private Object target;

    /**
     * 创建代理对象
     *
     * @param target
     * @return
     */
    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        //回调方法
        enhancer.setCallback(this);
        //创建代理
        return enhancer.create();
    }

    //回调方法
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        if (method.getName().equals("addBook")) {
            System.out.println("记录增加图书的日志");
        }

        long s=System.currentTimeMillis();
        methodProxy.invokeSuper(obj, args);
        String msg=method.getName()+method.getDeclaringClass();
        System.out.println("耗时:"+(System.currentTimeMillis()-s)+":"+msg);
        return null;
    }
}
