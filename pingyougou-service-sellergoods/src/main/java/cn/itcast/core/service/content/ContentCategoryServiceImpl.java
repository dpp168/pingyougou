package cn.itcast.core.service.content;

import cn.itcast.core.dao.ad.ContentCategoryDao;
import cn.itcast.core.pojo.ad.ContentCategory;
import cn.itcast.core.pojo.ad.ContentCategoryQuery;
import cn.itcast.utilsBean.PageInfo;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {
    @Resource
    private ContentCategoryDao contentCategoryDao;

    @Override
    @Transactional
    public void add(ContentCategory contentCategory) {
        contentCategoryDao.insertSelective(contentCategory);
    }

    @Override
    @Transactional
    public void delete(Long[] ids) {
        for (Long id : ids) {
            contentCategoryDao.deleteByPrimaryKey(id);
        }
    }

    @Override
    @Transactional
    public void update(ContentCategory contentCategory) {
        contentCategoryDao.updateByPrimaryKeySelective(contentCategory);
    }

    @Override
    public PageInfo<ContentCategory> search(Integer page, Integer rows, ContentCategory contentCategory) {
        PageHelper.startPage(page,rows);
        ContentCategoryQuery contentCategoryQuery = new ContentCategoryQuery();
        String name = contentCategory.getName();
        if(name != null && !"".equals(name.trim())){
            contentCategoryQuery.createCriteria().andNameLike("%"+name+"%");
        }
        List<ContentCategory> contentCategoryList = contentCategoryDao.selectByExample(contentCategoryQuery);
        Page<ContentCategory> pageh = (Page<ContentCategory>) contentCategoryList;
        return new PageInfo<>(pageh.getTotal(),pageh);
    }

    @Override
    public ContentCategory findOne(Long id) {
        if(id != null){
            return contentCategoryDao.selectByPrimaryKey(id);
        }
        return null;
    }
}
