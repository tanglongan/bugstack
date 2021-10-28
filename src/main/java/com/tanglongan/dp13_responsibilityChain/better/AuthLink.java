package com.tanglongan.dp13_responsibilityChain.better;


import com.tanglongan.dp13_responsibilityChain.common.AuthInfo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 链路抽象类定义
 */
public abstract class AuthLink {

    protected SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 时间格式化
    protected String levelUserId;                                               // 级别人员ID
    protected String levelUserName;                                             // 级别人员姓名
    private AuthLink next;                                                      // 责任链


    public AuthLink(String levelUserId, String levelUserName) {
        this.levelUserId = levelUserId;
        this.levelUserName = levelUserName;
    }

    public AuthLink next() {
        return next;
    }

    public AuthLink appendNext(AuthLink next) {
        this.next = next;
        return this;
    }

    public abstract AuthInfo doAuth(String uId, String orderId, Date authDate);

}
