package com.tanglongan.dp08_combination.better.service.logic;

import com.tanglongan.dp08_combination.better.model.vo.TreeNodeLink;

import java.util.List;
import java.util.Map;

/**
 * 决策过滤器接口
 */
public interface ILogicFilter {

    /**
     * 逻辑决策器
     *
     * @param matterValue      决策值
     * @param treeNodeLinkList 决策节点
     */
    Long filter(String matterValue, List<TreeNodeLink> treeNodeLinkList);

    /**
     * 获取决策值
     */
    String matterValue(Long treeId, String userId, Map<String, String> decisionMatter);

}
