package com.shuttle.algorithm.sort.executor;

import com.shuttle.algorithm.sort.helper.DataHelper;

/**
 * @author: Shuttle
 * @description: 堆排序
 */
public class HeapSortExecutor implements SortExecutor {

    /**
     * 思路：利用大顶堆性质，每一轮将大顶堆的第一个元素放到未排序数组尾部
     * 时间复杂度：O(n * log n) n 为数组的长度
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
        // 从最后一颗子树开始往前建大顶堆
        for (int i = numsLen / 2 - 1; i >= 0; i--) {
            heapSort(nums, numsLen, i);
        }
        // 排序
        for (int i = numsLen - 1; i > 0; i--) {
            DataHelper.swapTwoElementInArray(nums, i, 0);
            heapSort(nums, i, 0);
        }
    }

    private void heapSort(int[] nums, int numsLen, int index) {
        // 记录最大值的索引
        int maxNumIndex = index;
        int leftIndex = index * 2 + 1;
        int rightIndex = index * 2 + 2;
        // 维护大顶堆
        if (leftIndex < numsLen && nums[maxNumIndex] < nums[leftIndex]) {
            maxNumIndex = leftIndex;
        }
        if (rightIndex < numsLen && nums[maxNumIndex] < nums[rightIndex]) {
            maxNumIndex = rightIndex;
        }
        if (maxNumIndex != index) {
            DataHelper.swapTwoElementInArray(nums, index, maxNumIndex);
            heapSort(nums, numsLen, maxNumIndex);
        }
    }

}
