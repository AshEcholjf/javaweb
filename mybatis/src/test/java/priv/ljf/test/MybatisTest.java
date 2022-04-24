package priv.ljf.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import priv.ljf.mapper.BrandMapper;
import priv.ljf.pojo.Brand;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings({"all"})
public class MybatisTest {


    @Test
    public void testSelectAll() throws Exception {
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
    public void testById() throws Exception {
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

    //条件查询测试
    @Test
    public void testByCondition() throws Exception {
        //接受用户输入的参数
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        //对参数进行处理
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        Brand brand = new Brand();
//        brand.setBrandName(brandName);
//        brand.setCompanyName(companyName);
//        brand.setStatus(status);

        //1.获取sqlSessionFactory对象加载mybatis配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2.获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.获取Mapper接口代理对象，用来做执行对应的sql方法
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //4.执行sql语句
        //方式一 ：接口方法参数使用 @Param 方式调用的方法
//        List<Brand> brands = mapper.selectByCondition(status, companyName, brandName);
        //方式二 ：接口方法参数是 实体类对象 方式调用的方法
        List<Brand> brands = mapper.selectByCondition(brand);

        //方式三 ：接口方法参数是 map集合对象 方式调用的方法
//        Map<Object, Object> map = new HashMap<>();
//        map.put("status",status);
//        map.put("companyName",companyName);
//        map.put("brandName",brandName);
//        List<Brand> brands = mapper.selectByCondition(map);
        System.out.println(brands);
        //5.释放资源
        sqlSession.close();

    }

    @Test
    public void testByConditionSingle() throws Exception {
        //接受用户输入的参数
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        //对参数进行处理
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        Brand brand = new Brand();
//        brand.setBrandName(brandName);
//        brand.setCompanyName(companyName);
//        brand.setStatus(status);

        //1.获取sqlSessionFactory对象加载mybatis配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2.获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.获取Mapper接口代理对象，用来做执行对应的sql方法
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //4.执行sql语句
        List<Brand> brands = mapper.selectByConditionSingle(brand);
        System.out.println(brands);
        //5.释放资源
        sqlSession.close();
    }

    @Test
    public void testAdd() throws Exception {
        //接收参数
        int status = 1;
        String companyName = "波导手机";
        String brandName = "波导";
        String description = "手机中的战斗机";
        int ordered = 100;

        //封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setDescription(description);
        brand.setOrdered(ordered);
        //1.获取sqlSessionFactory对象加载mybatis配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2.获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //SqlSession sqlSession = sqlSessionFactory.openSession(true); //设置自动提交事务，这种情况不需要手动提交事务了
        //3.获取Mapper接口代理对象，用来做执行对应的sql方法
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //4. 执行方法
        mapper.add(brand);
        //提交事务
//        sqlSession.commit();
        //5. 释放资源
        sqlSession.close();

    }

    @Test
    public void testAddOrder() throws Exception {
        //接收参数
        int status = 1;
        String companyName = "波导手机";
        String brandName = "波导";
        String description = "手机中的战斗机";
        int ordered = 100;

        //封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setDescription(description);
        brand.setOrdered(ordered);
        //1.获取sqlSessionFactory对象加载mybatis配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //3.获取Mapper接口代理对象，用来做执行对应的sql方法
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.addOrder(brand);
        System.out.println(brand.getId());
        //5. 释放资源
        sqlSession.close();
    }

    @Test
    public void testUpdate() throws IOException {
        //接收参数
        int status = 0;
        String companyName = "波导手机";
        String brandName = "波导";
        String description = "波导手机,手机中的战斗机";
        int ordered = 200;
        int id = 6;
        //封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
        //        brand.setCompanyName(companyName);
        //        brand.setBrandName(brandName);
        //        brand.setDescription(description);
        //        brand.setOrdered(ordered);
        brand.setId(id);
        //1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        mapper.update(brand);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDelete()throws Exception{
        //接收参数
        int id = 6;
        //1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //3. 获取Mapper接口的代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //4. 执行方法
        mapper.delete(id);
        //5. 释放资源
        sqlSession.close();

    }


}
