package priv.ljf.jdbc_.ResultSet_;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 执行DQL,对结果集优化
 */
@SuppressWarnings({"All"})
public class TestDQLImprove {
    public static void main(String[] args) throws Exception{
        //1.注册驱动
//        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql:///mydb6_view", "root", "ljf684684");
        //3.定义sql语句
        String sql = "select * from dept";
        //4.获取执行sql对象
        Statement statement = connection.createStatement();
        //5.执行sql返回结果集对象
        ResultSet resultSet = statement.executeQuery(sql);
        //6.处理结果，遍历结果集
        System.out.println("depton\tdname\tloc");
        while (resultSet.next()){
            //游标指向-1，向下移动并判断
            //通过get方法获取数据
            int depton = resultSet.getInt("deptno");//参数表示第几个数据
            String dname = resultSet.getString("dname");
            String loc = resultSet.getString("loc");
            //输出数据
            System.out.println(depton + "\t\t" + dname + "\t" + loc);
        }
        //7.关闭连接
        resultSet.close();
        statement.close();
        connection.close();

    }
}
