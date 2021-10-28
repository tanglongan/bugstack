package com.tanglongan.dp06_adapter.worse;

import com.alibaba.fastjson.JSON;
import com.tanglongan.dp06_adapter.common.CreateAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateAccountMqService {

    private static final Logger logger = LoggerFactory.getLogger(CreateAccountMqService.class);

    public void onMessage(String message) {
        CreateAccount mq = JSON.parseObject(message, CreateAccount.class);
        logger.info("获取到消息{}，准备消费" + JSON.toJSONString(mq));
    }

}
