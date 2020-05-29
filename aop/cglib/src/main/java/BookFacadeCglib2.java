

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
public class BookFacadeCglib2 implements MethodInterceptor {
    public int cnt=100;
    /**
     * 创建代理对象，将当前MethodInterceptor实现类通过 setCallback绑定到代理类中
     * 这样代理对象被调用时，会去调callback绑定对象的intercept方法
     * @param target
     * @return
     */
    public Object getInstance(Class target) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target);
        //回调方法
        enhancer.setCallback(this);
        //创建代理
        return enhancer.create();
    }

    //回调方法
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        if (method.getName().equals("addBook")) {
            System.out.println(obj.hashCode()+"这个估计不被执行"+this.cnt);
        }
        long s=System.currentTimeMillis();
        methodProxy.invokeSuper(obj, args);
        String msg=method.getName()+":"+method.getDeclaringClass();
        System.out.println("耗时:"+(System.currentTimeMillis()-s)+":"+msg);
        return null;
    }
    public  void  setCnt(int cnt){
        this.cnt=cnt;
    }
}
