package com.shuttle.algorithm.leetcode.binarysearch;

/**
 * @author: Shuttle
 * @description: 整数数组 nums 按升序排列，数组中的值互不相同。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了旋转，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标从 0 开始计数）。
 * 例如，[0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2]。
 * 给你旋转后的数组 nums 和一个整数 target，如果 nums 中存在这个目标值 target，则返回它的下标，否则返回 -1。
 * 示例 1：
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 示例 2：
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 */
class LC_0033 {

    /**
     * 思路：旋转后一定有一部分是有序的，二分查找后分类讨论
     * 时间复杂度：O(log n)
     * 空间复杂度：O(1)
     *
     * @param nums   旋转排序数组
     * @param target 目标值
     * @return 目标值在数组中的索引值
     */
    public int search(int[] nums, int target) {
        int numsLen = nums.length;
        if (nums.length == 0) {
            return -1;
        } else if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int leftIndex = 0;
        int rightIndex = numsLen - 1;

        while (leftIndex <= rightIndex) {
            int midIndex = leftIndex + (rightIndex - leftIndex) / 2;
            if (nums[midIndex] == target) {
                return midIndex;
            }
            // [4, 5, 6, 7, 0, 1, 2] target = 6, midIndex = 3
            if (nums[0] <= nums[midIndex]) {
                // 左边有序
                if (nums[0] <= target && nums[midIndex] > target) {
                    rightIndex = midIndex - 1;
                } else {
                    leftIndex = midIndex + 1;
                }
            } else {
                // [4, 5, 6, 7, 0, 1, 2] target = 1, midIndex = 3
                // 右边有序
                if (nums[midIndex] < target && target <= nums[rightIndex]) {
                    leftIndex = midIndex + 1;
                } else {
                    rightIndex = midIndex - 1;
                }
            }
        }

        return -1;
    }

}
