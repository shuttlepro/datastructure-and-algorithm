package com.shuttle.algorithm.leetcode.binarysearch;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/sqrtx">x 的平方根</a>
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
