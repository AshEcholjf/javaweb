package priv.ljf.exercise;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

/**
 * 查询所有数据
 * 1.SQL:select * from tb_user;
 * 2.不需要参数
 * 3.将结果放入集合zhong
 */
public class TestSelectAll {
    public static void main(String[] args) throws Exception {
        //获取Connection，通过德鲁伊池的工厂
        Properties properties = new Properties();
        properties.load(new FileInputStream("jdbc/src/main/resources/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);//需要加载配置文件\
        Connection connection = dataSource.getConnection();
//        System.out.println(System.getProperty("user.dir"));
        //  定义sql语句
        String sql = "select * from tb_brand";
        //获取执行sql的对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //执行sql返回集合
        ResultSet resultSet = preparedStatement.executeQuery();
        //将集合中的数据放入到自定义的集合
        ArrayList<Brand> brands = new ArrayList<>();
        while (resultSet.next()) {
            Brand brand = new Brand(resultSet.getInt("id"), resultSet.getString("brand_name"), resultSet.getString("company_name"),
                    resultSet.getInt("ordered"), resultSet.getString("description"), resultSet.getInt("status"));
            brands.add(brand);
        }
        //输出结果
        for (Object o :brands) {
            System.out.println(o);
        }
        //释放资源
        preparedStatement.close();
        resultSet.close();
        connection.close();

    }
}
