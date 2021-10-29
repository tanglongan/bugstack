package com.tanglongan.dp14_command.better.cook.impl;

import com.tanglongan.dp14_command.better.cook.ICook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SiChuanCook implements ICook {

    private static final Logger logger = LoggerFactory.getLogger(SiChuanCook.class);

    @Override
    public void doCooking() {
        logger.info("四川厨师，烹饪川菜，中国最有特色的菜系，也是民间最大的菜系之一");
    }

}
