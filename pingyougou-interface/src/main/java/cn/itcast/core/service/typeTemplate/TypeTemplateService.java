package cn.itcast.core.service.typeTemplate;

import cn.itcast.core.pojo.template.TypeTemplate;
import cn.itcast.utilsBean.PageInfo;

import java.util.List;
import java.util.Map;

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

    /**
     * 新增规格时查询所有模板id
     * @return
     */
    List<TypeTemplate> findAll();

    /**
     *  根据模板id查询 规格列表
     * @param id
     * @return
     */
    List<Map> findBySpecList(Long id);
}
