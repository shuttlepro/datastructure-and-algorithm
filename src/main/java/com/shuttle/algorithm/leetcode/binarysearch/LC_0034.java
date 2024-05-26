package com.shuttle.algorithm.leetcode.binarysearch;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array">在排序数组中查找元素的第一个和最后一个位置</a>
 */
public class LC_0034 {

    /**
     * 思路：二分查找指定元素第一次出现的位置和指定元素 +1 后出现的第一次位置
     * 时间复杂度：O(log n)
     * 空间复杂度：O(1)
     *
     * @param nums   整数数组
     * @param target 查找目标值
     * @return 目标值在数组中的第一个和最后一个位置
     */
    public int[] searchRange(int[] nums, int target) {
        // 查找指定元素第一次出现的位置
        int firstIndex = firstIndexOf(nums, target);
        // 如果已经是末尾或者末尾元素都不等于目标值直接返回
        if (firstIndex == nums.length || nums[firstIndex] != target) {
            return new int[]{-1, -1};
        }
        // 查找目标值 +1 后出现的第一次位置
        int lastIndex = firstIndexOf(nums, target + 1);

        return new int[]{firstIndex, lastIndex - 1};
    }

    public int firstIndexOf(int[] nums, int target) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;

        while (leftIndex <= rightIndex) {
            int midIndex = leftIndex + (rightIndex - leftIndex) / 2;
            if (nums[midIndex] >= target) {
                // target -> [leftIndex, midIndex - 1]
                rightIndex = midIndex - 1;
            } else {
                // target -> [midIndex + 1, rightIndex]
                leftIndex = midIndex + 1;
            }
        }

        return leftIndex;
    }

}
