package priv.ljf.druid;
/**
 * Druid数据库连接池演示
 */
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

// Driud使用
public class DruidDemo {
    public static void main(String[] args) throws Exception{
        //1.导入jar包
        //2.定义配置文件(输入账户密码等)
        //3.加载配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("jdbc/src/main/resources/druid.properties"));
        //4.获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        //5.获取数据库连接对象
        Connection connection = dataSource.getConnection();
        System.out.println(connection);//获取到了连接后就可以继续做其他操作了
//        System.out.println(System.getProperty("user.dir"));显示当前路径
    }
}
