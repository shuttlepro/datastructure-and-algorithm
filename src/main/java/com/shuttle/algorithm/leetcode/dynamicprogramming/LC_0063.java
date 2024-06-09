package com.shuttle.algorithm.leetcode.dynamicprogramming;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/unique-paths-ii/description">不同路径 II</a>
 */
public class LC_0063 {

    /**
     * 解法一：动态规划
     * 时间复杂度：O(m * n)，m 是网格的行数，n 是网格的列数
     * 空间复杂度：O(m * n)
     *
     * @param obstacleGrid 二维数组代表的网格
     * @return 从左上角到右下角有多少种不同路径
     */
    public int uniquePathsWithObstaclesSolution1(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        // dp[i][j] 代表从左上角走到 [i, j] 的路径数量
        int[][] dp = new int[m][n];
        // 在前一题的基础上需要判断当前是否被阻挡
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n && obstacleGrid[0][i] == 0; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    // 状态转移方程
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    /**
     * 解法二：滚动数组
     * 时间复杂度：O(m * n)，m 是网格的行数，n 是网格的列数
     * 空间复杂度：O(n)
     *
     * @param obstacleGrid 二维数组代表的网格
     * @return 从左上角到右下角有多少种不同路径
     */
    public int uniquePathsWithObstaclesSolution2(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        // dp[i] 代表从左上角走到每一行的每个单元格的路径数量
        int[] dp = new int[n];
        dp[0] = obstacleGrid[0][0] == 0 ? 1 : 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else if (j - 1 >= 0) {
                    // 如果当前单元格没有障碍物，且左边有单元格，更新当前单元格的路径数，等于左边单元格和当前单元格路径数之和
                    dp[j] += dp[j - 1];
                }
            }
        }

        return dp[n - 1];
    }

}
