/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-07-19
 * Time 12:02
 */
public class BookFacadeImpl2 {
    public String name="父类:";
    public void addBook() {
        System.out.println(name+"增加图书的普通方法。。。");
    }

    public void deleteBook() {
        System.out.println(name+"删除图书的普通方法。。。");
    }

    public void setName(String name) {
        this.name = name;
    }
}
