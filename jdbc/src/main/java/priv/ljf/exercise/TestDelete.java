package priv.ljf.exercise;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

/**
 * 删除
 * 1. SQL：
 * delete from tb_brand where id = ?
 * 2. 参数：需要，id
 * 3. 结果：boolean
 */
public class TestDelete {
    public static void main(String[] args) throws Exception {
        //接受页面提交的参数
        int id = 4;
        //加载配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("jdbc/src/main/resources/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        //获取连接对象
        Connection connection = dataSource.getConnection();
        //定义sql语句
        String sql = "delete from tb_brand where id = ?";
        //获取执行sql的对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //设置参数
        preparedStatement.setInt(1, id);
        //执行sql
        int i = preparedStatement.executeUpdate();
        //处理结果
        System.out.println(i > 0);
        //释放资源
        preparedStatement.close();
        connection.close();
    }
}
