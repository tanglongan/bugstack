package com.tanglongan.dp01_factoryMethod.better.service.impl;

import com.alibaba.fastjson.JSON;
import com.tanglongan.dp01_factoryMethod.better.service.ICommodity;
import com.tanglongan.dp01_factoryMethod.common.coupon.CouponResult;
import com.tanglongan.dp01_factoryMethod.common.coupon.CouponService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class CouponCommodityService implements ICommodity {

    private final Logger logger = LoggerFactory.getLogger(CouponCommodityService.class);

    //模拟注入
    private final CouponService couponService = new CouponService();


    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        CouponResult couponResult = couponService.sendCoupon(uId, commodityId, bizId);
        logger.info("请求参数[优惠券] => uId：{} commodityId：{} bizId：{} extMap：{}", uId, commodityId, bizId, JSON.toJSON(extMap));
        logger.info("测试结果[优惠券]：{}", JSON.toJSON(couponResult));
        if (!"0000".equals(couponResult.getCode())) throw new RuntimeException(couponResult.getInfo());
    }

}
