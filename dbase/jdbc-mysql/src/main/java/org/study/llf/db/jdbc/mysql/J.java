package org.study.llf.db.jdbc.mysql;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2020-06-05
 * Time 11:22
 */
public class J {
    static {
        System.out.println(" J 加载");
        String dir = "file:/Users/sunyuming/Documents/tool/jars//MySub-1.0.0-jar-with-dependencies.jar";
        URL url = null;
        try {
            url = new URL(dir);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        URL[] urls2 = {url};

        // 若不指定parent参数，则默认由系统类加载器担任自定义类加载器的父加载器，输出parent:sun.misc.Launcher$AppClassLoader@3764951d
        MyUrlClassLoader myUrlClassLoader = new MyUrlClassLoader(urls2);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                new K();
            }
        });
        thread.setContextClassLoader(myUrlClassLoader);
        thread.start();

    }

    private static class MyUrlClassLoader extends URLClassLoader {
        public MyUrlClassLoader(URL[] urls) {
            super(urls);
        }
    }
}


