package priv.ljf.jdbc_api_.PreparedStatement_;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//使用PreparedStatement改进sql注入问题
public class JdbcPreparedStatement {
    public static void main(String[] args) throws Exception {
        //2. 获取连接：如果连接的是本机mysql并且端口是默认的 3306 可以简化书写
        String url = "jdbc:mysql:///db1";
        String username = "root";
        String password = "ljf684684";
        Connection connection = DriverManager.getConnection(url, username, password);

        // 接收用户输入 用户名和密码
        String name = "zhangsan";
        String pwd = "' or '1' = '1";

        //定义sql语句
        String sql = "select * from tb_user where username = ? and password = ?";
        //获取执行sql的对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //设置?的值
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,pwd);
        /**
        setXxx(参数1，参数2)：给 ? 赋值
        * Xxx：数据类型 ； 如 setInt (参数1，参数2)
        * 参数：
          * 参数1： ？的位置编号，从1 开始
          * 参数2： ？的值
         */


        //select * from tb_user where username = 'sjdljfld' and password = '\'or \'1\' = \'1'
        //执行sql
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            System.out.println("登陆成功");
        }else {
            System.out.println("登陆失败");
        }
        //释放资源
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
