package cn.itcast.core.service.specification;

import cn.itcast.core.pojo.specification.Specification;
import cn.itcast.core.pojo.specificationVo.SpecificationVo;
import cn.itcast.utilsBean.PageInfo;

import java.util.List;
import java.util.Map;

public interface SpecificationService {

    /**
     * 查询分页
     * @param pageNum
     * @param pageSize
     * @param specification
     * @return
     */
    PageInfo<Specification> search(Integer pageNum,Integer pageSize,Specification specification);

    /**
     * 增加
     * @param specificationVo
     */
    void add(SpecificationVo specificationVo);

    /**
     * 回显数据
     * @param id
     * @return
     */
    SpecificationVo findOne(Long id);

    /**
     * 更新
     * @param specificationVo
     */
    void update(SpecificationVo specificationVo);

    /**
     * 删除
     * @param ids
     */
    void delete(Long[] ids);

    /**
     * 查询所有规格选项
     * @return
     */
    List<Map<String,Object>> selectOptionList();
}
