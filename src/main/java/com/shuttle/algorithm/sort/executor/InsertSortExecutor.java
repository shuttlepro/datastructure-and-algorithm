package com.shuttle.algorithm.sort.executor;

/**
 * @author: Shuttle
 * @description: 插入排序
 */
public class InsertSortExecutor implements SortExecutor {

    /**
     * 思路：将数组分为前边已排序和后边未排序的两部分，依次将未排序部分的元素插入到排序序列的指定位置。
     * 时间复杂度：O(n * log n) 外层循环 * 内层二分查找，n 是 nums 的长度。
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
         * for (int i = 1; i < numsLen; i++) {
         *     // 未排序部分的元素在排序部分 从右往左 找到属于自己的位置
         *     for (int j = i - 1; j >= 0 && nums[j] > nums[j + 1]; j--) {
         *         DataHelper.swapTwoElementInArray(nums, j, j + 1);
         *     }
         * }
         */
        // 优化点：将比较过程改为二分法
        for (int i = 1; i < numsLen; i++) {
            int leftIndex = 0;
            int rightIndex = i - 1;
            int curNum = nums[i];

            while (leftIndex <= rightIndex) {
                int midIndex = leftIndex + (rightIndex - leftIndex) / 2;
                if (nums[midIndex] > curNum) {
                    rightIndex = midIndex - 1;
                } else {
                    leftIndex = midIndex + 1;
                }
            }
            // 需要将所有元素往右移一位
            int j;

            for (j = i - 1; j >= rightIndex + 1; j--) {
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = curNum;
        }
    }

}
