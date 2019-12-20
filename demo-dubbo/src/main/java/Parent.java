/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-12-12
 * Time 18:17
 */
public class Parent {
    String name;
    public Parent(String name){
        this.name=name;
    }
    public void callMe(){
        System.out.println(name+":我是父类");
        this.hello();
    }
    public void hello(){
        System.out.println(name+":父类hello");
    }
}
