package com.cmkj.mall.goods.controller;

import com.cmkj.mall.common.annotation.ApiVersion;
import com.cmkj.mall.common.api.CommonPage;
import com.cmkj.mall.common.api.CommonResult;
import com.cmkj.mall.goods.entity.HotSaleGoods;
import com.cmkj.mall.goods.service.HotSaleGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 热售，新上 商品Controller
 * @Author:zhangli
 * @Version 1.0
 */
@ApiVersion(1)
@RestController
@RequestMapping(value = "{version}/api/mall/goods/hot")
public class HotSaleGoodsController {

    @Autowired
    private HotSaleGoodsService hotSaleGoodsService;

    /**
     * 热售商品 只有商品名称，热售状态，图片，id
     * @param pageSize
     * @param pageNum
     * @return
     */
    @RequestMapping(value = "/sale",method = RequestMethod.POST)
    public CommonResult<CommonPage<HotSaleGoods>> getHotSaleGoods(@RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
                                                                  @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
        return CommonResult.success(hotSaleGoodsService.getHotSaleGoodsList(pageSize,pageNum));
    }

    /**
     * 新上商品  只有商品名称，价格，图片，id，新品状态
     * @param pageSize
     * @param pageNum
     * @return
     */
    @RequestMapping(value = "/new",method = RequestMethod.POST)
    public CommonResult<CommonPage<HotSaleGoods>> getNewGoodsList(@RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
                                                            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
        return CommonResult.success(hotSaleGoodsService.getNewGoodsList(pageSize,pageNum));
    }
}
