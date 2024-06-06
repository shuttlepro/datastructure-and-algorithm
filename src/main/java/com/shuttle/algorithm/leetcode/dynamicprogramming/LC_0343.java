package com.shuttle.algorithm.leetcode.dynamicprogramming;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/integer-break/description">整数拆分</a>
 */
public class LC_0343 {

    /**
     * 思路：动态规划
     * 时间复杂度：O(n²)
     * 空间复杂度：O(n)
     *
     * @param n 整数
     * @return 拆分为 k 个正整数的和，它们的乘积最大
     */
    public int integerBreak(int n) {
        // dp[i] 代表数字 i 能拆分出的最大乘积
        int[] dp = new int[n + 1];
        // 初始化
        dp[0] = 0;
        dp[1] = 1;
        int maxVal = Integer.MIN_VALUE;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(maxVal, Math.max(j * (i - j), j * dp[i - j]));
                maxVal = dp[i];
            }
        }

        return dp[n];
    }

}
