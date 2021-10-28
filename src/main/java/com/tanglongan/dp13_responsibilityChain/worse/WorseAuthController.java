package com.tanglongan.dp13_responsibilityChain.worse;


import com.tanglongan.dp13_responsibilityChain.common.AuthInfo;
import com.tanglongan.dp13_responsibilityChain.common.AuthService;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WorseAuthController {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 审批流写死了
     */
    public AuthInfo doAuth(String uId, String orderId, Date authDate) throws Exception {
        // 三级审批
        Date date = AuthService.queryAuthInfo("1000013", orderId);
        if (null == date) return new AuthInfo("0001", "单号：", orderId, " 状态：待三级审批负责人 ", "王工");

        // 二级审批
        if (authDate.after(sdf.parse("2020-06-01 00:00:00")) && authDate.before(sdf.parse("2020-06-25 23:59:59"))) {
            date = AuthService.queryAuthInfo("1000012", orderId);
            if (null == date) return new AuthInfo("0001", "单号：", orderId, " 状态：待二级审批负责人 ", "张经理");
        }

        // 一级审批
        if (authDate.after(sdf.parse("2020-06-11 00:00:00")) && authDate.before(sdf.parse("2020-06-20 23:59:59"))) {
            date = AuthService.queryAuthInfo("1000011", orderId);
            if (null == date) return new AuthInfo("0001", "单号：", orderId, " 状态：待一级审批负责人 ", "段总");
        }
        return new AuthInfo("0001", "单号：", orderId, " 状态：审批完成");

    }
}
