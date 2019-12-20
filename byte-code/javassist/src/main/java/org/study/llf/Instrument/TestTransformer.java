package org.study.llf.Instrument;

import javassist.*;
import org.study.llf.bytecode.biz.HelloWorld;

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
        try {
            System.out.println("转换开始");
            ClassPool cp = ClassPool.getDefault();
//            cp.insertClassPath(new ClassClassPath(HelloWorld.class));
            CtClass cc = cp.get("org.study.llf.bytecode.biz.HelloWorld");
            CtMethod m = cc.getDeclaredMethod("hello");
            m.insertBefore("{ System.out.println(\"start\"); }");
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