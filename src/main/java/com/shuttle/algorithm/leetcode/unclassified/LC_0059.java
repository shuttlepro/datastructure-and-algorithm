package com.shuttle.algorithm.leetcode.unclassified;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/spiral-matrix-ii/description">螺旋矩阵 II</a>
 */
public class LC_0059 {

    /**
     * 思路：设置初始方向边界，按顺序迭代生成即可
     * 时间复杂度：O(n²)
     * 空间复杂度：O(n²)
     *
     * @param n 正整数
     * @return 正整数 n 生成的正方形矩阵
     */
    public int[][] generateMatrix(int n) {
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;
        int[][] matrix = new int[n][n];
        int num = 1;
        int count = n * n;

        while (num <= count) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            right--;
            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = num++;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = num++;
            }
            left++;
        }

        return matrix;
    }

}
