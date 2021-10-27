package com.tanglongan.dp03_prototype.better.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Topic {

    private Map<String, String> option; //选择题的选项
    private String key;                 //答案

}
