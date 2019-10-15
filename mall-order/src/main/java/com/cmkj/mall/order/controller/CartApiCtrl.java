package com.cmkj.mall.order.controller;

import com.cmkj.mall.common.annotation.ApiVersion;
import com.cmkj.mall.common.api.BaseApiCtrl;
import com.cmkj.mall.common.api.CommonPage;
import com.cmkj.mall.common.api.CommonResult;
import com.cmkj.mall.common.api.ResultCode;
import com.cmkj.mall.model.oms.OmsCartItem;
import com.cmkj.mall.order.dto.CommonPageParam;
import com.cmkj.mall.order.dto.req.CartItemReq;
import com.cmkj.mall.order.dto.res.CartItemsListRes;
import com.cmkj.mall.order.service.CartApiService;
import com.cmkj.mall.order.wrapper.CartItemsResWrapper;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author swallowff
 * @create 2019/10/13
 */
@Api
@ApiVersion(1)
@RestController
@RequestMapping(value = "{version}/api/mall/order/cart")
public class CartApiCtrl extends BaseApiCtrl {
    @Autowired
    private CartApiService cartApiService;

    //添加购物车商品
    @ApiOperation(tags = {"添加购物车商品"},httpMethod = "PUT",value = "addOrUpdateItem",notes = "添加商品")
    @RequestMapping(value = "item",method = RequestMethod.PUT)
    @ApiResponses({
            @ApiResponse(code=1000,message="商品已过期")
    })
    public CommonResult addItem(@Validated CartItemReq req, BindingResult bindingResult){
        validBindingResult(bindingResult);
        int result = cartApiService.addOrUpdateItem(req.getMemberId(),req.getSkuId(),req.getQuantity());
        if (result == 1){
            return CommonResult.success();
        }else {
            return CommonResult.failed();
        }
    }

    @ApiOperation(tags = {"购物车商品列表"},httpMethod = "GET",value = "listItem",notes = "商品列表")
    @RequestMapping(value = "list",method = RequestMethod.GET)
    @ApiResponses({
            @ApiResponse(code=901,message="没有更多数据了")
    })
    @ApiImplicitParam(required = true,name = "memberId",value = "会员ID",paramType = "query")
    public CommonResult<CommonPage<CartItemsListRes>> listItem(Long memberId,
                                                               CommonPageParam pageParam){
        if (null == memberId){
            return CommonResult.validateFailed("memberId不能为空");
        }
        CommonPage<OmsCartItem> page = cartApiService.listItemsPage(memberId,pageParam.getPageNum(),pageParam.getPageSize());
        CommonPage<CartItemsListRes> resPage = page.replace(new CartItemsResWrapper(page.getList()).wrapList());
        if (resPage.isEmpty()){
            return CommonResult.of(ResultCode.EMPTY_RESULT);
        }else {
            return CommonResult.success(resPage);
        }
    }

}
