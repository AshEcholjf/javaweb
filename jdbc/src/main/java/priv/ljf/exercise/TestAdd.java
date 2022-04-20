package priv.ljf.exercise;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

/**
 * 添加数据
 * 1.SQL:insert into tb_brand (brand_name,company_name,ordered,description,status) values(?,?,?,?,?);
 * 2.参数：用户输入除id以外的所有数据
 * 3.返回是否添加成功
 */
public class TestAdd {
    public static void main(String[] args) throws Exception {
        //1.接受用户输入的信息
        // 接收页面提交的参数
        String brandName = "香飘飘";
        String companyName = "香飘飘";
        int ordered = 1;
        String description = "绕地球一圈";
        int status = 1;


        //获取连接池对象
        Properties properties = new Properties();
        properties.load(new FileInputStream("jdbc/src/main/resources/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        //从连接池中获取连接到本地数据库的对象
        Connection connection = dataSource.getConnection();
        //定义sql语句
        String sql = "insert into tb_brand (brand_name,company_name,ordered,description,status) values (?,?,?,?,?)";
        //获取执行sql的对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //通过执行sql的对象设置参数
        //第一个id键自动生成，不需要设置
        preparedStatement.setString(1,brandName);
        preparedStatement.setString(2,companyName);
        preparedStatement.setInt(3,ordered);
        preparedStatement.setString(4,description);
        preparedStatement.setInt(5,status);
        //对设置参数进行优化
//        for (int i = 1; i <= 5 ; i++) {
//            preparedStatement.setObject(i,xxx);
//        }
        //执行sql
        int i = preparedStatement.executeUpdate();
        System.out.println(i > 0);
        //释放资源
        preparedStatement.close();
        connection.close();
    }
}
