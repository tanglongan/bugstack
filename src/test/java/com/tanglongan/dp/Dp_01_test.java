package com.tanglongan.dp;

import com.google.common.collect.ImmutableMap;
import com.tanglongan.dp01_factoryMethod.better.CommodityFactory;
import com.tanglongan.dp01_factoryMethod.better.service.ICommodity;
import com.tanglongan.dp01_factoryMethod.better.service.impl.CardCommodityService;
import com.tanglongan.dp01_factoryMethod.worse.AwardReq;
import com.tanglongan.dp01_factoryMethod.worse.AwardRes;
import com.tanglongan.dp01_factoryMethod.worse.PrizeService;
import org.junit.Test;

public class Dp_01_test {

    @Test
    public void test_awardToUser() {
        PrizeService prizeService = new PrizeService();

        System.out.println("\n\n=================模拟发放优惠券测试=================");
        AwardReq couponReq = new AwardReq("10001", 1, "EGM1023938910232121323432", "EGM1023938910232121323432", null);
        AwardRes couponRes = prizeService.awardToUser(couponReq);
        prizeService.print(couponReq, couponRes);


        System.out.println("\n\n=================模拟方法实物商品=================");
        AwardReq goodsReq = new AwardReq("10001", 2, "9820198721311", "1023000020112221113", ImmutableMap.of("consigneeUserName", "谢飞机", "consigneeUserPhone", "15200292123", "consigneeUserAddress", "吉林省.长春市.双阳区.XX街道.檀溪苑小区.#18-2109"));
        AwardRes goodsRes = prizeService.awardToUser(goodsReq);
        prizeService.print(goodsReq, goodsRes);


        System.out.println("\n\n=================模拟发放爱奇艺会员卡=================");
        AwardReq cardReq = new AwardReq("10001", 3, "AQY1xjkUodl8LO975GdfrYUio", null, null);
        AwardRes cardRes = prizeService.awardToUser(cardReq);
        prizeService.print(cardReq, cardRes);

    }


    @Test
    public void testCommodity() throws Exception {
        CommodityFactory factory = new CommodityFactory();

        // 1. 优惠券
        System.out.println("\n\n=================模拟发放优惠券测试=================");
        ICommodity couponService = factory.getCommodityService(1);
        couponService.sendCommodity("10001", "EGM1023938910232121323432", "791098764902132", null);

        // 2. 实物商品
        System.out.println("\n\n=================模拟方法实物商品=================");
        ICommodity goodsService = factory.getCommodityService(2);
        goodsService.sendCommodity("10001", "9820198721311", "1023000020112221113", ImmutableMap.of("consigneeUserName", "谢飞机", "consigneeUserPhone", "15200292123", "consigneeUserAddress", "吉林省.长春市.双阳区.XX街道.檀溪苑小区.#18-2109"));

        // 3. 爱奇艺会员卡
        System.out.println("\n\n=================模拟发放爱奇艺会员卡=================");
        ICommodity cardService = factory.getCommodityService(CardCommodityService.class);
        cardService.sendCommodity("10001", "AQY1xjkUodl8LO975GdfrYUio", null, null);
    }


}
