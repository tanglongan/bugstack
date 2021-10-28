package com.tanglongan.dp07_bridge.better.channel;

import com.tanglongan.dp07_bridge.better.mode.IPayMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * 支付渠道
 */
public abstract class IPay {

    protected Logger logger = LoggerFactory.getLogger(IPay.class);

    protected IPayMode payModel;


    public IPay(IPayMode payModel) {
        this.payModel = payModel;
    }

    public abstract String transfer(String uId, String tradeId, BigDecimal amount);

}
