package com.shuttle.algorithm.leetcode.dynamicprogramming;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/maximal-square/description">最大正方形</a>
 */
public class LC_0221 {

    /**
     * 思路：动态规划
     * 时间复杂度：O(m * n)，m 是二维矩阵的行数，n 是列数
     * 空间复杂度：O(m * n)
     *
     * @param matrix 二维矩阵
     * @return 二维矩阵中最大的正方形面积
     */
    public int maximalSquare(char[][] matrix) {
        // 记录正方形的最大边长
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        // dp[i][j] 代表以 matrix[i][j] 为右下角只包含 1 的最大边长
        int[][] dp = new int[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }

        return maxSide * maxSide;
    }

}
