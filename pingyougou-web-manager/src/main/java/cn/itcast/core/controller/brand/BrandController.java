package cn.itcast.core.controller.brand;

import cn.itcast.core.pojo.good.Brand;
import cn.itcast.core.service.brand.BrandService;
import cn.itcast.utilsBean.PageInfo;
import cn.itcast.utilsBean.Result;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Reference
    private BrandService brandService;

    @RequestMapping("/findAll")
    public List<Brand> findAll(){
        return brandService.findAll();
    }


    //不带条件查询
    @RequestMapping("/findPage")
    public PageInfo<Brand> findPage1(@RequestParam("pageNum") int pageNum_, int pageSize){
        return search(pageNum_,pageSize,new Brand());
    }

    //品牌分页 可带条件
    @RequestMapping("/search")
    public PageInfo<Brand> search(@RequestParam("pageNum") int pageNum_, int pageSize,@RequestBody  Brand brand){
        return brandService.findByPage(pageNum_,pageSize,brand);
    }



    //添加品牌
    @RequestMapping("/add")
    public Result add(@RequestBody Brand brand){
        try {
            brandService.add(brand);
            return new Result(true,"添加成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"添加失败！");
        }

    }

    //根据id查询品牌--》回显品牌
    @RequestMapping("/findOne")
    public Brand findOne(Long id){
        return brandService.findById(id);
    }

    //根据主键跟新品牌
    @RequestMapping("/update")
    public Result update(@RequestBody Brand brand){
        try {
            brandService.updateByPrimikey(brand);
            return new Result(true,"更新成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"更新失败");
        }
    }

    //根据主键删除品牌
    @RequestMapping("/delete")
    public Result delete(@RequestBody  Long[] ids){
        if(ids != null && ids.length >0){
            try {
                brandService.delteByPrimaryKey(ids);
                return new Result(true,"删除成功！");
            } catch (Exception e) {
                e.printStackTrace();
                return new Result(false,"删除失败！");
            }
        }
        return new Result(false,"请选择要删除的数据");

    }

    /**
     * 查询所有品牌，供模板使用 json[{id:..,text:..},{}] select2 多选框使用
     * @return
     */
    @RequestMapping("/selectOptionList.do")
    public List<Map<String ,Object>> selectOptionList(){
        return brandService.selectOptionList();
    }
}
