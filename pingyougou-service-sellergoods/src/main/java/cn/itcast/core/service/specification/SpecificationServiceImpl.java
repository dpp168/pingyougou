package cn.itcast.core.service.specification;

import cn.itcast.core.dao.specification.SpecificationDao;
import cn.itcast.core.dao.specification.SpecificationOptionDao;
import cn.itcast.core.pojo.specification.Specification;
import cn.itcast.core.pojo.specification.SpecificationOption;
import cn.itcast.core.pojo.specification.SpecificationOptionQuery;
import cn.itcast.core.pojo.specification.SpecificationQuery;
import cn.itcast.core.pojo.specificationVo.SpecificationVo;
import cn.itcast.utilsBean.PageInfo;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SpecificationServiceImpl implements SpecificationService {
    @Resource
    private SpecificationDao specificationDao;

    @Resource
    private SpecificationOptionDao specificationOptionDao;


    /**
     * 查询分页
     *
     * @param pageNum
     * @param pageSize
     * @param specification
     * @return
     */
    @Override
    public PageInfo<Specification> search(Integer pageNum, Integer pageSize, Specification specification) {
        SpecificationQuery specificationQuery = new SpecificationQuery();
        if(specification != null){
            if(specification.getSpecName() != null && !specification.getSpecName().trim().equals("")){
                specificationQuery.createCriteria().andSpecNameLike("%"+specification.getSpecName()+"%");
            }
        }
        PageHelper.startPage(pageNum,pageSize);
        Page page = (Page) specificationDao.selectByExample(specificationQuery);

        return new PageInfo<Specification>(page.getTotal(),page);
    }

    /**
     * 增加
     * @param specificationVo
     */
    @Override
    @Transactional
    public void add(SpecificationVo specificationVo) {
        Specification specification = specificationVo.getSpecification();
        specificationDao.insertSelective(specification);
        //返回自增主键 ，跟据主键插入自增主键
        Long id = specification.getId();
        List<SpecificationOption> specificationOptionList = specificationVo.getSpecificationOptionList();
        if(specificationOptionList != null && specificationOptionList.size() >0){
            for (SpecificationOption option : specificationOptionList) {
                option.setSpecId(id);
                specificationOptionDao.insertSelective(option);
            }
        }
    }

    /**
     * 回显数据
     * @param id
     * @return
     */
    @Override
    public SpecificationVo findOne(Long id) {
        SpecificationVo specificationVo = new SpecificationVo();
        Specification specification = specificationDao.selectByPrimaryKey(id);
        specificationVo.setSpecification(specification);
        //根据id查询规格分类表
        SpecificationOptionQuery specificationOptionQuery = new SpecificationOptionQuery();
        specificationOptionQuery.createCriteria().andSpecIdEqualTo(id);
        List<SpecificationOption> specificationOptionList = specificationOptionDao.selectByExample(specificationOptionQuery);
        specificationVo.setSpecificationOptionList(specificationOptionList);
        return specificationVo;
    }

    /**
     * 更新
     * @param specificationVo
     */
    @Override
    @Transactional
    public void update(SpecificationVo specificationVo) {
        Specification specification = specificationVo.getSpecification();
        Long id = specification.getId();
        specificationDao.updateByPrimaryKeySelective(specification);

        //根据主键查询全部规格选项-->先全部删除
        SpecificationOptionQuery specificationOptionQuery = new SpecificationOptionQuery();
        specificationOptionQuery.createCriteria().andSpecIdEqualTo(id);
        List<SpecificationOption> oldList = specificationOptionDao.selectByExample(specificationOptionQuery);
        List<Long> ids = new ArrayList<>();
        if(oldList != null &&oldList.size() >0){
            for (SpecificationOption option : oldList) {
               // specificationOptionDao.deleteByPrimaryKey(option.getId());
               ids.add(option.getId());
            }
            specificationOptionDao.deleteByExamples(ids);
        }
       // int a=1/0;
        //再添加规格选项
       /* List<SpecificationOption> specificationOptionList = specificationVo.getSpecificationOptionList();
        if(specificationOptionList != null && specificationOptionList.size() >0){
           *//* specificationOptionList.forEach(specificationOption -> {
                specificationOptionDao.updateByPrimaryKeySelective(specificationOption);
            });*//* //lamuda表达式会报错
            for (SpecificationOption option : specificationOptionList) {
                    specificationOptionDao.updateByPrimaryKeySelective(option);
                    specificationOptionDao.insert(option);
            }
        }*/

        List<SpecificationOption> specificationOptionList = specificationVo.getSpecificationOptionList();
        if(specificationOptionList != null && specificationOptionList.size() >0){
            for (SpecificationOption option : specificationOptionList) {
                option.setSpecId(id);
               // specificationOptionDao.insertSelective(option);
            }

            //批量插入
            specificationOptionDao.insertSelectives(specificationOptionList);
        }
    }

    /**
     * 删除
     * @param ids
     */
    @Override
    @Transactional
    public void delete(Long[] ids) {
        if(ids != null && ids.length >0){
            for (Long id : ids) {
                SpecificationOptionQuery specificationOptionQuery = new SpecificationOptionQuery();
                specificationOptionQuery.createCriteria().andSpecIdEqualTo(id);
                List<SpecificationOption> specificationOptionList = specificationOptionDao.selectByExample(specificationOptionQuery);
                if(specificationOptionList != null &&specificationOptionList.size() >0){
                    for (SpecificationOption option : specificationOptionList) {
                        specificationOptionDao.deleteByPrimaryKey(option.getId());
                    }
                }
                specificationDao.deleteByPrimaryKey(id);
            }

        }

    }


    /**
     * 查询所有规格选项
     *
     * @return
     */
    @Override
    public List<Map<String, Object>> selectOptionList() {
        return specificationDao.selectOptionList();
    }
}
