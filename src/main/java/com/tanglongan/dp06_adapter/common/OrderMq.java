package com.tanglongan.dp06_adapter.common;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * 订单
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderMq {

    private String uid;           // 用户ID
    private String sku;           // 商品
    private String orderId;       // 订单ID
    private Date createOrderTime; // 下单时间

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
