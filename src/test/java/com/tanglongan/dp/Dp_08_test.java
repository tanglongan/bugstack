package com.tanglongan.dp;

import com.tanglongan.dp08_combination.worse.EngineController;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Dp_08_test {

    private Logger logger = LoggerFactory.getLogger(Dp_08_test.class);

    @Test
    public void test_EngineController() {
        EngineController engineController = new EngineController();
        String process = engineController.process("Oli09pLkdjh", "man", 29);
        logger.info("测试结果：{}", process);
    }

}
