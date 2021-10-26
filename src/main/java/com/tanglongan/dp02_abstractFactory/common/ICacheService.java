package com.tanglongan.dp02_abstractFactory.common;

import java.util.concurrent.TimeUnit;

public interface ICacheService {

    String get(String key);

    void set(String key, String value);

    void set(String key, String value, long timeout, TimeUnit timeUnit);

    void del(String key);

}
