package cn.itcast.core.service.brand;

import cn.itcast.core.dao.good.BrandDao;
import cn.itcast.core.pojo.good.Brand;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

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
    public PageInfo<Brand> findByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Brand> list = brandDao.selectByExample(null);
        PageInfo<Brand> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
