package com.tanglongan.dp02_abstractFactory.better;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 代理抽象工厂
 * <p>
 * 因为要把原单体Redis服务升级为两套Redis集群服务，在不破坏原有单体Redis服务和实现类的情况下，即com.tanglongan.dp02_abstractFactory.common.CacheService 通过一个代理类的方式实现一个集群服务处理类
 * 这样就可以非常方便的在Spring、SpringBoot等框架中通过注入的方式替换原有的com.tanglongan.dp02_abstractFactory.common.CacheService实现。
 * <p>
 * 这样中间件设计思路的实现方式具备了良好的热插拔性，并可以达到多组集群同时使用和平滑切换的目的
 */
public class JDKProxyFactory {

    /**
     * 获取代理工厂
     *
     * @param clazz        在穆尼的场景中，不同的系统使用的Redis服务类名可能有所不同，通过这样的方式实例化后的注入操作
     * @param cacheAdapter 这个参数用于决定实例化那套集群服务使用Redis功能
     */
    public static <T> T getProxy(Class clazz, Class<? extends ICacheAdapter> cacheAdapter) throws Exception {
        InvocationHandler handler = new JDKInvocationHandler(cacheAdapter.newInstance());
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        return (T) Proxy.newProxyInstance(classLoader, new Class[]{clazz}, handler);
    }

}
