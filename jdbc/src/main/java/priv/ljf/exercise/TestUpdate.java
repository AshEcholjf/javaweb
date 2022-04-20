package priv.ljf.exercise;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

/**
 * 修改数据
 * 1.SQL:update tb_brand
 *          set brand_name  = ?,
 *          company_name= ?,
 *          ordered     = ?,
 *          description = ?,
 *          status      = ?
 *      where id = ?
 * 2.设置参数
 * 3.结果Boolean
 */
public class TestUpdate {
    public static void main(String[] args) throws Exception{
        //页面接受用户输入的信息
        String brandName = "香飘飘";
        String companyName = "香飘飘";
        int ordered = 1000;
        String description = "绕地球三圈";
        int status = 1;
        int id = 4;

        //加载配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("jdbc/src/main/resources/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        //获取连接
        Connection connection = dataSource.getConnection();
        //定义sql语句
        String sql = " update tb_brand\n" +
                "         set brand_name  = ?,\n" +
                "         company_name= ?,\n" +
                "         ordered     = ?,\n" +
                "         description = ?,\n" +
                "         status      = ?\n" +
                "     where id = ?";
        //获取执行sql的对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //设置参数
        preparedStatement.setString(1,brandName);
        preparedStatement.setString(2,companyName);
        preparedStatement.setInt(3,ordered);
        preparedStatement.setString(4,description);
        preparedStatement.setInt(5,status);
        preparedStatement.setInt(6,id);
        //执行sql
        int i = preparedStatement.executeUpdate();
        //处理结果
        System.out.println(i > 0);
        //释放资源
        preparedStatement.close();
        connection.close();


    }
}
