package com.tanglongan.dp07_bridge.better.mode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 指纹识别
 */
public class PayFingerPrintMode implements IPayMode {

    protected Logger logger = LoggerFactory.getLogger(PayFingerPrintMode.class);

    public boolean security(String uId) {
        logger.info("指纹支付，风控校验指纹信息");
        return true;
    }
}
