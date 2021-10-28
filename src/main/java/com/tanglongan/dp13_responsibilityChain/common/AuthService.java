package com.tanglongan.dp13_responsibilityChain.common;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 模拟审批工单和查询工单，结果在缓存中
 */
public class AuthService {

    private static final Map<String, Date> authMap = new ConcurrentHashMap<>();

    /**
     * 查询审批结果
     */
    public static Date queryAuthInfo(String uid, String orderId) {
        return authMap.get(uid.concat(orderId));
    }

    /**
     * 审批工单
     */
    public static void auth(String uid, String orderId) {
        authMap.put(uid.concat(orderId), new Date());
    }

}
