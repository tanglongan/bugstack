package com.tanglongan.dp14_command.better.cook.impl;

import com.tanglongan.dp14_command.better.cook.ICook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GuangDongCook implements ICook {

    private static final Logger logger = LoggerFactory.getLogger(GuangDongCook.class);

    @Override
    public void doCooking() {
        logger.info("广东厨师，烹饪粤菜，国内民间第二大菜系，国内外最有影响力的菜系之一");
    }

}
