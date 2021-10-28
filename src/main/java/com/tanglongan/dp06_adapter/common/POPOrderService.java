package com.tanglongan.dp06_adapter.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class POPOrderService {

    private static final Logger logger = LoggerFactory.getLogger(POPOrderService.class);

    /**
     * 查询第三方订单是否为首单
     */
    public boolean isFirstOrder(String uId) {
        logger.info("POP商家，查询用户的订单是否为首单：{}", uId);
        return true;
    }

}
