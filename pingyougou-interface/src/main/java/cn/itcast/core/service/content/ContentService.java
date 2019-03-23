package cn.itcast.core.service.content;

import cn.itcast.core.pojo.ad.Content;
import cn.itcast.utilsBean.PageInfo;

import java.util.List;

/**
 *  广告
 */
public interface ContentService {

    void add(Content content);

    void delete(Long[] ids);

    void update(Content content);

    PageInfo<Content> search(Integer page, Integer rows, Content content);

    Content findOne(Long id);

    /**
     *  用户前台展示轮播图
     * @param categoryId
     * @return
     */
    List<Content> findByCategoryId(Long categoryId);
}
