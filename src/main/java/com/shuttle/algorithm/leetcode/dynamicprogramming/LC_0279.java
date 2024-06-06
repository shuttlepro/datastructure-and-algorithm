package com.shuttle.algorithm.leetcode.dynamicprogramming;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/perfect-squares/description">完全平方数</a>
 */
public class LC_0279 {

    /**
     * 思路：动态规划
     * 时间复杂度：O(n * n<sup>1/2</sup>)
     * 空间复杂度：O(n)
     *
     * @param n 整数
     * @return 和为 n 的完全平方数的最少数量
     */
    public int numSquares(int n) {
        if (n <= 0) {
            return 0;
        }
        // dp[i] 代表和为 i 的完全平方数的最小数量
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            // 最坏的情况就是 i
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j++) {
                // 尝试减去一个平方数 j*j，剩余部分 dp[i - j * j] 的最小数量 + 1
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }

}
