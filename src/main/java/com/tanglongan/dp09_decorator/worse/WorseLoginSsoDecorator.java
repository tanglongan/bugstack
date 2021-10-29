package com.tanglongan.dp09_decorator.worse;


import com.tanglongan.dp09_decorator.common.SsoInterceptor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WorseLoginSsoDecorator extends SsoInterceptor {

    private static final Map<String, String> authMap = new ConcurrentHashMap<>();

    static {
        authMap.put("huahua", "queryUserInfo");
        authMap.put("doudou", "queryUserInfo");
    }

    /**
     * 继承之后，进行了重写
     */
    @Override
    public boolean preHandle(String request, String response, Object handler) {
        //模拟获取Cookie
        String ticket = request.substring(1, 8);
        boolean success = ticket.equals("success");
        //模拟校验
        if (!success) return false;
        String userId = request.substring(8);
        String method = authMap.get(userId);
        // 模拟方法校验
        return "queryUserInfo".equals(method);
    }


}
