package org.study.llf.db.jdbc.mysql;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2020-06-04
 * Time 12:01
 */
public class ExecuteSelect {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement stmt = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(boolean.class.getClass());

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://192.168.203.234:3306/license_generator?characterEncoding=UTF-8&useSSL=false", "root", "root2017");
            //设为手动提交
//            conn.setAutoCommit(false);

            long start = System.currentTimeMillis();
            String sql="SELECT COUNT(*) FROM gen_task_info WHERE ( ( create_time between ? and ? ) ) ";
            stmt = conn.prepareStatement(sql);
//            for (int i = 1; i < 20000; i++) {
//                stmt.addBatch("insert into t_user (userName,pwd,regTime) values ('hao" + i + "',666666,now())");
//            }

            stmt.setDate(1, Date.valueOf("2020-06-04 04:51:06"));
            stmt.setDate(2, Date.valueOf("2020-06-04 04:51:06"));

            ResultSet rst=stmt.executeQuery();
            rst.getInt(1);


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


