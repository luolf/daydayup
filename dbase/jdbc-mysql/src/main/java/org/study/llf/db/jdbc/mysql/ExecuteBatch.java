package org.study.llf.db.jdbc.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2020-06-04
 * Time 12:01
 */
public class ExecuteBatch {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        System.out.println(boolean.class.getClass());
        if (1 == 1)
            return;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://192.168.11.211:3306/test001?characterEncoding=UTF-8&useSSL=false", "root", "root");
            //设为手动提交
            conn.setAutoCommit(false);

            long start = System.currentTimeMillis();

            stmt = conn.createStatement();
            for (int i = 1; i < 20000; i++) {
                stmt.addBatch("insert into t_user (userName,pwd,regTime) values ('hao" + i + "',666666,now())");
            }
            stmt.executeBatch();
            conn.commit();  //提交事务

            long end = System.currentTimeMillis();
            System.out.println("插入20000条数据，耗时(ms):" + (end - start));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}


