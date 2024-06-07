package com.shuttle.algorithm.leetcode.dynamicprogramming;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/combination-sum-iv/description">组合总和 Ⅳ</a>
 */
public class LC_0377 {

    /**
     * 思路：动态规划
     * 时间复杂度：O(n * m)，n == target，m 是 nums 数组的长度
     * 空间复杂度：O(n)
     *
     * @param nums   整数数组
     * @param target 目标整数
     * @return nums 中找出并返回总和为 target 的元素组合的个数
     */
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // dp[i] 代表在 nums 中总和为 i 的元素组合个数
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    // 如果当前总和 i >= num，说明可以由 dp[i - num] 转移而来
                    dp[i] += dp[i - num];
                }
            }
        }

        return dp[target];
    }

}
