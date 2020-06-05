import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-07-19
 * Time 12:04
 */
public class AppMain {
    public static void main(String[] args) {
        BookFacadeCglib cglib = new BookFacadeCglib();
        BookFacadeImpl facade=new BookFacadeImpl();
        facade.setName("开始");
        BookFacadeImpl bookFacade = (BookFacadeImpl) cglib.getInstance(facade);
        System.out.println("cglib subclass="+bookFacade.getClass().hashCode());
        System.out.println(bookFacade.hashCode());
        bookFacade = (BookFacadeImpl) cglib.getInstance(facade);

        bookFacade.addBook();

        /**
         * 无对象传入
         */
        BookFacadeCglib2 cglib2 = new BookFacadeCglib2();

        BookFacadeImpl  subbookFacade1 = (BookFacadeImpl) cglib2.getInstance(BookFacadeImpl.class);

        BookFacadeImpl  subbookFacade2 = (BookFacadeImpl) cglib2.getInstance(BookFacadeImpl.class);
        BookFacadeImpl2  subbookFacade3 = (BookFacadeImpl2) cglib2.getInstance(BookFacadeImpl2.class);
        cglib2.setCnt(99);
        subbookFacade1.addBook();

        subbookFacade2.addBook();
        bookFacade.addBook();
        System.out.println("cglib subclass="+bookFacade.getClass().hashCode()+"：cglib2 BookFacadeImpl subclass="+subbookFacade1.getClass().hashCode()+"：cglib2 BookFacadeImpl2 subclass="+subbookFacade3.getClass().hashCode());
        System.out.println("cglib subclass="+bookFacade.getClass().getName()+"：cglib2 BookFacadeImpl subclass="+subbookFacade1.getClass().getTypeName()+"：cglib2 BookFacadeImpl2 subclass="+subbookFacade3.getClass().getCanonicalName());
        if(subbookFacade1.getClass().hashCode()==subbookFacade2.getClass().hashCode())
       {
           /**
            *
            * 会进入这里
            */

           System.out.println(true);
       }

        bookFacade.addBook();
        savePoxyClass(bookFacade);
    }
    /**
     * 保存字节码到文件
     */
    public static void savePoxyClass(Object c){
        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy", new Class[]{c.getClass()});
        try(
                FileOutputStream fos =new FileOutputStream(new File("BookFacadeImplProxy.class"))
        ){
            fos.write(bytes);
            fos.flush();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
