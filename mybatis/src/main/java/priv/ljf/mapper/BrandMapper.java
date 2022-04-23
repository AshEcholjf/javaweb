package priv.ljf.mapper;

import org.apache.ibatis.annotations.Param;
import priv.ljf.pojo.Brand;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    /**
     * 查询所有
     */
    List<Brand> selectAll();
    /**
     * 查询详情:根据id查询
     */
    Brand selectById(int id);

    /**
     * 条件查询：
     *         *参数接受
     *              1.  散装参数：如果方法中有多个参数，需要使用@param("sql参数占位符名称")
     *              2.对象参数：将多个参数封装成一个 实体对象 ，将该实体对象作为接口的方法参数。
     *              3.map集合参数：将多个参数封装到map集合中，将map集合作为接口的方法参数。
     */
//    使用 `@Param("参数名称")` 标记每一个参数，在测试中调用对应的方法，传入参数，sql语句会根据@param标记的名称一一对应
//    List<Brand> selectByCondition(@Param("status")int status,@Param("companyName") String companyName,@Param("brandName") String brandName);
    //该方式要求在映射配置文件的SQL中使用 `#{内容}` 时，里面的内容必须和实体类属性名保持一致。这样在执行sql语句时才能根据占位符里的参数找到对象中对应的参数
    List<Brand> selectByCondition(Brand brand);
    //该方式要求在映射配置文件的SQL中使用 `#{内容}` 时，里面的内容必须和map集合中键的名称一致。以便sql语句根据键找到对应的值
//    List<Brand> selectByCondition(Map map);



}
