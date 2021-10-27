package com.tanglongan.dp;

import com.tanglongan.dp04_builder.better.Builder;
import com.tanglongan.dp04_builder.worse.DecorationPackageService;
import org.junit.Test;

import java.math.BigDecimal;

public class Dp_04_test {

    @Test
    public void test_DecorationPackageService() {
        DecorationPackageService decoration = new DecorationPackageService();
        System.out.println(decoration.getMatterList(new BigDecimal("96.52"), 1));// 豪华欧式
        System.out.println(decoration.getMatterList(new BigDecimal("88.25"), 2));// 轻奢田园
        System.out.println(decoration.getMatterList(new BigDecimal("82.43"), 3));// 现代简约
    }


    @Test
    public void test_Builder() {
        Builder builder = new Builder();
        System.out.println(builder.levelOne(132.52D).getDetail());  // 豪华欧式
        System.out.println(builder.levelTwo(98.25D).getDetail());   // 轻奢田园
        System.out.println(builder.levelThree(85.43D).getDetail()); // 现代简约
    }

}
