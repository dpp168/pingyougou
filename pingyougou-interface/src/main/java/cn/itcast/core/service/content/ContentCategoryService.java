package cn.itcast.core.service.content;

import cn.itcast.core.pojo.ad.ContentCategory;
import cn.itcast.utilsBean.PageInfo;

/**
 *  广告分类
 */
public interface ContentCategoryService {

    void add(ContentCategory contentCategory);

    void delete(Long[] ids);

    void update(ContentCategory contentCategory);

    PageInfo<ContentCategory> search(Integer page, Integer rows, ContentCategory contentCategory);

    ContentCategory findOne(Long id);
}
