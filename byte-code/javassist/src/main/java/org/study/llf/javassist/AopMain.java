package org.study.llf.javassist;

import javassist.*;
import org.study.llf.bytecode.biz.HelloWorld;

import java.io.IOException;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-12-20
 * Time 17:57
 */
public class AopMain {
    public static void main(String[] args) throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException, IOException {
        ClassPool cp = ClassPool.getDefault();
        CtClass cc = cp.get("org.study.llf.bytecode.biz.HelloWorld");
        CtMethod m = cc.getDeclaredMethod("hello");
        m.insertBefore("{ System.out.println(\"start\"); }");
        m.insertAfter("{ System.out.println(\"end\"); }");
        Class c = cc.toClass();
        HelloWorld h = (HelloWorld)c.newInstance();
        h.hello("llf");
    }
}
