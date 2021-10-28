package com.tanglongan.dp;

import com.alibaba.fastjson.JSON;
import com.tanglongan.dp13_responsibilityChain.better.AuthLink;
import com.tanglongan.dp13_responsibilityChain.better.Level1AuthLink;
import com.tanglongan.dp13_responsibilityChain.better.Level2AuthLink;
import com.tanglongan.dp13_responsibilityChain.better.Level3AuthLink;
import com.tanglongan.dp13_responsibilityChain.common.AuthService;
import com.tanglongan.dp13_responsibilityChain.worse.WorseAuthController;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class Dp_13_test {

    private static final Logger logger = LoggerFactory.getLogger(Dp_13_test.class);

    /**
     * 审批流程写死了
     */
    @Test
    public void test_AuthController() throws Exception {
        WorseAuthController authController = new WorseAuthController();

        // 模拟三级负责人审批
        logger.info("测试结果：{}", JSON.toJSONString(authController.doAuth("小傅哥", "1000998004813441", new Date())));
        logger.info("测试结果：{}", "模拟三级负责人审批，王工");
        AuthService.auth("1000013", "1000998004813441");

        // 模拟二级负责人审批
        logger.info("测试结果：{}", JSON.toJSONString(authController.doAuth("小傅哥", "1000998004813441", new Date())));
        logger.info("测试结果：{}", "模拟二级负责人审批，张经理");
        AuthService.auth("1000012", "1000998004813441");

        // 模拟一级负责人审批
        logger.info("测试结果：{}", JSON.toJSONString(authController.doAuth("小傅哥", "1000998004813441", new Date())));
        logger.info("测试结果：{}", "模拟一级负责人审批，段总");
        AuthService.auth("1000011", "1000998004813441");

        logger.info("测试结果：{}", "审批完成");
    }


    @Test
    public void test_AuthLink() throws Exception {
        AuthLink authLink = new Level3AuthLink("1000013", "王工").appendNext(new Level2AuthLink("1000012", "张经理").appendNext(new Level1AuthLink("1000011", "段总")));
        logger.info("测试结果：{}", JSON.toJSONString(authLink.doAuth("小傅哥", "1000998004813441", new Date())));

        // 模拟三级负责人审批
        AuthService.auth("1000013", "1000998004813441");
        logger.info("测试结果：{}", "模拟三级负责人审批，王工");
        logger.info("测试结果：{}", JSON.toJSONString(authLink.doAuth("小傅哥", "1000998004813441", new Date())));

        // 模拟二级负责人审批
        AuthService.auth("1000012", "1000998004813441");
        logger.info("测试结果：{}", "模拟二级负责人审批，张经理");
        logger.info("测试结果：{}", JSON.toJSONString(authLink.doAuth("小傅哥", "1000998004813441", new Date())));

        // 模拟一级负责人审批
        AuthService.auth("1000011", "1000998004813441");
        logger.info("测试结果：{}", "模拟一级负责人审批，段总");
        logger.info("测试结果：{}", JSON.toJSONString(authLink.doAuth("小傅哥", "1000998004813441", new Date())));

    }


}
