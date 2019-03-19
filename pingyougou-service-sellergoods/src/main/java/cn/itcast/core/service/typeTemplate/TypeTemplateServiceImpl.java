package cn.itcast.core.service.typeTemplate;

import cn.itcast.core.dao.template.TypeTemplateDao;
import cn.itcast.core.pojo.template.TypeTemplate;
import cn.itcast.core.pojo.template.TypeTemplateQuery;
import cn.itcast.utilsBean.PageInfo;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TypeTemplateServiceImpl implements TypeTemplateService {

    @Resource
    private TypeTemplateDao typeTemplateDao;


    /**
     * 查询分页
     * @param pageNum
     * @param pageSize
     * @param typeTemplate
     * @return
     */
    @Override
    public PageInfo<TypeTemplate> search(Integer pageNum, Integer pageSize, TypeTemplate typeTemplate) {
        TypeTemplateQuery typeTemplateQuery = new TypeTemplateQuery();
        PageHelper.startPage(pageNum, pageSize);
        if (typeTemplate != null) {
            if (typeTemplate.getName() != null && !"".equals(typeTemplate.getName().trim())) {
                typeTemplateQuery.createCriteria().andNameLike("%" + typeTemplate.getName() + "%");
            }
        }

        Page<TypeTemplate> page = (Page<TypeTemplate>) typeTemplateDao.selectByExample(typeTemplateQuery);

        return new PageInfo<TypeTemplate>(page.getTotal(), page);
    }


    /**
     * 新增数据尺寸模板
     *
     * @param typeTemplate
     */
    @Override
    @Transactional
    public void add(TypeTemplate typeTemplate) {
        typeTemplateDao.insertSelective(typeTemplate);
    }

    /**
     * 更新数据
     *
     * @param typeTemplate
     */
    @Override
    @Transactional
    public void upadte(TypeTemplate typeTemplate) {
        typeTemplateDao.updateByPrimaryKeySelective(typeTemplate);
    }

    /**
     * 回显数据
     *
     * @param id
     * @return
     */
    @Override
    public TypeTemplate findOne(Long id) {
        return typeTemplateDao.selectByPrimaryKey(id);
    }

    /**
     * 删除数据
     *
     * @param ids
     */
    @Override
    @Transactional
    public void delete(Long[] ids) {
        if(ids !=null && ids.length >0){
           typeTemplateDao.deleteByPrimaryKeys(ids);
        }
    }
}
