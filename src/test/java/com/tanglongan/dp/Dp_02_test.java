package com.tanglongan.dp;

import com.tanglongan.dp02_abstractFactory.better.EGMCacheAdapter;
import com.tanglongan.dp02_abstractFactory.better.IIRCacheAdapter;
import com.tanglongan.dp02_abstractFactory.better.JDKProxyFactory;
import com.tanglongan.dp02_abstractFactory.common.ICacheService;
import com.tanglongan.dp02_abstractFactory.worse.CacheClusterService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Dp_02_test {

    private static final Logger logger = LoggerFactory.getLogger(Dp_02_test.class);

    @Test
    public void test_cacheServiceUpgrade() {
        com.tanglongan.dp02_abstractFactory.worse.ICacheService cacheService = new CacheClusterService();
        cacheService.set("user_name_01", "中国人名解放军", 1);

        String name01 = cacheService.get("user_name_01", 1);
        logger.info("缓存集群升级，测试结果：{}", name01);
    }


    @Test
    public void test_CacheService() throws Exception {
        ICacheService proxy_egm = JDKProxyFactory.getProxy(ICacheService.class, EGMCacheAdapter.class);
        proxy_egm.set("user_name_01", "中国");
        String value01 = proxy_egm.get("user_name_01");
        logger.info("缓存服务EGM测试，proxy_egm.get测试结果：{}", value01);


        ICacheService proxy_iir = JDKProxyFactory.getProxy(ICacheService.class, IIRCacheAdapter.class);
        proxy_iir.set("user_name_02", "俄罗斯");
        String value02 = proxy_iir.get("user_name_02");
        logger.info("缓存服务IIR测试，proxy_iir.get测试结果：{}", value02);

    }

}
