package cn.itcast.core.service.goods;

import cn.itcast.core.pojo.good.Goods;
import cn.itcast.core.pojo.vo.GoodsVo;
import cn.itcast.utilsBean.PageInfo;
import cn.itcast.utilsBean.Result;

public interface GoodsService {

    /**
     * 商品保存
     * @param goodsVo
     */
    void save(GoodsVo goodsVo);

    /**
     *  根据商家sellerid 查询 商品管理信息
     * @param pageNum
     * @param pageSize
     * @param goods
     * @return
     */
    PageInfo search(Integer pageNum, Integer pageSize, Goods goods);

    /**
     *  根据商品的id回显商品
     * @param id
     * @return
     */
    GoodsVo findOne(Long id);

    /**
     *  商家更新商品
     * @param goodsVo
     */
    void update(GoodsVo goodsVo);

    /**
     *  删除商品
     * @param ids
     */
    void delete(Long[] ids);

    /**
     * 运营商系统 查询 待审核的商家信息
     * @return
     */
    PageInfo<Goods>  searchByManager(Integer page,Integer rows,Goods goods);

    /**
     *  运营商   审核 商品信息
     * @param ids
     * @param status
     * @return
     */
    void updateStatusByManager(Long[] ids,String status);

    /**
     *  运营商 删除商品  设定isdelete 为 1
     * @param ids
     * @return
     */
    void deleteByManager(Long[] ids);
}
