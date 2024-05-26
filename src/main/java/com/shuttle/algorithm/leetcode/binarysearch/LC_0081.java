package com.shuttle.algorithm.leetcode.binarysearch;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/search-in-rotated-sorted-array-ii">搜索旋转排序数组 II</a>
 */
class LC_0081 {

    /**
     * 思路：LC_0033 的变种，当遇到 indexVal == midVal 时需要特殊处理
     * 时间复杂度：O(log n)
     * 空间复杂度：O(1)
     *
     * @param nums   旋转排序数组
     * @param target 目标值
     * @return 目标值在数组中是否存在
     */
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int leftIndex = 0;
        int rightIndex = nums.length - 1;

        while (leftIndex <= rightIndex) {
            int midIndex = leftIndex + (rightIndex - leftIndex) / 2;
            if (nums[midIndex] == target) {
                return true;
            }
            if (nums[leftIndex] < nums[midIndex]) {
                // 左边有序
                if (nums[leftIndex] <= target && target < nums[midIndex]) {
                    rightIndex = midIndex - 1;
                } else {
                    leftIndex = midIndex + 1;
                }
            } else if (nums[leftIndex] > nums[midIndex]) {
                // 右边有序
                if (nums[rightIndex] >= target && target > nums[midIndex]) {
                    leftIndex = midIndex + 1;
                } else {
                    rightIndex = midIndex - 1;
                }
            } else {
                // nums[midIndex] == nums[leftIndex] 时
                // if nums[leftIndex] == target ==> nums[midIndex] == target 不满足
                // if nums[leftIndex] != target ==> leftIndex is not result
                leftIndex++;
            }
        }

        return false;
    }

}
