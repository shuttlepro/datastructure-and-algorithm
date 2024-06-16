package com.shuttle.algorithm.leetcode.dynamicprogramming;

import java.util.Arrays;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/maximum-subarray/description">最大子数组和</a>
 */
public class LC_0053 {

    /**
     * 解法一：动态规划
     * 时间复杂度：O(n)，n 是 nums 的长度
     * 空间复杂度：O(n)
     *
     * @param nums 整数数组
     * @return 连续子数组的最大和
     */
    public int maxSubArraySolution1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int numsLen = nums.length;
        int[] dp = new int[numsLen];
        dp[0] = nums[0];

        for (int i = 1; i < numsLen; i++) {
            // 如果前一个元素之前的和小于 0 则直接抛弃，否则加上 nums[i]
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }

    /**
     * 解法二：滚动数列
     * 时间复杂度：O(n)，n 是 nums 的长度
     * 空间复杂度：O(1)
     *
     * @param nums 整数数组
     * @return 连续子数组的最大和
     */
    public int maxSubArraySolution2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 记录当前数字前部分的最大和[不包括当前数字]
        int pre = 0;
        // 记录当前数字前部分的最大和[包括当前数字]
        int res = nums[0];

        for (int num : nums) {
            pre = Math.max(pre + num, num);
            res = Math.max(pre, res);
        }

        return res;
    }

}
