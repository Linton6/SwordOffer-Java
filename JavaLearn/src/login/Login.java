package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;

/**
 * @Author Linton
 * @Date 2019/8/14 9:42
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

public class Login {
    public static void main(String[] args) throws Exception {
        /** 连接数据库时，对象初始化 */
        Connection con =null;
        PreparedStatement stmt = null;
        ResultSet result = null;

        String url="jdbc:mysql://localhost:3306/company";
        String name="root";
        String password="123456";

        /** 连接数据库 */

        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(url,name,password);

        // 验证身份
        boolean right = false;
        String sql="Select *from users where username=? and password=?";
        stmt = con.prepareStatement(sql);
        stmt.setString(1, "Linton");
        stmt.setString(2, "123456");
        result = stmt.executeQuery();
        if (result.next()) {
            right = true;
        }
        // 关闭资源
        result.close();
        stmt.close();
        con.close();
        if (right) {
            System.out.println("登陆成功！");
        } else {
            System.out.println("登录失败！");
        }


    }
}

