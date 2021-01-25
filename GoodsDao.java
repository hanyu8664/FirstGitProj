package cn.kgc.dao;

import cn.kgc.entity.Goods;

import java.util.List;

/**
 * @author 韩宇
 * @create 2021/1/20 11:20
 */
public interface GoodsDao {
    List<Goods> getAllGoods();
    List<Goods> getByGoods(Integer id);
    Integer addGoods(Goods goods);
    Integer deleteGoods(Integer ID);
    Integer updateGoods(Goods goods);
}
