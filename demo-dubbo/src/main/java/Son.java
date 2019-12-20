/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-12-12
 * Time 18:18
 */
public class Son extends Parent {
    public Son(String name){
        super(name);
        hello();
    }
    @Override
    public void callMe(){
        System.out.println(name+":我是儿子");
    }
    @Override
    public void hello(){
        System.out.println(name+":儿子类hello");
    }
}
