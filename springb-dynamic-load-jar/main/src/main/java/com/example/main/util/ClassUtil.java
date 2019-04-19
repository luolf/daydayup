package com.example.main.util;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-04-18
 * Time 16:43
 */
public class ClassUtil {

    public static List<Class> LoadClass(String filePath, ClassLoader beanClassLoader) {
        List<Class> classNameList = new ArrayList<>();
        File clazzPath = new File(filePath);
        int clazzCount = 0;
        if (clazzPath.exists() && clazzPath.isDirectory()) {
            int clazzPathLen = clazzPath.getAbsolutePath().length() + 1;
            Stack<File> stack = new Stack<>();
            stack.push(clazzPath);
            while (!stack.isEmpty()) {
                File path = stack.pop();
                File[] classFiles = path.listFiles(pathname -> pathname.isDirectory() || pathname.getName().endsWith(".class"));
                for (File subFile : classFiles) {
                    if (subFile.isDirectory()) {
                        stack.push(subFile);
                    } else {
                        if (clazzCount++ == 0) {
                            Method method = null;
                            try {
                                method = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
                            } catch (NoSuchMethodException e) {
                                e.printStackTrace();
                            }
                            assert method != null;
                            boolean accessible = method.isAccessible();
                            try {
                                if (!accessible) {
                                    method.setAccessible(true);
                                }
                                URLClassLoader classLoader = (URLClassLoader) beanClassLoader;
                                try {
                                    URL url = clazzPath.toURI().toURL();
                                    method.invoke(classLoader, url);
                                } catch (IllegalAccessException e) {
                                    e.printStackTrace();
                                } catch (InvocationTargetException e) {
                                    e.printStackTrace();
                                } catch (MalformedURLException e) {
                                    e.printStackTrace();
                                }
                            } finally {
                                method.setAccessible(accessible);
                            }
                        }
                        String className = subFile.getAbsolutePath();
                        className = className.substring(clazzPathLen, className.length() - 6);
                        className = className.replace(File.separatorChar, '.');
                        try {
                            classNameList.add(Class.forName(className));
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return classNameList;
    }
}
