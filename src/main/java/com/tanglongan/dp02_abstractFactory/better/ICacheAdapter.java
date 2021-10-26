package com.tanglongan.dp02_abstractFactory.better;

import java.util.concurrent.TimeUnit;

/**
 * 适配器接口：包装两个集群服务，因为这两个集群服务在一些接口名称和入参方面可能各不相同，所以需要适配；另外，在引入适配器之后，也可以非常方便地扩展
 */
public interface ICacheAdapter {

    String get(String key);

    void set(String key, String value);

    void set(String key, String value, long timeout, TimeUnit timeUnit);

    void del(String key);
}
