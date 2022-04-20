package priv.ljf.jdbc_.Statement_;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * 执行DML语句
 */
@SuppressWarnings({"All"})
public class TestDML {
    public static void main(String[] args) throws Exception {
        //1.注册驱动
        //2.获取连接
        String url = "jdbc:mysql:///mybatis";
        String username = "root";
        String password = "ljf684684";
        Connection connection = DriverManager.getConnection(url, username, password);
        //3.定于sql语句
        String sql = "update tb_user set username = 'lisi' where id = 2";
        //4.获取执行sql的对象
        Statement statement = connection.createStatement();
        //5.执行sql
        int i = statement.executeUpdate(sql);
        //6.处理结果
        if (i > 0){
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }
        //7.释放资源
        statement.close();
        connection.close();
    }
}
