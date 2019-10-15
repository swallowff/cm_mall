package com.cmkj.mall.goods.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @Author:zhangli
 * @Version 1.0
 * 热售，新上商品，更多商品展示
 */
@Getter
@Setter
public class MoreGoods  {

    @ApiModelProperty(value = "商品名字")
    private Long id;

    @ApiModelProperty(value = "品牌类型id")
    private Long brandId;

    @ApiModelProperty(value = "商品名字")
    private String name;

    @ApiModelProperty(value = "图片")
    private String pic;

    @ApiModelProperty(value = "新品状态:0->不是新品；1->新品")
    private Integer newStatus;

    @ApiModelProperty(value = "销量")
    private Integer sale;

    @ApiModelProperty(value = "价格")
    private BigDecimal price;

    @ApiModelProperty(value = "库存")
    private Integer stock;




}
