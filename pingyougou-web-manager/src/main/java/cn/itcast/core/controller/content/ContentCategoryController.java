package cn.itcast.core.controller.content;

import cn.itcast.core.pojo.ad.Content;
import cn.itcast.core.pojo.ad.ContentCategory;
import cn.itcast.core.service.content.ContentCategoryService;
import cn.itcast.utilsBean.PageInfo;
import cn.itcast.utilsBean.Result;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 广告分类
 */
@RequestMapping("/contentCategory")
@RestController
public class ContentCategoryController {

    @Reference
    private ContentCategoryService contentCategoryService;

    @RequestMapping("/add.do")
    public Result add(@RequestBody ContentCategory contentCategory){
        try {
            contentCategoryService.add(contentCategory);
            return new Result(true,"添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"添加失败");
        }
    }

    @RequestMapping("/delete.do")
    public Result delete(Long[] ids){
        try {
            contentCategoryService.delete(ids);
            return new Result(true ,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"删除失败");
        }
    }

    @RequestMapping("/update.do")
    public Result update(@RequestBody ContentCategory contentCategory){
        try {
            contentCategoryService.update(contentCategory);
            return  new Result(true,"跟新成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"跟新失败");
        }
    }

    @RequestMapping("/findOne.do")
    public ContentCategory findOne(Long id){
        return contentCategoryService.findOne(id);
    }

    @RequestMapping("/search.do")
    public PageInfo<ContentCategory> search(Integer page, Integer rows, @RequestBody ContentCategory contentCategory){
        return contentCategoryService.search(page,rows,contentCategory);
    }

}
