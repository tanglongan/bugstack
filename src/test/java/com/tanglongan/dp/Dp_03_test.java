package com.tanglongan.dp;

import com.tanglongan.dp03_builder.worse.QuestionBankService;
import org.junit.Test;

public class Dp_03_test {

    @Test
    public void test_QuestionService() {
        QuestionBankService service = new QuestionBankService();
        System.out.println(service.createPaper("花花", "1000001921032"));
        System.out.println(service.createPaper("豆豆", "1000001921051"));
        System.out.println(service.createPaper("大宝", "1000001921987"));
    }

}
