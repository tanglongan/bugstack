package com.tanglongan.dp;

import com.tanglongan.dp09_decorator.better.LoginSsoDecorator;
import com.tanglongan.dp09_decorator.common.HandlerInterceptor;
import com.tanglongan.dp09_decorator.common.SsoInterceptor;
import com.tanglongan.dp09_decorator.worse.WorseLoginSsoDecorator;
import org.junit.Test;

public class Dp_09_test {

    /**
     * WorseLoginSsoDecorator继承了原来的类，进行了方法的重写
     */
    @Test
    public void test_WorseLoginSsoDecorator() {
        HandlerInterceptor decorator = new WorseLoginSsoDecorator();
        String request = "lsuccesshuahua";
        boolean success = decorator.preHandle(request, "debufhuerf", "t");
        System.out.println("登录校验：" + request + (success ? "放行" : "拦截"));
    }


    /**
     * 装饰器模式，满足单一职责原则，可以在自己的装饰器类中对功能方法逻辑进行增加扩展，而不影响原主类，同时可以按需在运行时添加和删除这部分逻辑
     */
    @Test
    public void test_LoginSsoDecorator() {
        HandlerInterceptor decorator = new LoginSsoDecorator(new SsoInterceptor());
        String request = "lsuccesshuahua";
        boolean success = decorator.preHandle(request, "debufhuerf", "t");
        System.out.println("登录校验：" + request + (success ? "放行" : "拦截"));
    }

}
