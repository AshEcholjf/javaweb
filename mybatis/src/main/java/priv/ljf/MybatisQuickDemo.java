package priv.ljf;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * Mybatis快速入门
 */
public class MybatisQuickDemo {
    public static void main(String[] args) throws Exception{
        //1.加载mybatis的核心配置文件，获取SqlSessionFactory(这个工厂用来获取执行sql的对象)
        //      通常只需要加载一次
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取执行Sql对象SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.执行sql
//        sqlSession.selectOne()可以只获取一行
        List<Object> objects = sqlSession.selectList("test.selectAll");//填入的就是sql映射文件中需要执行sql语句坐标
        ///参数是一个字符串，该字符串必须是映射配置文件的namespace.id
        System.out.println(objects);

        //4.释放资源
        sqlSession.close();

    }
}
