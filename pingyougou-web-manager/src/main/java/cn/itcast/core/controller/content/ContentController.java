package cn.itcast.core.controller.content;

import cn.itcast.core.pojo.ad.Content;
import cn.itcast.core.service.content.ContentService;
import cn.itcast.utilsBean.PageInfo;
import cn.itcast.utilsBean.Result;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *  广告
 */
@RestController
@RequestMapping("/content")
public class ContentController {

    @Reference
    private ContentService contentService;

    @RequestMapping("/add.do")
    public Result add(@RequestBody Content content){
        try {
            contentService.add(content);
            return new Result(true,"添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"添加失败");
        }
    }

    @RequestMapping("/delete.do")
    public Result delete(Long[] ids){
        try {
            contentService.delete(ids);
            return new Result(true ,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"删除失败");
        }
    }

    @RequestMapping("/update.do")
    public Result update(@RequestBody Content content){
        try {
            contentService.update(content);
            return  new Result(true,"跟新成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"跟新失败");
        }
    }

    @RequestMapping("/findOne.do")
    public Content findOne(Long id){
        return contentService.findOne(id);
    }

    @RequestMapping("/search.do")
    public PageInfo<Content> search(Integer page, Integer rows, @RequestBody Content content){
        return contentService.search(page,rows,content);
    }

}
