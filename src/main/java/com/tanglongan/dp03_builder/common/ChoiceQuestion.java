package com.tanglongan.dp03_builder.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChoiceQuestion {

    private String name;                //题目名称
    private Map<String, String> option; //题目选项
    private String key;                 //题目答案

}
