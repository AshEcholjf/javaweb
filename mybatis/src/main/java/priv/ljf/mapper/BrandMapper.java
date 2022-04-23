package priv.ljf.mapper;

import priv.ljf.pojo.Brand;

import java.util.List;

public interface BrandMapper {
    /**
     * 查询所有
     */
    List<Brand> selectAll();
    /**
     * 查询详情:根据id查询
     */
    Brand selectById(int id);
}
