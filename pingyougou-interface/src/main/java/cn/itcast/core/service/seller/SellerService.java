package cn.itcast.core.service.seller;

import cn.itcast.core.pojo.seller.Seller;
import cn.itcast.utilsBean.PageInfo;

import java.util.Map;

public interface SellerService {

    /**
     * 增加商家--》商家注册
     * @param seller
     */
    void add(Seller seller);

    /**
     * 查询商家 分页
     * @param seller
     * @return
     */
    PageInfo<Seller> search(Integer pageNum, Integer pageSize,Seller seller);


    /**
     * 回显商家信息
     * @param id
     * @return
     */
    Seller findOne(String id);


    /**
     * 审核商家
     * @param sellerId
     * @param status  0：未审核 1：审核通过 2：审和未通过 3：删除
     */
    void updateStatus(String sellerId, String status);
}
