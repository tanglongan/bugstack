package com.tanglongan.dp08_combination.better.service.logic;

import com.tanglongan.dp08_combination.better.model.vo.TreeNodeLink;

import java.util.List;
import java.util.Map;

/**
 * 对决策过滤器的通用实现
 */
public abstract class BasicFilter implements ILogicFilter {

    @Override
    public Long filter(String matterValue, List<TreeNodeLink> treeNodeLinkList) {
        for (TreeNodeLink nodeLink : treeNodeLinkList) {
            if (decisionLogic(matterValue, nodeLink)) {
                return nodeLink.getNodeIdTo();
            }
        }
        return null;
    }

    @Override
    public abstract String matterValue(Long treeId, String userId, Map<String, String> decisionMatter);

    private boolean decisionLogic(String matterValue, TreeNodeLink nodeLink) {
        switch (nodeLink.getRuleLimitType()) {
            case 1:
                return matterValue.equals(nodeLink.getRuleLimitValue());
            case 2:
                return Double.parseDouble(matterValue) > Double.parseDouble(nodeLink.getRuleLimitValue());
            case 3:
                return Double.parseDouble(matterValue) < Double.parseDouble(nodeLink.getRuleLimitValue());
            case 4:
                return Double.parseDouble(matterValue) >= Double.parseDouble(nodeLink.getRuleLimitValue());
            case 5:
                return Double.parseDouble(matterValue) <= Double.parseDouble(nodeLink.getRuleLimitValue());
            default:
                return false;
        }
    }

}
