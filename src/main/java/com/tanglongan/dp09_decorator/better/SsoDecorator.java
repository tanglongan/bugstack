package com.tanglongan.dp09_decorator.better;

import com.tanglongan.dp09_decorator.common.HandlerInterceptor;

/**
 * 装饰器抽象类
 */
public abstract class SsoDecorator implements HandlerInterceptor {

    private HandlerInterceptor interceptor;

    public SsoDecorator() {

    }

    public SsoDecorator(HandlerInterceptor interceptor) {
        this.interceptor = interceptor;
    }

    @Override
    public boolean preHandle(String request, String response, Object handler) {
        return interceptor.preHandle(request, response, handler);
    }

}
