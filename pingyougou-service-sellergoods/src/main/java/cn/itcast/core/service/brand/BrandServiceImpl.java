package cn.itcast.core.service.brand;

import cn.itcast.core.dao.good.BrandDao;
import cn.itcast.core.pojo.good.Brand;
import cn.itcast.core.pojo.good.BrandQuery;
import cn.itcast.utilsBean.PageInfo;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Resource
    private BrandDao brandDao;

    @Override
    public List<Brand> findAll() {
        System.out.println("......");
        List<Brand> list = brandDao.selectByExample(null);
        return list;
    }

    @Override
    public PageInfo findByPage(int pageNum, int pageSize,Brand brand) {
        if(brand != null){
            if(brand.getId() == null && brand.getName() ==null && brand.getFirstChar() == null){
                PageHelper.startPage(pageNum,pageSize);
                List<Brand> list = brandDao.selectByExample(null);

                Page page = (Page) list;
                return new PageInfo(page.getTotal(),page.getResult()) ;

            }else{
                BrandQuery brandQuery = new BrandQuery();
                BrandQuery.Criteria criteria = brandQuery.createCriteria();

                //sql拼接
                if(brand.getName() != null && brand.getName().trim().length() >0){
                    criteria.andNameLike("%"+brand.getName()+"%");
                }
                if(brand.getFirstChar() !=null && brand.getFirstChar().trim().length() >0){
                    criteria.andFirstCharLike("%"+brand.getFirstChar()+"%");
                }

                PageHelper.startPage(pageNum,pageSize);
                List<Brand> list = brandDao.selectByExample(brandQuery);
                Page page = (Page) list;
                return new PageInfo(page.getTotal(),page.getResult()) ;

             }

        }
        return null;

    }

    @Override
    public void add(Brand brand) {
        brandDao.insert(brand);
    }

    /**
     * 根据id查询品牌
     *
     * @param id
     * @return
     */
    @Override
    public Brand findById(Long id) {
        return brandDao.selectByPrimaryKey(id);
    }

    /**
     * 更新数据
     *
     * @param brand
     */
    @Override
    public void updateByPrimikey(Brand brand) {
        brandDao.updateByPrimaryKeySelective(brand);
    }

    /**
     * 根据用户主键删除用户
     *
     * @param ids
     */
    @Override
    public void delteByPrimaryKey(Long[] ids) {
        if (ids != null && ids.length > 0) {
            for (int i = 0; i < ids.length; i++) {
                brandDao.deleteByPrimaryKey(ids[i]);
            }
        }
    }
}
