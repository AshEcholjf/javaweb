package priv.ljf.jdbc_api_.PreparedStatement_;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//代码模拟SQL注入问题
public class TestLogin {
    public static void main(String[] args) throws Exception{
        //2. 获取连接：如果连接的是本机mysql并且端口是默认的 3306 可以简化书写
        String url = "jdbc:mysql:///db1";
        String username = "root";
        String password = "ljf684684";
        Connection connection = DriverManager.getConnection(url, username, password);
        //3.获取用户输入的账户名和密码
        String name = "sjdljfld";
        String pwd = "' or '1' = '1";
        String sql = "select * from tb_user where username = '"+name+"' and password = '"+pwd +"'";
        //4.获取执行sql对象
        Statement statement = connection.createStatement();
        //5.执行sql
        ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet.next()){
            System.out.println("success!");
        }else {
            System.out.println("登录失败");
        }
        //6.关闭资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}
