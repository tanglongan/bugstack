package com.tanglongan.dp02_abstractFactory.worse;

import com.tanglongan.dp02_abstractFactory.common.EGM;
import com.tanglongan.dp02_abstractFactory.common.IIR;
import com.tanglongan.dp02_abstractFactory.common.RedisUtils;

import java.util.concurrent.TimeUnit;

/**
 * 如果不从全局的升级改造考虑，仅仅是升级自己的系统，那么最快的方式就是id...else，把Redis集群的使用添加进去。再通过在接口中添加一个使用的Redis集群类型，判断当下调用的Redis时应该使用哪个环境。
 * 可以说这样的改造非常不好，这样的方式需要整个研发组一起硬编码，不易于维护，也增加了测试难度和未知风险。
 * <p>
 * 如果类型是1，则使用EGM集群；如果类型是2，则使用IIR集群。这在各方法中都有所体现。
 */
public class CacheClusterService implements ICacheService {

    private final RedisUtils redisUtils = new RedisUtils();
    private final EGM egm = new EGM();
    private final IIR iir = new IIR();

    public String get(String key, int redisType) {
        if (1 == redisType) {
            return egm.gain(key);
        }
        if (2 == redisType) {
            return iir.get(key);
        }
        return redisUtils.get(key);
    }

    public void set(String key, String value, int redisType) {
        if (1 == redisType) {
            egm.set(key, value);
            return;
        }
        if (2 == redisType) {
            iir.set(key, value);
            return;
        }
        redisUtils.set(key, value);
    }

    public void set(String key, String value, long timeout, TimeUnit timeUnit, int redisType) {
        if (1 == redisType) {
            egm.setEx(key, value, timeout, timeUnit);
            return;
        }
        if (2 == redisType) {
            iir.setExpire(key, value, timeout, timeUnit);
            return;
        }
        redisUtils.set(key, value, timeout, timeUnit);
    }

    public void del(String key, int redisType) {
        if (1 == redisType) {
            egm.delete(key);
            return;
        }
        if (2 == redisType) {
            iir.del(key);
            return;
        }
        redisUtils.del(key);
    }

}
