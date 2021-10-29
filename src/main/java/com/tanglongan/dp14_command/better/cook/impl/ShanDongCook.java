package com.tanglongan.dp14_command.better.cook.impl;

import com.tanglongan.dp14_command.better.cook.ICook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShanDongCook implements ICook {

    private static final Logger logger = LoggerFactory.getLogger(ShanDongCook.class);

    @Override
    public void doCooking() {
        logger.info("山东厨师，烹饪鲁菜，宫廷最大的菜系，孔府风味为龙头");
    }

}
