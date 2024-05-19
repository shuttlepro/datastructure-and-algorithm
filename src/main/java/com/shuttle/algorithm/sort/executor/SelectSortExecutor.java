package com.shuttle.algorithm.sort.executor;

import com.shuttle.algorithm.sort.helper.DataHelper;

/**
 * @author: Shuttle
 * @description: 选择排序
 */
public class SelectSortExecutor implements SortExecutor {

    /**
     * 思路：将数组分为前边已排序和后边未排序的两部分，在未排序序列中找到最小元素，存放到排序序列的末尾。
     * 时间复杂度：O(n²)，最坏情况为 n/2 次循环。
     * 空间复杂度：O(1)
     *
     * @param nums 待排序的数组
     */
    @Override
    public void sort(int[] nums) {
        if (requiresNoSorting(nums)) {
            return;
        }
        int numsLen = nums.length;
        /**
         * 原始版本
         * for (int i = 0; i < numsLen - 1; i++) {
         *     int minNumIndex = i;
         *
         *     for (int j = i + 1; j < numsLen; j++) {
         *         if (nums[j] >= nums[minNumIndex]) {
         *             continue;
         *         }
         *         minNumIndex = j;
         *     }
         *     DataHelper.swapTwoElementInArray(nums, i, minNumIndex);
         * }
         */
        // 优化点：每一轮同时找出最小值和最大值，分别放在队首和队尾，理论上循环次数可减半。
        int leftIndex = 0;
        int rightIndex = numsLen - 1;

        while (leftIndex < rightIndex) {
            int minNumIndex = leftIndex;
            int maxNumIndex = rightIndex;

            for (int i = leftIndex; i <= rightIndex; i++) {
                if (nums[i] < nums[minNumIndex]) {
                    minNumIndex = i;
                }
                if (nums[i] > nums[maxNumIndex]) {
                    maxNumIndex = i;
                }
            }
            DataHelper.swapTwoElementInArray(nums, maxNumIndex, rightIndex);
            // 需要考虑 minNumIndex == maxNumIndex 的情况
            if (minNumIndex == rightIndex) {
                minNumIndex = maxNumIndex;
            }
            DataHelper.swapTwoElementInArray(nums, minNumIndex, leftIndex);
            leftIndex++;
            rightIndex--;
        }
    }

}
