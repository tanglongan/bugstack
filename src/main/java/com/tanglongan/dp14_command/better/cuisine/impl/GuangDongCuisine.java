package com.tanglongan.dp14_command.better.cuisine.impl;

import com.tanglongan.dp14_command.better.cook.ICook;
import com.tanglongan.dp14_command.better.cuisine.ICuisine;

public class GuangDongCuisine implements ICuisine {

    private final ICook cook;

    public GuangDongCuisine(ICook cook) {
        this.cook = cook;
    }

    @Override
    public void cook() {
        cook.doCooking();
    }

}
