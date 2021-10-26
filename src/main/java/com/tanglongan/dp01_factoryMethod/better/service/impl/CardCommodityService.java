package com.tanglongan.dp01_factoryMethod.better.service.impl;

import com.alibaba.fastjson.JSON;
import com.tanglongan.dp01_factoryMethod.better.service.ICommodity;
import com.tanglongan.dp01_factoryMethod.common.card.IQiYiCardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class CardCommodityService implements ICommodity {

    private static final Logger logger = LoggerFactory.getLogger(CardCommodityService.class);
    //模拟注入
    private IQiYiCardService iQiYiCardService = new IQiYiCardService();

    @Override
    public void sendCommodity(String uid, String commodityId, String bizId, Map<String, String> extMap) {
        String mobile = queryUserMobile(uid);
        iQiYiCardService.grantToken(mobile, bizId);
        logger.info("请求参数[爱奇艺兑换卡] => uId：{} commodityId：{} bizId：{} extMap：{}", uid, commodityId, bizId, JSON.toJSON(extMap));
        logger.info("测试结果[爱奇艺兑换卡]：success");
    }

    private String queryUserMobile(String uId) {
        return "15200101232";
    }

}
