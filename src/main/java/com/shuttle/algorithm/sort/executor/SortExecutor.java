package com.shuttle.algorithm.sort.executor;

/**
 * @author: Shuttle
 * @description: 排序执行器接口
 */
public interface SortExecutor {

    /**
     * 排序数组
     *
     * @param nums 待排序的数组
     */
    void sort(int[] nums);

    default boolean requiresNoSorting(int[] nums) {
        return nums == null || nums.length < 2;
    }

}
