package com.cmkj.mall.dao;

import com.cmkj.mall.model.pms.PmsSkuStock;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 自定义商品sku库存Dao
 * Created by cmkj on 2018/4/26.
 */
public interface PmsSkuStockDao {
    /**
     * 批量插入操作
     */
    int insertList(@Param("list")List<PmsSkuStock> skuStockList);

    /**
     * 批量插入或替换操作
     */
    int replaceList(@Param("list")List<PmsSkuStock> skuStockList);
}
