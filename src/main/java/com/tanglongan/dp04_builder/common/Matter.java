package com.tanglongan.dp04_builder.common;

import java.math.BigDecimal;

/**
 * 装修材料接口
 * 保证所有不同规格和种类的装修材料都可以按照统一标准被获取
 */
public interface Matter {

    String scene();     //场景：地板、地砖、涂料、吊顶

    String brand();     //品牌

    String model();     //型号

    BigDecimal price(); //价格

    String desc();      //描述

}
