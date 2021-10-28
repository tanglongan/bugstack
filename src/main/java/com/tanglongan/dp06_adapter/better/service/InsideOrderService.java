package com.tanglongan.dp06_adapter.better.service;

import com.tanglongan.dp06_adapter.common.OrderService;

public class InsideOrderService implements OrderAdapterService {

    private OrderService orderService = new OrderService();

    public boolean isFirst(String uId) {
        return orderService.queryUserOrderCount(uId) <= 1;
    }

}
