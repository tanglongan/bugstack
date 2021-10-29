package com.tanglongan.dp;

import com.tanglongan.dp14_command.better.XiaoEr;
import com.tanglongan.dp14_command.better.cook.impl.GuangDongCook;
import com.tanglongan.dp14_command.better.cook.impl.JiangSuCook;
import com.tanglongan.dp14_command.better.cook.impl.ShanDongCook;
import com.tanglongan.dp14_command.better.cook.impl.SiChuanCook;
import com.tanglongan.dp14_command.better.cuisine.ICuisine;
import com.tanglongan.dp14_command.better.cuisine.impl.GuangDongCuisine;
import com.tanglongan.dp14_command.better.cuisine.impl.JiangSuCuisine;
import com.tanglongan.dp14_command.better.cuisine.impl.ShanDongCuisine;
import com.tanglongan.dp14_command.better.cuisine.impl.SiChuanCuisine;
import org.junit.Test;

public class Dp_14_test {

    @Test
    public void test_xiaoEr() {
        //菜系 + 厨师
        ICuisine guangDongCuisine = new GuangDongCuisine(new GuangDongCook());
        ICuisine jiangSuCuisine = new JiangSuCuisine(new JiangSuCook());
        ICuisine shanDongCuisine = new ShanDongCuisine(new ShanDongCook());
        ICuisine siChuanCuisine = new SiChuanCuisine(new SiChuanCook());

        XiaoEr xiaoer = new XiaoEr();
        xiaoer.order(guangDongCuisine);
        xiaoer.order(jiangSuCuisine);
        xiaoer.order(shanDongCuisine);
        xiaoer.order(siChuanCuisine);

        xiaoer.placeOrder();
    }


}
