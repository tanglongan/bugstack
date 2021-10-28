package com.tanglongan.dp07_bridge.worse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class WorsePayService {


    private static final Logger logger = LoggerFactory.getLogger(WorsePayService.class);

    /**
     * 将不同支付类型和支付模式组合
     * 缺点：这样的代码在后面的维护以及扩展过程中非常复杂
     */
    public boolean doPay(String uId, String tradeId, BigDecimal amount, int channelType, int modelType) {
        // 微信支付
        if (1 == channelType) {
            logger.info("模拟微信渠道支付划账开始。uId：{} tradeId：{} amount：{}", uId, tradeId, amount);
            if (1 == modelType) {
                logger.info("密码支付，风控校验环境安全");
            } else if (2 == modelType) {
                logger.info("人脸支付，风控校验脸部识别");
            } else if (3 == modelType) {
                logger.info("指纹支付，风控校验指纹信息");
            }
        }
        // 支付宝支付
        else if (2 == channelType) {
            logger.info("模拟支付宝渠道支付划账开始。uId：{} tradeId：{} amount：{}", uId, tradeId, amount);
            if (1 == modelType) {
                logger.info("密码支付，风控校验环境安全");
            } else if (2 == modelType) {
                logger.info("人脸支付，风控校验脸部识别");
            } else if (3 == modelType) {
                logger.info("指纹支付，风控校验指纹信息");
            }
        }
        return true;
    }

}
