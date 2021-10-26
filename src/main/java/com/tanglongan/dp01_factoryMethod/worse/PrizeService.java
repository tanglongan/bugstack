package com.tanglongan.dp01_factoryMethod.worse;


import com.alibaba.fastjson.JSON;
import com.tanglongan.dp01_factoryMethod.common.card.IQiYiCardService;
import com.tanglongan.dp01_factoryMethod.common.coupon.CouponResult;
import com.tanglongan.dp01_factoryMethod.common.coupon.CouponService;
import com.tanglongan.dp01_factoryMethod.common.goods.DeliverReq;
import com.tanglongan.dp01_factoryMethod.common.goods.GoodsService;

/**
 * 奖品发放服务类
 */
public class PrizeService {

    /**
     * 发放奖品
     * 用非常直接的方式实现了业务需求。如果仅仅从业务产品需求角度来说，需求实现了。但是这里都用if..else填充到了一个类里，随着奖品越多就越难以维护。
     */
    public AwardRes awardToUser(AwardReq req) {
        String reqJson = JSON.toJSONString(req);
        AwardRes awardRes = null;
        try {
            System.out.println("奖品发放开始：" + req.getUId() + "，req:" + reqJson);
            //按照不同类型方法商品：1-优惠券、2-实物商品、3-爱奇艺会员卡
            if (req.getAwardType() == 1) {
                CouponService couponService = new CouponService();
                CouponResult couponResult = couponService.sendCoupon(req.getUId(), req.getAwardNumber(), req.getBizId());
                if ("0000".equals(couponResult.getCode())) {
                    awardRes = new AwardRes("0000", "发放成功");
                } else {
                    awardRes = new AwardRes("0001", couponResult.getInfo());
                }
            } else if (req.getAwardType() == 2) {
                GoodsService goodsService = new GoodsService();
                DeliverReq deliverReq = new DeliverReq();
                deliverReq.setUserName(queryUserName(req.getUId()));
                deliverReq.setUserPhone(queryUserPhoneNumber(req.getUId()));
                deliverReq.setSku(req.getAwardNumber());
                deliverReq.setOrderId(req.getBizId());
                deliverReq.setConsigneeUserName(req.getExtMap().get("consigneeUserName"));
                deliverReq.setConsigneeUserPhone(req.getExtMap().get("consigneeUserPhone"));
                deliverReq.setConsigneeUserAddress(req.getExtMap().get("consigneeUserAddress"));
                Boolean isSuccess = goodsService.deliverGoods(deliverReq);
                if (isSuccess) {
                    awardRes = new AwardRes("0000", "发放成功");
                } else {
                    awardRes = new AwardRes("0001", "发放失败");
                }
            } else if (req.getAwardType() == 3) {
                String bindMobileNumber = queryUserPhoneNumber(req.getUId());
                IQiYiCardService iQiYiCardService = new IQiYiCardService();
                iQiYiCardService.grantToken(bindMobileNumber, req.getAwardNumber());
                awardRes = new AwardRes("0000", "发放成功");
            }
            System.out.println("奖品发放完成：" + req.getUId());
        } catch (Exception e) {
            e.printStackTrace();
            awardRes = new AwardRes("0001", e.getMessage());
        }
        return awardRes;
    }


    private String queryUserName(String uId) {
        return "花花";
    }

    private String queryUserPhoneNumber(String uId) {
        return "15200101232";
    }


    public void print(AwardReq req, AwardRes res) {
        System.out.println("请求参数：{}" + JSON.toJSON(req));
        System.out.println("测试结果：{}" + JSON.toJSON(res));
    }

}
