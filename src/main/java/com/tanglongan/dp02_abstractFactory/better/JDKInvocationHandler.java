package com.tanglongan.dp02_abstractFactory.better;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 相同适配器接口ICacheAdapater的不同Redis集群服务实现，其具体调用会在这里实现。
 * 在反射调用里，通过入参获取需要调用的方法名称和参数，就可以调用对应的Redis集群中的方法
 */
public class JDKInvocationHandler implements InvocationHandler {

    private ICacheAdapter cacheAdapter;

    public JDKInvocationHandler(ICacheAdapter cacheAdapter) {
        this.cacheAdapter = cacheAdapter;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return ICacheAdapter.class.getMethod(method.getName(), ClassLoaderUtils.getClazzByArgs(args)).invoke(cacheAdapter, args);
    }

}
