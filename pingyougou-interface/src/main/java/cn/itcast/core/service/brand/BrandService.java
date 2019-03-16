package cn.itcast.core.service.brand;

import cn.itcast.core.pojo.good.Brand;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface BrandService {
    List<Brand> findAll();
    PageInfo<Brand> findByPage(int pageNum,int pageSize);
}
