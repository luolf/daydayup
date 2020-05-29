/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2020-05-29
 * Time 12:06
 */
public class SubBusiness extends Business {
    @Override
    public void doSomeThing() {
        super.doSomeThing();
        System.out.println(this+":doSomeThing"+this.getClass().getClassLoader());
        System.out.println("zi");
    }
}
