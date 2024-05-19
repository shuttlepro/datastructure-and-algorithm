package com.shuttle.algorithm.sort.executor;

/**
 * @author: Shuttle
 * @description: 归并排序
 */
public class MergeSortExecutor implements SortExecutor {

    /**
     * 思路：分而治之，拆分成最小排序单元后进行组合
     * 时间复杂度：O(n * log n) n 为数组的长度
     * 空间复杂度：O(n) tempNums 所占用的空间
     *
     * @param nums 待排序的数组
     */
    @Override
    public void sort(int[] nums) {
        if (requiresNoSorting(nums)) {
            return;
        }
        int numsLen = nums.length;
        int[] tempNums = new int[numsLen];

        mergeSort(nums, 0, numsLen - 1, tempNums);
    }

    /**
     * MergeSort
     *
     * @param nums          待排序的数组
     * @param leftBoundary  左边界
     * @param rightBoundary 右边界
     * @param tempNums      临时数组辅助排序
     */
    private void mergeSort(int[] nums, int leftBoundary, int rightBoundary, int[] tempNums) {
        if (leftBoundary == rightBoundary) {
            return;
        }
        int midIndex = leftBoundary + (rightBoundary - leftBoundary) / 2;
        mergeSort(nums, leftBoundary, midIndex, tempNums);
        mergeSort(nums, midIndex + 1, rightBoundary, tempNums);
        // 如果合并完 mid 小于右边则说明当次合并已经有序
        if (nums[midIndex] <= nums[midIndex + 1]) {
            return;
        }

        for (int i = leftBoundary; i <= rightBoundary; i++) {
            tempNums[i] = nums[i];
        }
        // 对 tempNums 进行分区 [leftBoundary, midIndex] [midIndex + 1, rightBoundary]
        int leftIndex = leftBoundary;
        int rightIndex = midIndex + 1;
        // 分区比较
        for (int i = leftBoundary; i <= rightBoundary; i++) {
            if (leftIndex == midIndex + 1) {
                nums[i] = tempNums[rightIndex++];
            } else if (rightIndex == rightBoundary + 1) {
                nums[i] = tempNums[leftIndex++];
            } else if (tempNums[leftIndex] >= tempNums[rightIndex]) {
                nums[i] = tempNums[rightIndex++];
            } else if (tempNums[leftIndex] < tempNums[rightIndex]) {
                nums[i] = tempNums[leftIndex++];
            }
        }
    }

}
