package com.tanglongan.dp14_command.better.cook.impl;

import com.tanglongan.dp14_command.better.cook.ICook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JiangSuCook implements ICook {

    private static final Logger logger = LoggerFactory.getLogger(JiangSuCook.class);

    @Override
    public void doCooking() {
        logger.info("江苏厨师，烹饪苏菜，宫廷第二大菜系，古今国宴上最有影响力的菜系之一");
    }

}
