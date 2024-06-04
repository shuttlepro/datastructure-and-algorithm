package com.shuttle.algorithm.leetcode.dynamicprogramming;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/fibonacci-number/description">斐波那契数</a>
 */
public class LC_0509 {

    /**
     * 解法一：滚动数组
     * 时间复杂度：O(n)，等同第 n 个
     * 空间复杂度：O(1)
     *
     * @param n 第 n 个
     * @return 第 n 个斐波那契数
     */
    public int fibSolution1(int n) {
        if (n < 2) {
            return n;
        }
        int prev = 0;
        int next = 0;
        int fib = 1;

        for (int i = 2; i <= n; i++) {
            prev = next;
            next = fib;
            fib = prev + next;
        }

        return fib;
    }

    /**
     * 解法二：动态规划
     * 时间复杂度：O(n)，等同第 n 个
     * 空间复杂度：O(n)，dp 数组
     *
     * @param n 第 n 个
     * @return 第 n 个斐波那契数
     */
    public int fibSolution2(int n) {
        if (n < 2) {
            return n;
        }
        // dp[i] 代表第 i 个斐波那契数
        int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

}
