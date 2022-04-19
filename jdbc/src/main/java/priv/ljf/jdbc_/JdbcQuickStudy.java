package priv.ljf.jdbc_;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcQuickStudy {
    public static void main(String[] args) throws Exception {
        //1.注册驱动
//        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取连接数据库的对象

        String url = "jdbc:mysql://127.0.0.1:3306/mybatis";
        String username = "root";
        String password = "ljf684684";
        Connection connection = DriverManager.getConnection(url, username, password);
        //3.定义Sql语句
        String sql = "update tb_user set password = 666 where id = 1 ";
        //4.获取执行sql的对象
        Statement statement = connection.createStatement();
        //5.执行sql
        int i = statement.executeUpdate(sql);//返回受影响的行数
        //6.处理结果
        System.out.println(i);
        //7.释放资源
        statement.close();
        connection.close();


    }
}
