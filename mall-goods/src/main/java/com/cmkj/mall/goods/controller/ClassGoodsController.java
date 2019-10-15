package com.cmkj.mall.goods.controller;

import com.cmkj.mall.common.annotation.ApiVersion;
import com.cmkj.mall.common.api.CommonPage;
import com.cmkj.mall.common.api.CommonResult;
import com.cmkj.mall.goods.entity.ClassGoods;
import com.cmkj.mall.goods.service.ClassGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:zhangli
 * @Version 1.0
 */
@ApiVersion(1)
@RestController
@RequestMapping(value = "{version}/api/mall/goods/class")
public class ClassGoodsController {

    @Autowired
    private ClassGoodsService classGoodsService;

    /**
     * 根据一级分类的id查询到下面所对应的商品
     * @param pageSize
     * @param pageNum
     * @param id
     * @return
     */
    @RequestMapping(value = "/id")
    public CommonResult<CommonPage<ClassGoods>> getGoods(@RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
                                                         @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,Long id){
          return  CommonResult.success(classGoodsService.getGoods(pageSize,pageNum,id));
    }
}
