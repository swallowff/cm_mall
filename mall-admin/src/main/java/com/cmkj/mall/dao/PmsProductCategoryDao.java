package com.cmkj.mall.dao;

import com.cmkj.mall.dto.PmsProductCategoryWithChildrenItem;
import com.cmkj.mall.dto.PmsProductCategoryWithChildrenItem;

import java.util.List;

/**
 * 商品分类自定义Dao
 * Created by cmkj on 2018/5/25.
 */
public interface PmsProductCategoryDao {
    List<PmsProductCategoryWithChildrenItem> listWithChildren();
}
