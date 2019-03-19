package cn.itcast.core.service.typeTemplate;

import cn.itcast.core.pojo.template.TypeTemplate;
import cn.itcast.utilsBean.PageInfo;

public interface TypeTemplateService {

    /**
     * 查询分页
     * @param pageNum
     * @param pageSize
     * @param typeTemplate
     * @return
     */
    PageInfo<TypeTemplate> search(Integer pageNum, Integer pageSize, TypeTemplate typeTemplate);

    /**
     * 新增数据尺寸模板
     * @param typeTemplate
     */
    void add(TypeTemplate typeTemplate);

    /**
     * 更新数据
     * @param typeTemplate
     */
    void upadte(TypeTemplate typeTemplate);

    /**
     * 回显数据
     * @param id
     * @return
     */
    TypeTemplate findOne(Long id);

    /**
     * 删除数据
     * @param id
     */
    void delete(Long[] id);

}
