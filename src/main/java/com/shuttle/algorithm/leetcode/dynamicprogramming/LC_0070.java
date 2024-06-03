package com.shuttle.algorithm.leetcode.dynamicprogramming;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/climbing-stairs/description">爬楼梯</a>
 */
public class LC_0070 {

    /**
     * 解法一：滚动数组
     *
     * @param n n 阶
     * @return 爬 n 阶楼梯的方法数
     */
    public int climbStairsSolution1(int n) {
        if (n < 0) {
            return 0;
        }
        // 滚动数组
        int prev = 0;
        int next = 0;
        int count = 1;

        for (int i = 1; i <= n; i++) {
            prev = next;
            next = count;
            count = prev + next;
        }

        return count;
    }

    /**
     * 解法二：动态规划
     *
     * @param n n 阶
     * @return 爬 n 阶楼梯的方法数
     */
    public int climbStairsSolution2(int n) {
        if (n < 0) {
            return 0;
        }
        // dp[i] 代表爬 n 阶楼梯的方法数
        int[] dp = new int[n + 1];
        // 初始化
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

}
