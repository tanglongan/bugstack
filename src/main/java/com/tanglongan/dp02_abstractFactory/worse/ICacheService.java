package com.tanglongan.dp02_abstractFactory.worse;

import java.util.concurrent.TimeUnit;

public interface ICacheService {

    String get(final String key, int redisType);

    void set(String key, String value, int redisType);

    void set(String key, String value, long timeout, TimeUnit timeUnit, int redisType);

    void del(String key, int redisType);

}
