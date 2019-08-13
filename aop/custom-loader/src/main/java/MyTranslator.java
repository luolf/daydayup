import javassist.*;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-07-19
 * Time 12:10
 */
public  class MyTranslator implements Translator {

    public void start(ClassPool pool) throws NotFoundException, CannotCompileException {

    }

    /* *
     * 类装载到JVM前进行代码织入
     */
    public void onLoad(ClassPool pool, String classname) {
        if (!"Business".equals(classname)) {
            return;
        }
        //通过获取类文件
        try {
            CtClass cc = pool.get(classname);
            //获得指定方法名的方法
            CtMethod m = cc.getDeclaredMethod("doSomeThing");

            //在方法执行前插入代码
            m.insertBefore("{ System.out.println(\""+ m.getName()+"记录日志开始\");long s=System.currentTimeMillis(); }");

            m.insertAfter("{ System.out.println(\""+ m.getName()+"记录日志结束\"+System.currentTimeMillis());  }");
        } catch (NotFoundException e) {
        } catch (CannotCompileException e) {
        }
    }

    public static void main(String[] args) {
        Business b = new Business();
        b.doSomeThing2();
        b.doSomeThing();
    }
}