package com.shuttle.algorithm.leetcode.unclassified;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/set-matrix-zeroes/description">矩阵置零</a>
 */
public class LC_0073 {

    /**
     * 思路：遍历
     * 时间复杂度：O(m * n)，m 是矩阵的行数，n 是矩阵的列数
     * 空间复杂度：O(1)
     *
     * @param matrix 矩阵
     */
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        // 记录首行首列是否为 0
        boolean row0 = false;
        boolean column0 = false;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        column0 = true;
                    }
                    if (j == 0) {
                        row0 = true;
                    }
                    // 处理第一行和第一列
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        // 处理其他行和列
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // 补充首行首列结果
        if (row0) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
        if (column0) {
            for (int i = 0; i < column; i++) {
                matrix[0][i] = 0;
            }
        }
    }

}
