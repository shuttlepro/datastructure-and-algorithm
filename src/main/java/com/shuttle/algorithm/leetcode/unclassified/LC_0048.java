package com.shuttle.algorithm.leetcode.unclassified;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/rotate-image">旋转图像</a>
 */
public class LC_0048 {

    /**
     * 思路：顺时针旋转 90° 等价于 水平翻转 + 主对角线翻转
     *      逆时针旋转 90° 等价于 水平翻转 + 一条对角线翻转
     * 时间复杂度：O(n²) n 是待旋转的二维数组 matrix 的长度
     * 空间复杂度：O(1) 没有额外创建数据结构
     *
     * @param matrix 待旋转的二维数组
     */
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix[0].length == 0) {
            return;
        }
        int matrixLen = matrix.length;
        // 先水平翻转
        for (int i = 0; i < matrixLen / 2; i++) {
            for (int j = 0; j < matrixLen; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[matrixLen - i - 1][j];
                matrix[matrixLen - i - 1][j] = temp;
            }
        }
        // 再主对角线翻转
        for (int i = 0; i < matrixLen; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

}
