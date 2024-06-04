package com.shuttle.algorithm.leetcode.dynamicprogramming;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/min-cost-climbing-stairs/description">使用最小花费爬楼梯</a>
 */
public class LC_0746 {

    /**
     * 解法一：滚动数组
     * 时间复杂度：O(n)，n 表示 cost 数组的长度
     * 空间复杂度：O(1)
     *
     * @param cost 整数数组
     * @return 达到楼梯顶部的最低花费
     */
    public int minCostClimbingStairsSolution1(int[] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }
        int costLen = cost.length;
        int pre = 0;
        int cur = 0;

        for (int i = 2; i <= costLen; i++) {
            int next = Math.min(cur + cost[i - 1], pre + cost[i - 2]);
            pre = cur;
            cur = next;
        }

        return cur;
    }

    /**
     * 解法二：动态规划
     * 时间复杂度：O(n)，n 表示 cost 数组的长度
     * 空间复杂度：O(n)，dp 数组
     *
     * @param cost 整数数组
     * @return 达到楼梯顶部的最低花费
     */
    public int minCostClimbingStairsSolution2(int[] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }
        int costLen = cost.length;
        // dp[i] 代表爬到第i个台阶的最低花费
        int[] dp = new int[costLen + 1];
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= costLen; i++) {
            // 爬到当前台阶的最低花费 = min [前一节的花费 || 前两节的花费]
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        return dp[costLen];
    }

}
