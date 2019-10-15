package com.cmkj.mall.goods.controller;

import com.cmkj.mall.common.annotation.ApiVersion;
import com.cmkj.mall.common.api.CommonPage;
import com.cmkj.mall.common.api.CommonResult;
import com.cmkj.mall.goods.entity.MoreGoods;
import com.cmkj.mall.goods.service.MoreGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 更多热售，新上 商品Controller
 * @Author:zhangli
 * @Version 1.0
 */
@ApiVersion(1)
@RestController
@RequestMapping(value = "{version}/api/mall/goods/more")
public class MoreGoodsController {

    @Autowired
    private MoreGoodsService moreGoodsService;

    /**
     * 热售商品 ，展示图片，名称，原价，折扣价，热售状态，库存属性
     * @param pageSize
     * @param pageNum
     * @return
     */
    @RequestMapping(value = "/hotSale",method = RequestMethod.POST)
    public CommonResult<CommonPage<MoreGoods>> getMoreHotSaleGoodsList(@RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
                                                                       @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
        return  CommonResult.success(moreGoodsService.getMoreHotSaleGoodsList(pageSize,pageNum));
    }
    /**
     * 新上商品 ，展示图片，名称，原价，折扣价，新品状态，库存属性
     * @param pageSize
     * @param pageNum
     * @return
     */
    @RequestMapping(value = "/newGood",method = RequestMethod.POST)
    public CommonResult<CommonPage<MoreGoods>> getMoreNewGoodsList(@RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
                                                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
        return CommonResult.success(moreGoodsService.getMoreNewGoodsList(pageSize,pageNum));
    }
}
