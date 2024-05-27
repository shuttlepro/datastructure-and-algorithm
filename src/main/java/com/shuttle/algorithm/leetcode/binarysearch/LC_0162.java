package com.shuttle.algorithm.leetcode.binarysearch;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/find-peak-element/description">寻找峰值</a>
 */
public class LC_0162 {

    /**
     * 思路：二分查找，比较 midIndex 和 minIndex + 1 索引位置的元素大小
     * 时间复杂度：O(log N)
     * 空间复杂度：O(1)
     *
     * @param nums 整数数组
     * @return 数组中的峰值元素索引
     */
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int leftIndex = 0;
        int rightIndex = nums.length - 1;

        while (leftIndex < rightIndex) {
            int midIndex = leftIndex + (rightIndex - leftIndex) / 2;
            if (nums[midIndex] < nums[midIndex + 1]) {
                // 说明 midIndex 不是峰值元素
                leftIndex = midIndex + 1;
            } else {
                rightIndex = midIndex;
            }
        }

        return leftIndex;
    }

}
