package com.tanglongan.dp;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.tanglongan.dp03_prototype.better.QuestionBankBetterService;
import com.tanglongan.dp03_prototype.better.util.Topic;
import com.tanglongan.dp03_prototype.better.util.TopicRandomUtil;
import com.tanglongan.dp03_prototype.worse.QuestionBankService;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 运行模式主要解决的问题是创建大量的重复对象
 * 在原型模式中，需要的重要技术手段是复制，而在需要复制的类中需要实现Cloneable接口的clone方法
 */
public class Dp_03_test {

    @Test
    public void test_QuestionService() {
        QuestionBankService service = new QuestionBankService();
        System.out.println(service.createPaper("花花", "1000001921032"));
        System.out.println(service.createPaper("豆豆", "1000001921051"));
        System.out.println(service.createPaper("大宝", "1000001921987"));
    }

    @Test
    public void test_util() {
        ImmutableMap<String, String> option = ImmutableMap.of("A", "中国", "B", "美国", "C", "俄罗斯", "D", "德国");

        Topic random = TopicRandomUtil.random(option, "C");
        System.out.println(JSON.toJSONString(random));

        ArrayList<String> list = Lists.newArrayList("C", "E", "G", "B", "A");
        System.out.println(JSON.toJSONString(list));
        Collections.shuffle(list);
        System.out.println(JSON.toJSONString(list));
    }


    @Test
    public void test_better() throws CloneNotSupportedException {
        QuestionBankBetterService questionBankBetterService = new QuestionBankBetterService();
        System.out.println(questionBankBetterService.createPaper("花花", "1000001921032"));
        System.out.println(questionBankBetterService.createPaper("豆豆", "1000001921051"));
        System.out.println(questionBankBetterService.createPaper("大宝", "1000001921987"));
    }


}
