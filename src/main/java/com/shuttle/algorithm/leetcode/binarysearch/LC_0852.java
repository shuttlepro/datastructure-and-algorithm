package com.shuttle.algorithm.leetcode.binarysearch;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/peak-index-in-a-mountain-array/description">山脉数组的峰顶索引</a>
 */
public class LC_0852 {

    /**
     * 思路：同 162
     *
     * @param arr 整数数组
     * @return 数组中的峰值元素索引
     */
    public int peakIndexInMountainArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int leftIndex = 0;
        int rightIndex = arr.length - 2;

        while (leftIndex < rightIndex) {
            int midIndex = leftIndex + (rightIndex - leftIndex) / 2;
            if (arr[midIndex] < arr[midIndex + 1]) {
                // [midIndex + 1, rightIndex]
                leftIndex = midIndex + 1;
            } else {
                // 说明结果在靠左 [leftIndex, midIndex]
                rightIndex = midIndex;
            }
        }

        return leftIndex;
    }

}
