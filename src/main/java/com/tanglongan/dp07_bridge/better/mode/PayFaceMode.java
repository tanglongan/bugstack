package com.tanglongan.dp07_bridge.better.mode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 脸部识别
 */
public class PayFaceMode implements IPayMode {

    protected Logger logger = LoggerFactory.getLogger(PayFaceMode.class);

    @Override
    public boolean security(String uId) {
        logger.info("人脸支付，风控校验脸部识别");
        return true;
    }

}
