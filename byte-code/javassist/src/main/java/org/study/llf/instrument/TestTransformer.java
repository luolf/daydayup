package org.study.llf.instrument;

import javassist.*;
import org.study.llf.bytecode.biz.HelloWorld;
import org.study.llf.bytecode.biz.MyBizApp;

import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-12-20
 * Time 18:05
 */

public class TestTransformer implements ClassFileTransformer {
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) {
        System.out.println("Transforming " + className);
        System.out.println("Transforming2 " + HelloWorld.class.getName());
        try {
            System.out.println("转换开始");
            ClassPool cp = ClassPool.getDefault();
            if(cp==null) {
                System.out.println("getDefault is null");
            }else{
                System.out.println("getDefault is not null");
            }
            CtClass cc = cp.get(HelloWorld.class.getName());
            System.out.println("cp.get(\"org.study.llf.bytecode.biz.HelloWorld\")");
            CtMethod m = cc.getDeclaredMethod("hello");
            m.insertBefore("{ System.out.println(\"start\"); }");
            System.out.println("insertBefore");
            m.insertAfter("{ System.out.println(\"end\"); }");
            System.out.println("转换完成");
            return cc.toBytecode();
        } catch (Exception e) {
            System.out.println("exp"+e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}