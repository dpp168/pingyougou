package cn.itcast.core.service.content;

import cn.itcast.core.dao.ad.ContentDao;
import cn.itcast.core.pojo.ad.Content;
import cn.itcast.core.pojo.ad.ContentQuery;
import cn.itcast.utilsBean.PageInfo;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {
    @Resource
    private ContentDao contentDao;

    @Override
    @Transactional
    public void add(Content content) {
        contentDao.insertSelective(content);
    }

    @Override
    @Transactional
    public void delete(Long[] ids) {
        for (Long id : ids) {
            contentDao.deleteByPrimaryKey(id);
        }
    }

    @Override
    @Transactional
    public void update(Content content) {
        contentDao.updateByPrimaryKeySelective(content);
    }

    @Override
    public PageInfo<Content> search(Integer page, Integer rows, Content content) {
        PageHelper.startPage(page,rows);
        ContentQuery contentQuery = new ContentQuery();
        String name = content.getTitle();
        if(name != null && !"".equals(name.trim())){
            contentQuery.createCriteria().andTitleLike("%"+name+"%");
        }
        List<Content> contentList = contentDao.selectByExample(contentQuery);
        Page<Content> pageh = (Page<Content>) contentList;
        return new PageInfo<>(pageh.getTotal(),pageh);
    }

    @Override
    public Content findOne(Long id) {
        if(id != null){
            return contentDao.selectByPrimaryKey(id);
        }
        return null;
    }

    /**
     * 用户前台展示轮播图
     *
     * @param categoryId
     * @return
     */
    @Override
    public List<Content> findByCategoryId(Long categoryId) {
        ContentQuery contentQuery = new ContentQuery();
        contentQuery.createCriteria().andCategoryIdEqualTo(categoryId);
        List<Content> contentList = contentDao.selectByExample(contentQuery);
        return contentList;
    }
}
