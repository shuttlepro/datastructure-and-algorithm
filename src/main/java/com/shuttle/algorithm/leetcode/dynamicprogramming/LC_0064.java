package com.shuttle.algorithm.leetcode.dynamicprogramming;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/minimum-path-sum/description">最小路径和</a>
 */
public class LC_0064 {

    /**
     * 解法一：动态规划
     * 时间复杂度：O(m * n)，m 是网格的行数，n 是网格的列数
     * 空间复杂度：O(m * n)
     *
     * @param grid m x n 的网格
     * @return 从左上角到右下角的路径数字总和为最小
     */
    public int minPathSumSolution1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // dp[i][j] 代表到达 grid[i][j] 的最小路径和
        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];
        // 初始化上边和左边
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[m - 1][n - 1];
    }

    /**
     * 解法二：滚动数组
     * 时间复杂度：O(m * n)，m 是网格的行数，n 是网格的列数
     * 空间复杂度：O(n)
     *
     * @param grid m x n 的网格
     * @return 从左上角到右下角的路径数字总和为最小
     */
    public int minPathSumSolution2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // dp[j] 代表到达 grid[i][j] 的最小路径和
        int[] dp = new int[n];

        dp[0] = grid[0][0];
        // 初始化第一行
        for (int j = 1; j < n; j++) {
            dp[j] = dp[j - 1] + grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            // 初始化每一行的第一个元素
            dp[0] += grid[i][0];
            for (int j = 1; j < n; j++) {
                dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
            }
        }

        return dp[n - 1];
    }

}
