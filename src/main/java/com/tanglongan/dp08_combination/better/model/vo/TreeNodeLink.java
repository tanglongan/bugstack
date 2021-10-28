package com.tanglongan.dp08_combination.better.model.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TreeNodeLink {

    private long nodeIdFrom;        //节点From
    private long nodeIdTo;          //节点To
    private Integer ruleLimitType;  //限定类型 1:=;2:>;3:<;4:>=;5<=;6:enum[枚举范围]
    private String ruleLimitValue;  //限定值


}
