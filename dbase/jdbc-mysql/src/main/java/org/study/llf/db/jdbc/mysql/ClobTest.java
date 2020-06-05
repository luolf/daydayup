package org.study.llf.db.jdbc.mysql;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2020-06-04
 * Time 13:58
 */
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.*;

/**
 * 测试CLOB   文本大对象的使用
 * 包含：将字符串、文件内容插入数据库中的CLOB字段和将CLOB字段值取出来的操作。
 */
public class ClobTest {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        ResultSet rs = null;
        Reader r = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","mysql");

            //插入//
            ps = conn.prepareStatement("insert into t_user(userName,myInfo)values(?,?)");
            ps.setString(1, "小高");

            //将文本文件内容直接输入到数据库中
//          ps.setClob(2, new FileReader(new File("G:/JAVA/test/a.txt")));

            //将程序中的字符串输入到数据库中的CLOB字段中
            ps.setClob(2, new BufferedReader(new InputStreamReader(new ByteArrayInputStream("aaaa".getBytes()))));

            ps.executeUpdate();
            System.out.println("插入");
            //

            //查询//
            ps2 = conn.prepareStatement("select * from t_user where id=?");
            ps2.setObject(1, 223021);

            rs = ps2.executeQuery();
            System.out.println("查询");
            while (rs.next()) {
                Clob c = rs.getClob("myInfo");
                r = c.getCharacterStream();
                int temp = 0;
                while ((temp=r.read())!=-1) {
                    System.out.print((char)temp);
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{

            try {
                if (r!=null) {
                    r.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (rs!=null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (ps2!=null) {
                    ps2.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (ps!=null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn!=null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
