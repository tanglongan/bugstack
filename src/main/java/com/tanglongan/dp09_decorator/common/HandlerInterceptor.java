package com.tanglongan.dp09_decorator.common;

public interface HandlerInterceptor {

    boolean preHandle(String request, String response, Object handler);

}
