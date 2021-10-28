package com.tanglongan.dp08_combination.better.service.logic.impl;

import com.tanglongan.dp08_combination.better.service.logic.BasicFilter;

import java.util.Map;

/**
 * 判断性别的过滤器
 */
public class UserGenderFilter extends BasicFilter {

    @Override
    public String matterValue(Long treeId, String userId, Map<String, String> decisionMatter) {
        return decisionMatter.get("gender");
    }

}
