package com.shuttle.algorithm.leetcode.dynamicprogramming;

import java.util.Arrays;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/unique-paths/description">不同路径</a>
 */
public class LC_0062 {

    /**
     * 解法一：动态规划
     * 时间复杂度：O(m * n)
     * 空间复杂度：O(m * n)
     *
     * @param m 行数
     * @param n 列数
     * @return 从左上角到右下角有多少条不同的路径
     */
    public int uniquePathsSolution1(int m, int n) {
        // dp[i][j] 代表从左上角走到 [i, j] 的路径数量
        int[][] dp = new int[m][n];
        // 二维数组上边和左边只有一种走法
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 动态转移方程，当前的位置可以由上或左移动得到
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }

        return dp[m - 1][n - 1];
    }

    /**
     * 解法二：滚动数组
     * 时间复杂度：O(m * n)
     * 空间复杂度：O(n)
     *
     * @param m 行数
     * @param n 列数
     * @return 从左上角到右下角有多少条不同的路径
     */
    public int uniquePathsSolution2(int m, int n) {
        // dp[i] 代表从左上角走到每一行的每个单元格的路径数量
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 更新 dp 数组，当前单元格的路径数量为从左边单元格 dp[j - 1] 和上方单元格 dp[j] 到达当前单元格的路径数量之和
                dp[j] += dp[j - 1];
            }
        }
        // dp 数组的最后一个元素表示到达网格右下角的路径数量
        return dp[n - 1];
    }

}
