package priv.ljf.jdbc_api_.ResultSet_;
//案例
//需求：查询account账户表数据，封装为Account对象中，并且存储到ArrayList集合中

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * 查询account账户表数据，封装为Account对象中，并且存储到ArrayList集合中
 * 1. 定义实体类Account
 * 2. 查询数据，封装到Account对象中
 * 3. 将Account对象存入ArrayList集合中
 */@SuppressWarnings({"All"})
public class ResultSetExercise {
    public static void main(String[] args) throws Exception {
        //1.注册驱动
        //2.获取数据库连接的操作对象
        Connection connection = DriverManager.getConnection("jdbc:mysql:///db1", "root", "ljf684684");
        //3.定义 sql语句
        String sql = "select * from tb_user";
        //4.获取执行sql的对象
        Statement statement = connection.createStatement();
        //5.执行sql，返回结果集对象
        ResultSet resultSet = statement.executeQuery(sql);
        //6.处理结果集
        ArrayList<Account> accounts = new ArrayList<>();
        while (resultSet.next()){
            //将结果存储到Account对象中
            Account account = new Account(resultSet.getInt("id"),resultSet.getString("username"),
            resultSet.getString("password"));
            //添加到集合中
            accounts.add(account);
        }
        //输出集合结果
        for (Object o : accounts) {
            System.out.println(o);
        }
        //7.关闭连接
        resultSet.close();
        statement.close();
        connection.close();

    }
}

class Account{
    private int id;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Account() {
    }

    public Account(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
