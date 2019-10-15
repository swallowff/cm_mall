package com.cmkj.mall.order.entity;

/**
 * @author swallowff
 * @create 2019/10/14
 */
public class CartGoods {
    private String id;
    private String name;

    public CartGoods(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
