package com.tanglongan.dp06_adapter.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    /**
     * 查询用户在内部商家的下单数量
     */
    public long queryUserOrderCount(String userId) {
        logger.info("自营商家，查询用户的订单是否为首单：{}", userId);
        return 10L;
    }

}
