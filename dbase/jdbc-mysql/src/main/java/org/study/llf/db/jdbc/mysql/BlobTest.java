package org.study.llf.db.jdbc.mysql;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2020-06-04
 * Time 14:01
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 测试BLOB   二进制大对象的使用
 */
public class BlobTest {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        ResultSet rs = null;
        InputStream is = null;
        OutputStream os = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","mysql");

            //插入//
            ps = conn.prepareStatement("insert into t_user(userName,headImg)values(?,?)");
            ps.setString(1, "小高");
            ps.setBlob(2, new FileInputStream("G:/JAVA/test/d.jpg"));
            ps.execute();
            //

            //查询//
            ps2 = conn.prepareStatement("select * from t_user where id=?");
            ps2.setObject(1, 223024);

            rs = ps2.executeQuery();
            System.out.println("查询");
            while (rs.next()) {
                Blob b = rs.getBlob("headImg");
                is = b.getBinaryStream();
                os = new FileOutputStream("G:/JAVA/test/h.jpg");

                int temp = 0;
                while ((temp=is.read())!=-1) {
                    os.write(temp);
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{

            try {
                if (os!=null) {
                    os.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (is!=null) {
                    is.close();
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
