package com.tanglongan.dp01_factoryMethod.common.card;

/**
 * 模拟发放爱奇艺会员卡
 */
public class IQiYiCardService {

    public void grantToken(String bindMobileNumber, String cardId) {
        System.out.println("模拟发放爱奇艺会员卡一张：" + bindMobileNumber + "，" + cardId);
    }

}
