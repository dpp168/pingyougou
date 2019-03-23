package cn.itcast.core.controller.seller;

import cn.itcast.core.pojo.seller.Seller;
import cn.itcast.core.service.seller.SellerService;
import cn.itcast.utilsBean.PageInfo;
import cn.itcast.utilsBean.Result;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seller")
public class SellerController {

    @Reference
    private SellerService sellerService;

    //查询待审核的商家信息
    @RequestMapping("/search")
    public PageInfo<Seller> search(Integer page,Integer rows,@RequestBody Seller seller){
        return sellerService.search(page,rows,seller);
    }

    //回显数据
    @RequestMapping("/findOne")
    public Seller findOne(String id){
        return sellerService.findOne(id);
    }

    /**
     *  审核商家
     * @param sellerId
     * @param status 0：未审核 1：审核通过 2：审和未通过 3：删除
     * @return
     */
    @RequestMapping("/updateStatus")
    public Result updateStatus(String sellerId,String status){
        try {
            sellerService.updateStatus(sellerId,status);
            return new Result(true,"审核通过！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"审核未通过");
        }
    }
}
