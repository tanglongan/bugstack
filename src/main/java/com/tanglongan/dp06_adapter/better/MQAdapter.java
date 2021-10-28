package com.tanglongan.dp06_adapter.better;

import com.alibaba.fastjson.JSON;

import java.util.Map;

/**
 * MQ消息统一适配类
 */
public class MQAdapter {


    public static RebateInfo filter(String strJson, Map<String, String> link) throws Exception {
        return filter(JSON.parseObject(strJson, Map.class), link);
    }

    /**
     * 将不容类型的MQ中的各种属性映射成需要的属性
     *
     * @param obj  消息实体
     * @param link 字段映射关系
     */
    public static RebateInfo filter(Map obj, Map<String, String> link) throws Exception {
        RebateInfo rebateInfo = new RebateInfo();
        for (String key : link.keySet()) {
            Object val = obj.get(link.get(key));
            // 用于把不同类型的MQ中的各种属性映射成需要的属性并返回
            RebateInfo.class.getMethod("set" + key.substring(0, 1).toUpperCase() + key.substring(1), String.class).invoke(rebateInfo, val.toString());
        }
        return rebateInfo;
    }

}
