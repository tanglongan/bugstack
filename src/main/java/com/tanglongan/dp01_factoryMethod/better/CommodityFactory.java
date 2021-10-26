package com.tanglongan.dp01_factoryMethod.better;

import com.tanglongan.dp01_factoryMethod.better.service.ICommodity;
import com.tanglongan.dp01_factoryMethod.better.service.impl.CardCommodityService;
import com.tanglongan.dp01_factoryMethod.better.service.impl.CouponCommodityService;
import com.tanglongan.dp01_factoryMethod.better.service.impl.GoodsCommodityService;

/**
 * 奖品工厂类
 * 首先定义了一个公共的商品接口，在工厂模式中，根据不同的参数需要，提供不同的实例类型，提供了2个重载的方法，这样使用更方便
 * 工厂方法模式：使得代码的接口更加清晰，并且以后加入其他商品时提供更高的扩展性【既提高了代码的结构性，也让工程易于维护和扩展。】
 * 总结：
 *      优点：
 *          1、工厂模式比较简单，借助它可以提升代码结构型和扩展性
 *          2、避免创建者与具体的产品逻辑耦合在一起。满足单一职责，每一个业务逻辑实现都在自己所属的类中完成；满足开闭原则，无需更改调用方就可以在程序中引入新的产品类型
 *      缺点：
 *          当有非常多的产品类型时，实现的子类会急速扩张，这时还需要使用其他的模式进行优化
 */
public class CommodityFactory {

    public ICommodity getCommodityService(Integer commodityType) {
        if (null == commodityType) return null;
        if (1 == commodityType) return new CouponCommodityService();
        if (2 == commodityType) return new GoodsCommodityService();
        if (3 == commodityType) return new CardCommodityService();
        throw new RuntimeException("不存在的商品服务类型");
    }

    public ICommodity getCommodityService(Class<? extends ICommodity> clazz) throws InstantiationException, IllegalAccessException {
        if (clazz == null) {
            return null;
        }
        return clazz.newInstance();
    }

}
