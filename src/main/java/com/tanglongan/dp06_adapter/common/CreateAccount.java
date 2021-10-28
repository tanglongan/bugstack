package com.tanglongan.dp06_adapter.common;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * 订单
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateAccount {

    private String number;      // 开户编号
    private String address;     // 开户地
    private Date accountDate;   // 开户时间
    private String desc;        // 开户描述

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
