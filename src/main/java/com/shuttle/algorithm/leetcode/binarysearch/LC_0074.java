package com.shuttle.algorithm.leetcode.binarysearch;

/**
 * @author: Shuttle
 * @description: 给你一个满足下述两条属性的 m x n 整数矩阵：
 * 每行中的整数从左到右按非严格递增顺序排列。每行的第一个整数大于前一行的最后一个整数。
 * 给你一个整数 target，如果 target 在矩阵中，返回 true；否则，返回 false。
 * 原题出处：<a href="https://leetcode.cn/problems/search-a-2d-matrix/description">搜索二维矩阵</a>
 */
public class LC_0074 {

    /**
     * 思路：二维数组扁平化后使用二分查找
     * 时间复杂度：O(log m * n) m 是矩阵的行数，n 是矩阵的列数
     * 空间复杂度：O(1)
     *
     * @param matrix 二维矩阵
     * @param target 目标值
     * @return 目标值是否存在于二维矩阵中
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix[0].length == 0) {
            return false;
        }
        int column = matrix.length;
        int row = matrix[0].length;
        int leftIndex = 0;
        int rightIndex = column * row - 1;

        while (leftIndex <= rightIndex) {
            int midIndex = leftIndex + (rightIndex - leftIndex) / 2;
            // 相当于把后一列的开头拼在前一列的结尾
            int num = matrix[midIndex / row][midIndex % row];
            if (num == target) {
                return true;
            } else if (num > target) {
                rightIndex = midIndex - 1;
            } else {
                leftIndex = midIndex + 1;
            }
        }

        return false;
    }

}
