package com.shuttle.algorithm.leetcode.doublepointer;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/move-zeroes/description">移动零</a>
 */
public class LC_0283 {

    /**
     * 思路：双指针
     * 时间复杂度：O(n) n 是 nums 数组的长度
     * 空间复杂度：O(1)
     *
     * @param nums 整数数组
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int leftIndex = 0;
        int rightIndex = 0;
        int numsLen = nums.length;

        while (rightIndex < numsLen) {
            // 每次遇到非零元素，都需要将它交换到数组中左边第一个未被置换为零的位置，保持非零元素的相对顺序。
            if (nums[rightIndex] != 0) {
                swapTwoNum(nums, leftIndex, rightIndex);
                leftIndex++;
            }
            rightIndex++;
        }
    }

    private void swapTwoNum(int[] nums, int src, int dest) {
        int temp = nums[src];
        nums[src] = nums[dest];
        nums[dest] = temp;
    }

}
