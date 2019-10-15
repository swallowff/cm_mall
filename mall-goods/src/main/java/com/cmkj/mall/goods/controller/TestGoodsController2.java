package com.cmkj.mall.goods.controller;

import com.cmkj.mall.common.annotation.ApiVersion;
import com.cmkj.mall.common.api.CommonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author swallowff
 * @create 2019/10/11
 */
@ApiVersion(2)
@RestController
@RequestMapping(value = "{version}/api/mall/goods/test")
public class TestGoodsController2 {

    @RequestMapping(value = "ok")
    public CommonResult ok(){
        return CommonResult.success(2 + "goodsOK");
    }

}
