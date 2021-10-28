package com.tanglongan.dp08_combination.better.service.engine;

import com.tanglongan.dp08_combination.better.service.logic.ILogicFilter;
import com.tanglongan.dp08_combination.better.service.logic.impl.UserAgeFilter;
import com.tanglongan.dp08_combination.better.service.logic.impl.UserGenderFilter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class EngineConfig {

    static Map<String, ILogicFilter> logicFilterMap;

    static {
        logicFilterMap = new ConcurrentHashMap<>();
        logicFilterMap.put("userAge", new UserAgeFilter());
        logicFilterMap.put("userGender", new UserGenderFilter());
    }

    public static Map<String, ILogicFilter> getLogicFilterMap() {
        return logicFilterMap;
    }

    public static void setLogicFilterMap(Map<String, ILogicFilter> logicFilterMap) {
        EngineConfig.logicFilterMap = logicFilterMap;
    }
}
