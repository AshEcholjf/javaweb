package priv.ljf.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import priv.ljf.mapper.BrandMapper;
import priv.ljf.pojo.Brand;

import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    @Test
    public void testSelectAll()throws Exception{
        //1.获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.获取Mapper接口的代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //4.执行方法
        List<Brand> brands = mapper.selectAll();
        System.out.println(brands);
        //5.释放资源
        sqlSession.close();
    }
    @Test
    public void testById()throws Exception{
        //接受页面传入的id参数
        int id = 1;
        //1.获取SqlSessionFactory对象，加载Mybatis配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.获取Mapper接口代理对象，用来执行sql语句
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //4.执行方法(sql语句)
        Brand brand = mapper.selectById(id);
        System.out.println(brand);
        //5.释放资源
        sqlSession.close();
    }
}
