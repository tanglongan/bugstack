package com.tanglongan.dp;

import com.tanglongan.dp07_bridge.better.channel.IPay;
import com.tanglongan.dp07_bridge.better.channel.WxPay;
import com.tanglongan.dp07_bridge.better.channel.ZfbPay;
import com.tanglongan.dp07_bridge.better.mode.PayFaceMode;
import com.tanglongan.dp07_bridge.better.mode.PayFingerPrintMode;
import com.tanglongan.dp07_bridge.worse.WorsePayService;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * 桥接模式
 * 主要作用：通过将抽象部分和实现部分分离，将多种可匹配的使用进行组合。
 * 核心实现：在A类中含有B类接口，通过构造函数传递B类的实现，这个B类就是设计的桥。避免了每种组合都去实现一套代码，更加灵活。
 */
public class Dp_07_test {


    @Test
    public void test_worse() {
        WorsePayService pay = new WorsePayService();

        System.out.println("\r\n模拟测试场景；微信支付、人脸方式。");
        pay.doPay("weixin_1092033111", "100000109893", new BigDecimal(100), 1, 2);

        System.out.println("\r\n模拟测试场景；支付宝支付、指纹方式。");
        pay.doPay("jlu19dlxo111", "100000109894", new BigDecimal(100), 2, 3);

    }


    /**
     * 将支付渠道和支付模式分离出来，通过抽象类依赖实现类的方式进行桥接
     */
    @Test
    public void test_better() {
        System.out.println("\r\n模拟测试场景；微信支付、人脸方式。");
        IPay wxPay = new WxPay(new PayFaceMode());
        wxPay.transfer("wexin_1221324", "100000109893", new BigDecimal(100));

        System.out.println("\r\n模拟测试场景；支付宝支付、指纹方式。");
        IPay zfbPay = new ZfbPay(new PayFingerPrintMode());
        zfbPay.transfer("jlu19dlxo111", "100000109894", new BigDecimal(100));

    }
}
