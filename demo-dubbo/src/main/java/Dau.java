/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-12-12
 * Time 18:18
 */
public class Dau extends Parent{
    public Dau(String name){
        super(name);
    }
//    @Override
//    public void callMe(){
////        System.out.println(name+":我是女儿");
////        hello();
//        super.callMe();
//    }
    @Override
    public void hello(){
        System.out.println(name+":女儿类hello");
    }
}
