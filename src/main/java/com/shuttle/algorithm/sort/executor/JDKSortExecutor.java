package com.shuttle.algorithm.sort.executor;

import java.util.Arrays;

/**
 * @author: Shuttle
 * @description: JDK Arrays 工具类的内置排序
 */
public class JDKSortExecutor implements SortExecutor {

    /**
     * @param nums 待排序的数组
     */
    @Override
    public void sort(int[] nums) {
        if (requiresNoSorting(nums)) {
            return;
        }
        Arrays.sort(nums);
    }

}
