package com.shuttle.algorithm.leetcode.binarysearch;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/search-insert-position">搜索插入位置</a>
 */
public class LC_0035 {

    /**
     * 同 leetcode 704
     * 思路：不断取中间值与目标值进行比较
     * 时间复杂度：O(log n)
     * 空间复杂度：O(1)
     *
     * @param nums   升序数组
     * @param target 目标值
     * @return 返回目标值应该插入数组中的索引值
     */
    public int searchInsert(int[] nums, int target) {
        // 数组为空不能插入
        if (nums == null) {
            return -1;
        }
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        // length == 0 放在数组首位
        if (nums.length == 0) {
            return leftIndex;
        }

        while (leftIndex <= rightIndex) {
            int midIndex = leftIndex + (rightIndex - leftIndex) / 2;
            // 找到直接返回
            if (nums[midIndex] == target) {
                return midIndex;
            }
            if (nums[midIndex] > target) {
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
