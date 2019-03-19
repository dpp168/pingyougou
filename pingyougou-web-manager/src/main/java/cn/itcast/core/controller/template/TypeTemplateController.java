package cn.itcast.core.controller.template;

import cn.itcast.core.pojo.template.TypeTemplate;
import cn.itcast.core.service.typeTemplate.TypeTemplateService;
import cn.itcast.utilsBean.PageInfo;
import cn.itcast.utilsBean.Result;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/typeTemplate")
public class TypeTemplateController {

    @Reference
    private TypeTemplateService typeTemplateService;

    /**
     * 条件查询分页
     * @return
     */
    @RequestMapping("/search")
    public PageInfo<TypeTemplate> search(Integer page, Integer rows , @RequestBody TypeTemplate typeTemplate){
        return typeTemplateService.search(page,rows,typeTemplate);
    }

    /**
     * 新增规格模板
     * @param typeTemplate
     * @return
     */
    @RequestMapping("/add.do")
    public Result add(@RequestBody TypeTemplate typeTemplate){
        try {
            typeTemplateService.add(typeTemplate);
            return new Result(true,"添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"添加失败");
        }
    }

    /**
     * 回显数据
     * @param id
     * @return
     */
    @RequestMapping("/findOne.do")
    public TypeTemplate findOne(Long id){
        return typeTemplateService.findOne(id);
    }

    /**
     * 跟新数据
     * @param typeTemplate
     */
    @RequestMapping("/update.do")
    public Result update(@RequestBody TypeTemplate typeTemplate){
        try {
            typeTemplateService.upadte(typeTemplate);
            return new Result(true,"跟新成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"跟新失败！");
        }
    }

    /**
     * 批量删除数据
     * @param ids
     */
    @RequestMapping("/delete.do")
    public Result delete(Long[] ids){
        try {
            typeTemplateService.delete(ids);
            return new Result(true,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"删除失败");
        }
    }

}
