package com.qst.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.qst.entity.Goods;
/*import com.qst.entity.Goods;*/
import com.qst.entity.GoodsType;
@Repository("adminTypeDao")
@Mapper
public interface AdminTypeDao {
    public List<GoodsType> selectGoodsType();
    public int addType(String typename);
    public int addType2(Map <String ,Object> map);
    public int deleteType(Integer id);
    public List<Goods> selectGoodsByType(Integer id);
    /**
     * 根据id查询商品分类信息
     * @param goodTypeId
     * @return
     */
    public GoodsType selectGoodType(int goodTypeId);
}
