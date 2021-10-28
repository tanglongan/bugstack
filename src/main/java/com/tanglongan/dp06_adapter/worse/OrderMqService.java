package com.tanglongan.dp06_adapter.worse;

import com.alibaba.fastjson.JSON;
import com.tanglongan.dp06_adapter.common.OrderMq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderMqService {

    private static final Logger logger = LoggerFactory.getLogger(OrderMqService.class);

    public void onMessage(String message) {
        OrderMq mq = JSON.parseObject(message, OrderMq.class);
        logger.info("获取到消息{}，准备消费" + JSON.toJSONString(mq));
    }

}
