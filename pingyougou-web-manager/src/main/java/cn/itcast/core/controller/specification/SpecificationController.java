package cn.itcast.core.controller.specification;

import cn.itcast.core.pojo.specification.Specification;
import cn.itcast.core.pojo.specificationVo.SpecificationVo;
import cn.itcast.core.service.specification.SpecificationService;
import cn.itcast.utilsBean.PageInfo;
import cn.itcast.utilsBean.Result;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/specification")
public class SpecificationController {
    @Reference
    private SpecificationService specificationService;


    //查询分页
    @RequestMapping("/search")
    public PageInfo<Specification> search(Integer page , Integer rows , @RequestBody Specification specification){
        return specificationService.search(page,rows,specification);
    }

    //分页
    @RequestMapping("/findPage")
    public PageInfo<Specification> findPage(Integer page , Integer rows ){
        return search(page,rows,null);
    }

    //增加规格
    @RequestMapping("/add")
    public Result add(@RequestBody SpecificationVo specificationVo){
        try {
            specificationService.add(specificationVo);
            return new Result(true,"添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"添加失败");
        }
    }

    //回显数据
    @RequestMapping("/findOne")
    public SpecificationVo findOne(Long id){
        return specificationService.findOne(id);
    }

    //更新数据
    @RequestMapping("/update")
    public Result update(@RequestBody SpecificationVo specificationVo){
        try {
            specificationService.update(specificationVo);
            return new Result(true,"更新成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"更新失败！");
        }
    }

    //删除数据
    @RequestMapping("/delete")
    public Result delete(Long[] ids){
        try {
            specificationService.delete(ids);
            return new Result(true,"删除成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"删除失败！");
        }
    }

    /**
     * 查询所有规格，供模板使用 json[{id:..,text:..},{}] select2 多选框使用
     * @return
     */
    @RequestMapping("/selectOptionList.do")
    public List<Map<String ,Object>> selectOptionList(){
          return specificationService.selectOptionList();
    }
}
