package com.shuttle.algorithm.leetcode.unclassified;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/spiral-matrix/description">螺旋矩阵</a>
 */
public class LC_0054 {

    /**
     * 思路：设置各方向上的边界值，顺时针遍历即可
     * 时间复杂度：O(m * n)，m 是矩阵行数，n 是矩阵列数
     * 空间复杂度：O(1)
     *
     * @param matrix m 行 n 列 的矩阵
     * @return 矩阵中的所有元素集合
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int left = 0;
        int right = column - 1;
        int top = 0;
        int bottom = row - 1;

        while (left <= right && top <= bottom) {
            // 上边
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            // 右边
            for (int i = top + 1; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            if (left < right && top < bottom) {
                // 下边
                for (int i = right - 1; i > left; i--) {
                    res.add(matrix[bottom][i]);
                }
                // 左边
                for (int i = bottom; i > top; i--) {
                    res.add(matrix[i][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }

        return res;
    }

}
