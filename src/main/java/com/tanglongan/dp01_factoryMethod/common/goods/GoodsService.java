package com.tanglongan.dp01_factoryMethod.common.goods;

import com.alibaba.fastjson.JSON;

/**
 * 模拟发货
 */
public class GoodsService {

    public Boolean deliverGoods(DeliverReq req) {
        System.out.println("模拟发货实物商品一个：" + JSON.toJSONString(req));
        return true;
    }
}
