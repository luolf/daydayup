package org.study.llf.jvm.oom;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-09-26
 * Time 14:30
 */
public class TestObject {
    public static void main(String[] args) {
        String url = "/api/pagein/v0.1/user/updatePwd";
        if (false || url.contains("/user/updatePwd")) {
            System.out.println("ok");
        }
    }
}
