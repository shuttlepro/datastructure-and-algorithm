package com.shuttle.algorithm.sort.executor;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: Shuttle
 * @description: 排序执行器管理类
 */
public class SortExecutorManager {

    private static final Map<String, SortExecutor> SORT_EXECUTOR_MANAGER;

    static {
        // 初始化并注册所有排序执行器，使用 LinkedHashMap 保证注册顺序
        SORT_EXECUTOR_MANAGER = new LinkedHashMap<>();
        registerSortExecutors();
    }

    private static void registerSortExecutors() {
        // 使用枚举类手动注册，Spring 工程可以使用依赖注入
        SortExecutorEnum[] executorEnums = SortExecutorEnum.values();

        for (SortExecutorEnum executorEnum : executorEnums) {
            SORT_EXECUTOR_MANAGER.put(executorEnum.getExecutorName(), executorEnum.getExecutor());
        }
    }

    public static Map<String, SortExecutor> getSortExecutorManager() {
        return SORT_EXECUTOR_MANAGER;
    }

}
