package cn.kgc.dao;

import cn.kgc.entity.Goods;
import cn.kgc.utils.JDBCUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 韩宇
 * @create 2021/1/20 11:22
 */
public class GoodsDaoImpl implements GoodsDao {
    JDBCUtil util = new JDBCUtil();

    @Override
    public List<Goods> getAllGoods() {
        List<Goods> goodsList = new ArrayList<>();
        String sql = "select id,goods_name,bill_status,goods_district,goods_price,goods_count,creation_time from goods";
        ResultSet rs = util.excuteQuery(sql);

        try {
            while (rs.next()) {
                Goods goods = new Goods();
                goods.setId(rs.getInt("id"));
                goods.setGoods_name(rs.getString("goods_name"));
                goods.setBill_status(rs.getInt("bill_status"));
                goods.setGoods_district(rs.getInt("goods_district"));
                goods.setGoods_price(rs.getDouble("goods_price"));
                goods.setGoods_count(rs.getInt("goods_count"));
                goods.setCreation_time(rs.getString("creation_time"));
                goodsList.add(goods);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close();
        }
        return goodsList;
    }

    @Override
    public List<Goods> getByGoods(Integer id) {
        List<Goods> goodsList = new ArrayList<>();
        String sql = "select id,goods_name,bill_status,goods_district,goods_price,goods_count,creation_time from goods where bill_status=?";
        ResultSet rs = util.excuteQuery(sql,id);

        try {
            while (rs.next()) {
                Goods goods = new Goods();
                goods.setId(rs.getInt("id"));
                goods.setGoods_name(rs.getString("goods_name"));
                goods.setBill_status(rs.getInt("bill_status"));
                goods.setGoods_district(rs.getInt("goods_district"));
                goods.setGoods_price(rs.getDouble("goods_price"));
                goods.setGoods_count(rs.getInt("goods_count"));
                goods.setCreation_time(rs.getString("creation_time"));
                goodsList.add(goods);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close();
        }
        return goodsList;
    }

    @Override
    public Integer addGoods(Goods goods) {
        String sql = "insert into goods(goods_name,bill_status,goods_district,goods_price,goods_count,creation_time) values(?,?,?,?,?,?)";
        Integer count = util.excuteUpdate(sql,goods.getGoods_name(),goods.getBill_status(),goods.getGoods_district(),goods.getGoods_price(),goods.getGoods_count(),goods.getCreation_time());
        util.close();
        return count;
    }

    @Override
    public Integer deleteGoods(Integer ID) {
        String sql = "delete from goods where id=?";
        Integer count = util.excuteUpdate(sql,ID);
        util.close();
        return count;
    }

    @Override
    public Integer updateGoods(Goods goods) {
        String sql = "update goods set goods_name=? goods_price=? where id=?";
        Integer count = util.excuteUpdate(sql,goods.getGoods_name(),goods.getGoods_price(),goods.getId());
        util.close();
        return count;
    }
}
