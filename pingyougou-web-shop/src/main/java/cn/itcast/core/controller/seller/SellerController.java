package cn.itcast.core.controller.seller;

import cn.itcast.core.pojo.seller.Seller;
import cn.itcast.core.service.seller.SellerService;
import cn.itcast.utilsBean.Result;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/seller")
public class SellerController {

    @Reference
    private SellerService sellerService;


    //商家申请入驻
    @RequestMapping("/add")
    public Result add(@RequestBody Seller seller){
        try {
            sellerService.add(seller);
            return new Result(true,"申请成功！请等待审核。。");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"申请失败");
        }
    }

    //显示当前登陆的用户名
    @RequestMapping("/showName")
    public Map<String ,Object> showName(){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        Map<String, Object > map = new HashMap<>();
        map.put("username",name);
        return map;
    }


}
