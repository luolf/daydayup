/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-07-19
 * Time 11:21
 */
public class Business implements IBusiness,IBusiness2 {
    public Business(){
        System.out.println(this+":Business"+this.getClass().getClassLoader());

    }
    @Override
    public void doSomeThing() {
        System.out.println(this+":doSomeThing"+this.getClass().getClassLoader());
        System.out.println("执行业务逻辑");
    }

    @Override
    public void doSomeThing2() {
        System.out.println(this+":doSomeThing2"+this.getClass().getClassLoader());
        System.out.println("执行业务逻辑2");
    }
}
