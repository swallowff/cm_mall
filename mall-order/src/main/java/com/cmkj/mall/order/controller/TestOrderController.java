package com.cmkj.mall.order.controller;

import com.cmkj.mall.common.annotation.ApiVersion;
import com.cmkj.mall.common.api.CommonResult;
import com.cmkj.mall.common.util.RedisTemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author swallowff
 * @create 2019/10/11
 */
@ApiVersion(1)
@RestController
@RequestMapping(value = "{version}/api/mall/order/test")
public class TestOrderController {
    @Autowired
    private RedisTemplateUtil redisTemplateUtil;

    @RequestMapping(value = "ok")
    public CommonResult ok() {
        return CommonResult.success(1 + "orderOK");
    }

    @RequestMapping(value = "redis")
    public CommonResult redis(){
        redisTemplateUtil.set("testRedis",1);
        return CommonResult.success("redisOK");
    }

//    @RequestMapping(value = "mapstruct")
//    public CommonResult mapstruct(){
//        CartGoods source = new CartGoods("1","tom");
//        CartItemsListRes res = CartMapstruct.INSTANCE.cartItemsRes(source);
//        return CommonResult.success(res);
//    }

//    @RequestMapping(value = "mapstructList")
//    public CommonResult mapstructList(){
//        CartGoods source = new CartGoods("1","tom");
//        CartGoods source2 = new CartGoods("2","jack");
//        List<CartGoods> sourceList = new ArrayList<>();
//        sourceList.add(source);
//        sourceList.add(source2);
//        CartGoodsResWrapper wraper = new CartGoodsResWrapper(sourceList);
//        List<CartItemsListRes> resList = wraper.wrapList();
//        return CommonResult.success(resList);
//    }

}
