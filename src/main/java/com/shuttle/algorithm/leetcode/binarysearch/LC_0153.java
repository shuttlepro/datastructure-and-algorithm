package com.shuttle.algorithm.leetcode.binarysearch;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/description">寻找旋转排序数组中的最小值</a>
 */
public class LC_0153 {

    /**
     * 思路：二分查找
     * 详细解释：<a href="https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/solutions/126635/er-fen-cha-zhao-wei-shi-yao-zuo-you-bu-dui-cheng-z">二分查找</a>
     * 时间复杂度：O(log n)
     * 空间复杂度：O(1)
     *
     * @param nums 整数数组
     * @return 数组中的最小值
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int leftIndex = 0;
        int rightIndex = nums.length - 1;

        while (leftIndex < rightIndex) {
            int midIndex = leftIndex + (rightIndex - leftIndex) / 2;
            if (nums[midIndex] > nums[rightIndex]) {
                // [midIndex + 1, rightIndex]
                leftIndex = midIndex + 1;
            } else {
                // [leftIndex, midIndex]
                rightIndex = midIndex;
            }
        }

        return nums[leftIndex];
    }

}
