package com.tanglongan.dp08_combination.better.service.engine;

import com.tanglongan.dp08_combination.better.model.vo.EngineResult;
import com.tanglongan.dp08_combination.better.model.vo.TreeRich;

import java.util.Map;

/**
 * 决策引擎接口
 */
public interface IEngine {

    EngineResult process(final Long treeId, final String userId, TreeRich treeRich, final Map<String, String> decisionMatter);

}
