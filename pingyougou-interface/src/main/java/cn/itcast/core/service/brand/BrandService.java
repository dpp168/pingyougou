package cn.itcast.core.service.brand;

import cn.itcast.core.pojo.good.Brand;
import cn.itcast.utilsBean.PageInfo;

import java.util.List;

public interface BrandService {
    List<Brand> findAll();

    /**
     * 品牌分页
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<Brand> findByPage(int pageNum, int pageSize,Brand brand);

    /**
     * 添加品牌
     * @param brand
     */
    void add(Brand brand);

    /**
     * 根据id查询品牌
     * @param id
     * @return
     */
    Brand findById(Long id);

    /**
     * 更新数据
     * @param brand
     */
    void updateByPrimikey(Brand brand);

    /**
     * 根据用户主键删除用户
     * @param ids
     */
    void delteByPrimaryKey(Long[] ids);


}
