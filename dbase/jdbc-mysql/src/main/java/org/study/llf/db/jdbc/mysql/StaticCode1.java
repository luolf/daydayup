package org.study.llf.db.jdbc.mysql;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2020-06-04
 * Time 18:04
 */
public class StaticCode1 {
    static{
        System.out.println(StaticCode1.class.getClassLoader()+"加载器加载了"+ StaticCode1.class.getName() );
    }


}
