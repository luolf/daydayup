/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-07-11
 * Time 9:55
 */
public class X {
    Y y=new Y();
    static{
        System.out.println("1tttt");
    }
    X(){
        System.out.println("4X");
    }

    public static void main(String[] args) {
        new Z();
    }
}
class Y{
    Y(){
        System.out.println("3Y");
    }
}
class Z extends X{
    Y y=new Y();
    static{
        System.out.println("2tt");
    }
    Z(){
        System.out.println("5Z");
    }
}

