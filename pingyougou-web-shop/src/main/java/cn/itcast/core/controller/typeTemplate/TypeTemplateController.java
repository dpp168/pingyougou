package cn.itcast.core.controller.typeTemplate;

import cn.itcast.core.pojo.template.TypeTemplate;
import cn.itcast.core.service.typeTemplate.TypeTemplateService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/typeTemplate")
public class TypeTemplateController {
    @Reference
    private TypeTemplateService typeTemplateService;

    /**
     * 回显数据 供新增商品使用
     * @param id
     * @return
     */
    @RequestMapping("/findOne.do")
    public TypeTemplate findOne(Long id){
        return typeTemplateService.findOne(id);
    }

    /**
     * 根据模板id 回显规格 以及规格选项的数据 specIds
     *  返回数据格式： [{"id(规格id)":XX,"text（规格名称）":XX,options（规格选项）:[{规格选项}，{规格选项}]}]
     * @param id
     * @return
     */
    @RequestMapping("/findBySpecList.do")
    public List<Map> findBySpecList(Long id){
       return typeTemplateService.findBySpecList(id);
    }

}
