package priv.ljf.jdbc_.Statement_;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 执行DDL语句
 * @throws Exception
 */
@SuppressWarnings({"all"})
public class TestDDL {
    public static void main(String[] args) throws SQLException {
        //1.注册驱动
        //2.获取连接：如果连接的是本机mysql并且端口是默认的 3306 可以简化书写
        String url = "jdbc:mysql:///mydb6_view";
        String username = "root";
        String password = "ljf684684";
        Connection connection = DriverManager.getConnection(url, username, password);
        //3.定义sql语句
        String sql = "drop table salgrade";
        //4.获取执行sql的对象
        Statement statement = connection.createStatement();
        //5.执行sql
        int i = statement.executeUpdate(sql);
        //6.处理结果
        System.out.println(i);
        //7.释放资源
        statement.close();
        connection.close();
    }
}
