package com.tanglongan.dp01_factoryMethod.better.service;

import java.util.Map;

/**
 * 为不同的商品定义统一的入口方法，这样不同商品的实例，可以按需要实例化
 */
public interface ICommodity {
    void sendCommodity(String uid, String commodityId, String bizId, Map<String, String> extMap) throws Exception;
}
