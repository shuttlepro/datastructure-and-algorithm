package com.shuttle.algorithm.leetcode.unclassified;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/shortest-unsorted-continuous-subarray/description">最短无序连续子数组</a>
 */
public class LC_0581 {

    /**
     * 思路：一次遍历，同时找到倒置数组的左边和右边索引
     * 时间复杂度：O(n)，n 是 nums 数组的长度
     * 空间复杂度：O(1)
     *
     * @param nums 整数数组
     * @return 最短无序连续子数组的长度
     */
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int numsLen = nums.length;
        int leftBoundary = -1;
        int rightBoundary = -1;
        int curMax = Integer.MIN_VALUE;
        int curMin = Integer.MAX_VALUE;

        for (int i = 0; i < numsLen; i++) {
            // 正序遍历，找到最后一个小于最大值的值作为倒置数组的右边索引
            if (nums[i] < curMax) {
                rightBoundary = i;
            } else {
                curMax = nums[i];
            }
            // 逆序遍历，找到最后一个大于最小值的值作为倒置数组的左边索引
            int index = numsLen - 1 - i;
            if (nums[index] > curMin) {
                leftBoundary = index;
            } else {
                curMin = nums[index];
            }
        }

        return leftBoundary == -1 ? 0 : rightBoundary - leftBoundary + 1;
    }

}
