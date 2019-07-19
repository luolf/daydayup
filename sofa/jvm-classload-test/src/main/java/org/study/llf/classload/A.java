package org.study.llf.classload;


import org.study.llf.sofa.say.SayFacade;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import static java.lang.System.out;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-07-18
 * Time 18:42
 */
public class A {
    public static void  main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, MalformedURLException {
        out.println("A:"+A.class.getClassLoader()+"...loading me...");
//        Say say= new Say();
//        say.hello();

        String fileA="F:\\code\\linewell\\daydayup\\sofa-stack\\sofa-biz-test\\my-jar\\say-hello\\target\\say-hello-1.0-SNAPSHOT.jar";
        String fileB="F:\\code\\linewell\\daydayup\\sofa-stack\\sofa-biz-test\\my-jar\\say-hi\\target\\say-hi-1.0-SNAPSHOT.jar";


        SayFacade sayA =getSayFrom(fileA);
        SayFacade sayB=getSayFrom(fileB);
//        out.println("-----------------------------------"+sayA.getClass().getClassLoader());
//        sayA .hello();
//        out.println("-----------------------------------"+sayB.getClass().getClassLoader());
//        sayB.hello();
        out.println("*************************");
        sayA.test(sayB);
    }

    private static SayFacade getSayFrom(String jarFile) throws ClassNotFoundException, IllegalAccessException, InstantiationException, MalformedURLException {
        out.println(getClassLoader(jarFile).loadClass("org.study.llf.classload.A").getClassLoader());
        return (SayFacade)getClassLoader(jarFile).loadClass("org.study.llf.sofa.say.Say").newInstance();
    }

    private static URLClassLoader getClassLoader(String jarFile) throws MalformedURLException {
        URL url= new File(jarFile).toURI().toURL();
        URL[] urls= new URL[]{url};

        return new URLClassLoader(urls);
    }
}
