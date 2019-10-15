package com.cmkj.mall.order.wrapper.mapstruct;

import com.cmkj.mall.model.oms.OmsCartItem;
import com.cmkj.mall.order.dto.res.CartItemsListRes;
import com.cmkj.mall.order.entity.CartGoods;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CartMapstruct {
    CartMapstruct INSTANCE = Mappers.getMapper(CartMapstruct.class);

    @Mapping(source = "id",target = "itemId")
    CartItemsListRes cartItemsRes(OmsCartItem cartItem);


}
