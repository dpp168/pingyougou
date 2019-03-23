package cn.itcast.core.service.itemCat;

import cn.itcast.core.pojo.item.ItemCat;

import java.util.List;

public interface ItemCatService {

    /**
     * 根据父id查询商品分类表
     * @param id
     * @return
     */
    List<ItemCat> findByParentId(Long id);

    /**
     * 商品分类表 添加
     * @param itemCat
     */
    void add(ItemCat itemCat);

    /**
     * 商品分类表删除
     * @param ids
     */
    void delete(Long[] ids);

    /**
     * 跟新
     * @param itemCat
     */
    void update(ItemCat itemCat);

    /**
     * 回显数据
     * @param id
     * @return
     */
    ItemCat findOne(Long id);

    List<ItemCat> findAll();
}
