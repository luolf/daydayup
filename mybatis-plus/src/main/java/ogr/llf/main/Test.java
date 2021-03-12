package ogr.llf.main;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: luolifeng
 * Date: 2021-01-07 9:43
 */
public class Test {


    public static void main(String[] args) {
        List<Long> ids=new ArrayList<Long>(10);
        for (int i = 0; i < 10; i++) {
            ids.add((long) i);
        }
        List<Long> tp=ids.subList(0,4);
        List<Long> tp2=ids.subList(5,8);
        System.out.println("");

        P pp=new S();
        P rst=(P)pp;
        System.out.println(rst);
    }
    public static class P{
        String a="parent";

        public String getA() {
            return a;
        }

        public void setA(String a) {
            this.a = a;
        }

        @Override
        public String toString() {
            return "P{" +
                    "a='" + a + '\'' +
                    '}';
        }
    }
    public static class S extends P{
        String b="sub";

        public String getB() {
            return b;
        }

        public void setB(String b) {
            this.b = b;
        }

        @Override
        public String toString() {
            return "S{" +
                    "b='" + b + '\'' +
                    '}';
        }
    }
}
