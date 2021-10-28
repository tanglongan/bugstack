package com.tanglongan.dp06_adapter.better;

import java.util.Date;

/**
 * 通用的MQ消息体，后续所有的MQ消息都需要提供这些信息
 * 为了满足产品功能的需求，提取此项中必须的字段信息
 */
public class RebateInfo {

    private String userId;
    private String bizId;
    private Date bizTime;
    private String desc;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public Date getBizTime() {
        return bizTime;
    }

    public void setBizTime(String bizTime) {
        this.bizTime = new Date(Long.parseLong("1591077840669"));
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
