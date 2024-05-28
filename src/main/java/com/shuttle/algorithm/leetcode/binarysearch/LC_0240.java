package com.shuttle.algorithm.leetcode.binarysearch;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/search-a-2d-matrix-ii/description">搜索二维矩阵 II</a>
 */
public class LC_0240 {

    /**
     * 思路：每行都进行二分查找
     * 时间复杂度：O(m * log n)，m 是矩阵的行数，n 是矩阵的列数
     * 空间复杂度：O(1)
     *
     * @param matrix 二维矩阵
     * @param target 目标值
     * @return 目标值是否存在于二维矩阵中
     */
    public boolean searchMatrixSolution1(int[][] matrix, int target) {
        if (matrix == null || matrix[0].length == 0) {
            return false;
        }
        for (int[] nums : matrix) {
            int targetIndex = binarySearch(nums, target);
            if (targetIndex >= 0) {
                return true;
            }
        }

        return false;
    }

    private int binarySearch(int[] nums, int target) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;

        while (leftIndex <= rightIndex) {
            int midIndex = leftIndex + (rightIndex - leftIndex) / 2;
            if (nums[midIndex] == target) {
                return midIndex;
            } else if (nums[midIndex] > target) {
                rightIndex = midIndex - 1;
            } else {
                leftIndex = midIndex + 1;
            }
        }

        return -1;
    }

    /**
     * 思路：从左下角开始阶梯式查找
     * 时间复杂度：O(m + n)，m 是矩阵的行数，n 是矩阵的列数
     * 空间复杂度：O(1)
     *
     * @param matrix 二维矩阵
     * @param target 目标值
     * @return 目标值是否存在于二维矩阵中
     */
    public boolean searchMatrixSolution2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int curRow = row - 1;
        int curColumn = 0;

        while (curRow >= 0 && curColumn < column) {
            if (matrix[curRow][curColumn] == target) {
                return true;
            }
            if (matrix[curRow][curColumn] > target) {
                curRow--;
            } else {
                curColumn++;
            }
        }

        return false;
    }

}
