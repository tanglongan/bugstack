package com.tanglongan.dp06_adapter.worse;

import com.alibaba.fastjson.JSON;
import com.tanglongan.dp06_adapter.common.PopOrderDelivered;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PopOrderDeliveredService {

    private static final Logger logger = LoggerFactory.getLogger(PopOrderDeliveredService.class);

    public void onMessage(String message) {
        PopOrderDelivered mq = JSON.parseObject(message, PopOrderDelivered.class);
        logger.info("获取到消息{}，准备消费" + JSON.toJSONString(mq));
    }

}
