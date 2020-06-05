package org.study.llf.db.jdbc.mysql;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2020-06-04
 * Time 18:13
 */
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader{

    private String classpath;

    public MyClassLoader(String classpath) {

        this.classpath = classpath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte [] classDate=getDate(name);

            if(classDate==null){}

            else{
                //defineClass方法将字节码转化为类
                return defineClass(name,classDate,0,classDate.length);
            }

        } catch (IOException e) {

            e.printStackTrace();
        }

        return super.findClass(name);
    }
    //返回类的字节码
    private byte[] getDate(String className) throws IOException{
        InputStream in = null;
        ByteArrayOutputStream out = null;
        String path=classpath + File.separatorChar +
                className.replace('.',File.separatorChar)+".class";
        try {
            in=new FileInputStream(path);
            out=new ByteArrayOutputStream();
            byte[] buffer=new byte[2048];
            int len=0;
            while((len=in.read(buffer))!=-1){
                out.write(buffer,0,len);
            }
            return out.toByteArray();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally{
            in.close();
            out.close();
        }
        return null;
    }
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //自定义类加载器的加载路径
        MyClassLoader myClassLoader=new MyClassLoader("F:\\");
        //包名+类名
        Class c=myClassLoader.loadClass("org.study.llf.db.jdbc.mysql.StaticCode");

            c.newInstance();
        //自定义类加载器的加载路径
        MyClassLoader   myClassLoader2=new MyClassLoader("F:\\");
        //包名+类名
        c=myClassLoader2.loadClass("org.study.llf.db.jdbc.mysql.StaticCode");
        c.newInstance();
    }
}