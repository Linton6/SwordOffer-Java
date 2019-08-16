package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author Linton
 * @Date 2019/8/14 9:57
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

public class JdbcTest {
    public static void main(String[] args) {
            login();
    }
    public static void login() {
        Connection conn = null;
        try {
            // 1.加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2. 获取数据库连接
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/company","root","123456");
            // 3. 创建语句
            String sql="Select *from users";
            // 返回一个执行SQL的句柄
            Statement stmt = conn.createStatement();
            // 4. 执行查询
            java.sql.ResultSet rs = stmt.executeQuery(sql);
            // 5. 遍历结果集
            while (rs.next()){
                int id = rs.getInt(3);
                String username = rs.getString(1);
                String password = rs.getString(2);
                System.out.println(" id: " + id + " username: " + username + " password: "+ password);

            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            // 6.关闭数据库连接
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
}

