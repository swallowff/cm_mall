package com.cmkj.mall.order.service;

import com.cmkj.mall.common.api.CommonPage;
import com.cmkj.mall.common.constant.resultcode.GoodsResultCode;
import com.cmkj.mall.common.constant.states.CommonStateEnums;
import com.cmkj.mall.common.exception.ServiceException;
import com.cmkj.mall.mapper.oms.OmsCartItemMapper;
import com.cmkj.mall.mapper.pms.PmsProductCategoryAttributeRelationMapper;
import com.cmkj.mall.mapper.pms.PmsProductMapper;
import com.cmkj.mall.mapper.pms.PmsSkuStockMapper;
import com.cmkj.mall.mapper.ums.UmsMemberMapper;
import com.cmkj.mall.model.oms.OmsCartItem;
import com.cmkj.mall.model.oms.OmsCartItemExample;
import com.cmkj.mall.model.pms.PmsProduct;
import com.cmkj.mall.model.pms.PmsProductCategoryAttributeRelation;
import com.cmkj.mall.model.pms.PmsProductCategoryAttributeRelationExample;
import com.cmkj.mall.model.pms.PmsSkuStock;
import com.cmkj.mall.model.ums.UmsMember;
import com.cmkj.mall.order.dto.res.CartItemsListRes;
import com.cmkj.mall.order.wrapper.CartItemsResWrapper;
import com.cmkj.mall.order.wrapper.mapstruct.CartMapstruct;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;
import java.util.Date;
import java.util.List;

/**
 * @author swallowff
 * @create 2019/10/13
 */
@Service
public class CartApiService {
    @Autowired
    private OmsCartItemMapper cartItemMapper;
    @Autowired
    private UmsMemberMapper memberMapper;
    @Autowired
    private PmsSkuStockMapper skuStockMapper;
    @Autowired
    private PmsProductMapper productMapper;
    @Autowired
    private PmsProductCategoryAttributeRelationMapper pcaRelationMapper;

    public int addOrUpdateItem(Long memberId, Long skuId, int quantity) {
        OmsCartItemExample example = new OmsCartItemExample();
        example.createCriteria()
                .andMemberIdEqualTo(memberId)
                .andProductSkuIdEqualTo(skuId)
                .andDeleteStatusEqualTo(CommonStateEnums.DeleteStatus.NORMAL.getVal());
        List<OmsCartItem> list = cartItemMapper.selectByExample(example);
        if (!list.isEmpty()){
            //用户已添加过相同的sku,只增加数量
            OmsCartItem existItem = list.get(0);
            existItem.setQuantity(existItem.getQuantity() + quantity);
            return cartItemMapper.updateByPrimaryKeySelective(existItem);
        }else {
            PmsSkuStock sku = skuStockMapper.selectByPrimaryKey(skuId);
            if (sku == null){
                throw new ServiceException(GoodsResultCode.GOODS_EXPIRED);
            }
            PmsProduct spu = productMapper.selectByPrimaryKey(sku.getProductId());
            if (spu == null){
                throw new ServiceException(GoodsResultCode.GOODS_EXPIRED);
            }
            UmsMember member = memberMapper.selectByPrimaryKey(memberId);
            OmsCartItem cartItem = new OmsCartItem();
            cartItem.setMemberId(memberId);
            cartItem.setProductSkuId(skuId);
            cartItem.setDeleteStatus(CommonStateEnums.DeleteStatus.NORMAL.getVal());
            cartItem.setMemberNickname(member.getNickname());
            cartItem.setQuantity(quantity);
            cartItem.setProductId(spu.getId());
            cartItem.setProductName(spu.getName());
            cartItem.setProductSubTitle(spu.getSubTitle());
            cartItem.setProductCategoryId(spu.getProductCategoryId());
            cartItem.setPrice(sku.getPrice());
            cartItem.setProductPic(sku.getPic());
            cartItem.setProductSkuCode(sku.getSkuCode());
            cartItem.setSp1(sku.getSp1());
            cartItem.setSp2(sku.getSp2());
            cartItem.setSp3(sku.getSp3());
            cartItem.setCreateDate(new Date());
            cartItem.setModifyDate(new Date());
            return cartItemMapper.insertSelective(cartItem);
        }
    }

    public CommonPage<OmsCartItem> listItemsPage(Long memberId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        OmsCartItemExample example = new OmsCartItemExample();
        example.createCriteria().andMemberIdEqualTo(memberId);
        List<OmsCartItem> list = cartItemMapper.selectByExample(example);
        return CommonPage.restPage(list);
    }
}
