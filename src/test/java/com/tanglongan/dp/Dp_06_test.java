package com.tanglongan.dp;

import com.alibaba.fastjson.JSON;
import com.tanglongan.dp06_adapter.better.MQAdapter;
import com.tanglongan.dp06_adapter.better.RebateInfo;
import com.tanglongan.dp06_adapter.better.service.InsideOrderService;
import com.tanglongan.dp06_adapter.better.service.OrderAdapterService;
import com.tanglongan.dp06_adapter.better.service.POPOrderAdapterServiceImpl;
import com.tanglongan.dp06_adapter.common.CreateAccount;
import com.tanglongan.dp06_adapter.common.OrderMq;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Dp_06_test {

    /*
     * 字段的映射关系，在实际业务开发场景中，可以把这种映射关系交给配置文件或数据库后台进行统一管理，以减少编码
     */
    private static final Map<String, String> link01 = new HashMap<>();
    private static final Map<String, String> link02 = new HashMap<>();

    static {
        link01.put("userId", "number");
        link01.put("bizId", "number");
        link01.put("bizTime", "accountDate");
        link01.put("desc", "desc");

        link02.put("userId", "uid");
        link02.put("bizId", "orderId");
        link02.put("bizTime", "createOrderTime");
    }

    @Test
    public void test_MQAdapter() throws Exception {

        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = s.parse("2020-06-01 23:20:16");

        CreateAccount create_account = new CreateAccount("100001", "河北省.廊坊市.广阳区.大学里职业技术学院", parse, "在校开户");
        RebateInfo rebateInfo01 = MQAdapter.filter(create_account.toString(), link01);
        System.out.println("mq.create_account(适配前)" + create_account);
        System.out.println("mq.create_account(适配后)" + JSON.toJSONString(rebateInfo01));

        System.out.println("======================================================");

        OrderMq orderMq = new OrderMq("100001", "10928092093111123", "100000890193847111", parse);
        RebateInfo rebateInfo02 = MQAdapter.filter(orderMq.toString(), link02);
        System.out.println("mq.orderMq(适配前)" + orderMq);
        System.out.println("mq.orderMq(适配后)" + JSON.toJSONString(rebateInfo02));
    }


    @Test
    public void test_itfAdapter() {
        OrderAdapterService popOrderAdapterService = new POPOrderAdapterServiceImpl();
        System.out.println("判断首单，接口适配(POP)：" + popOrderAdapterService.isFirst("100001"));
        OrderAdapterService insideOrderService = new InsideOrderService();
        System.out.println("判断首单，接口适配(自营)：" + insideOrderService.isFirst("100001"));
    }

}
