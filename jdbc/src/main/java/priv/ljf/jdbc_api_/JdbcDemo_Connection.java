package priv.ljf.jdbc_api_;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC API 详解：Connection
 */
@SuppressWarnings({"all"})
public class JdbcDemo_Connection {
    public static void main(String[] args) throws Exception {
        //1.注册驱动,默认执行
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.通过注册的去驱动获取数据库的连接
        //如果连接的是本机mysql并且端口是默认的 3306 可以简化书写
        String url = "jdbc:mysql:///mydb1?useSSL=false";
        String username = "root";
        String password = "ljf684684";
        Connection connection = DriverManager.getConnection(url, username, password);
        //3.定义sql语句
        String sql1 = "update employee set name = '我是老六' where id = 1";
        String sql2 = "update employee set name = '我是老七' where id = 2";
        //4.获取执行sql的对象，通过连接到数据库的对象
        Statement statement = connection.createStatement();

        try {
            //开启事务
            connection.setAutoCommit(false);//关闭Idea的自动提交
            //5.执行sql语句
            int i = statement.executeUpdate(sql1);
            System.out.println(i);

            //制造异常ArithmeticException
//            int a = 2 / 0;

            //5.执行sql语句
            int i1 = statement.executeUpdate(sql2);
            System.out.println(i1);
            //6.处理结果
            //提交事务，程序运行到这里说明没有出现错误，将刚才对数据库的修改作用到数据库
            connection.commit();
        } catch (SQLException e) {
            //如果执行sql语句的时候出现异常，就不能提交事务
            // ============回滚事务==========
            //程序在出现异常时会执行到这个地方，此时就需要回滚事务
            connection.rollback();
            e.printStackTrace();
        }
        //7.释放资源,后生成的对象先关闭
        statement.close();
        connection.close();
    }
}
