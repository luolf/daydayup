package org.llf.instrumentation;

import javassist.*;

import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-07-19
 * Time 14:00
 */
public class MyClassFileTransformer  implements ClassFileTransformer {
    public static void premain(String options, Instrumentation ins) {
        //注册我自己的字节码转换器
        ins.addTransformer(new MyClassFileTransformer());
    }

    /**
     * 字节码加载到虚拟机前会进入这个方法
     */
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain, byte[] classfileBuffer)
            throws IllegalClassFormatException {
        System.out.println(className);
        //如果加载Business类才拦截
        if (!"model/Business".equals(className)) {
            return null;
        }

        //javassist的包名是用点分割的，需要转换下
        if (className.indexOf("/") != -1) {
            className = className.replaceAll("/", ".");
        }
        try {
            //通过包名获取类文件
            CtClass cc = ClassPool.getDefault().get(className);
            //获得指定方法名的方法
            CtMethod m = cc.getDeclaredMethod("doSomeThing");
            //在方法执行前插入代码
            m.insertBefore("{ System.out.println(\"记录日志\"); }");
            return cc.toBytecode();
        } catch (NotFoundException e) {
        } catch (CannotCompileException e) {
        } catch (IOException e) {
            //忽略异常处理
        }
        return null;
    }
}
