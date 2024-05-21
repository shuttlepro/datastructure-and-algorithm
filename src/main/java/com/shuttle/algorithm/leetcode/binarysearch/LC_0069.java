package com.shuttle.algorithm.leetcode.binarysearch;

/**
 * @author: Shuttle
 * @description: 给你一个非负整数 x，计算并返回 x 的算术平方根。
 * 由于返回类型是整数，结果只保留整数部分，小数部分将被舍去。
 * 示例 1：
 * 输入：x = 4
 * 输出：2
 * 示例 2：
 * 输入：x = 8
 * 输出：2
 * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 */
public class LC_0069 {

    /**
     * 思路：二分查找，比较 mid² 和 x 的大小
     * 时间复杂度：O(log x)
     * 空间复杂度：O(1)
     *
     * @param x 非负整数
     * @return x 的算术平方根
     */
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int sqrt = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid <= x) {
                sqrt = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return sqrt;
    }

}
