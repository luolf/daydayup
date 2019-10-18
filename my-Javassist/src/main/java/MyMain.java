import javassist.*;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-10-14
 * Time 17:07
 */
public class MyMain {
    public static void main(String[] args) throws CannotCompileException, NotFoundException, IOException {


    ClassPool pool = ClassPool.getDefault(); // 获取默认的类池
    //        pool.appendClassPath(new ClassClassPath(this.getClass()));
    CtClass registrationClazz = pool.getOrNull("de.codecentric.boot.admin.server.domain.values.Registration");
        if (registrationClazz == null) {
        System.out.println("获取类Registration失败");
        return;
    }

    //创建构造方法
//        CtConstructor cc = new CtConstructor(new CtClass[]{}, registrationClazz);
//        registrationClazz.addConstructor(cc);

        try {
        // 添加一个默认构造器
        CtConstructor constructor1 = CtNewConstructor.make("public Registration(){}", registrationClazz);
        registrationClazz.addConstructor(constructor1);
        registrationClazz.writeFile();
        Class<?> clazz = registrationClazz.toClass();
        Object ob = clazz.getDeclaredConstructor().newInstance();



        // 输出类基本信息
//            System.out.println("包名：" + clazz.getPackageName());
        System.out.println("类名：" + clazz.getName());
        System.out.println("简要类名：" + clazz.getSimpleName());
        System.out.println("限定符：" + Modifier.toString(clazz.getModifiers()));
        System.out.println("继承类：" + clazz.getSuperclass().getName());
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("属性名称：" + field.getName() + "，属性类型：" + field.getType() + "，限定符："
                    + Modifier.toString(field.getModifiers()));
        }
    } catch (CannotCompileException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } catch (NotFoundException e) {
        e.printStackTrace();
    } catch (InstantiationException e) {
        e.printStackTrace();
    } catch (
    InvocationTargetException e) {
        e.printStackTrace();
    } catch (NoSuchMethodException e) {
        e.printStackTrace();
    } catch (IllegalAccessException e) {
        e.printStackTrace();
    }


}
}
