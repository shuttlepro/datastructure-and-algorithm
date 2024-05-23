package com.shuttle.algorithm.leetcode.unclassified;

/**
 * @author: Shuttle
 * @description: 给你一个未排序的整数数组 nums，请你找出其中没有出现的最小的正整数。
 * 示例 1：
 * 输入：nums = [1,2,0]
 * 输出：3
 * 解释：范围 [1,2] 中的数字都在数组中。
 * 示例 2：
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * 解释：1 在数组中，但 2 没有。
 */
public class LC_0041 {

    /**
     * 思路：遍历数组，将出现的数放到对应索引位置上
     * 时间复杂度：O(n)，n 为 nums 数组的长度
     * 空间复杂度：O(1)
     *
     * @param nums 未排序的整数数组
     * @return 整数数组中没有出现的最小正整数
     */
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int numsLen = nums.length;

        for (int i = 0; i < numsLen; i++) {
            while (nums[i] > 0 && nums[i] <= numsLen && nums[nums[i] - 1] != nums[i]) {
                // 满足在指定范围内、并且没有放在正确的位置上，才交换
                // 例如：数值 3 应该放在索引 2 的位置上
                swapTwoNum(nums, nums[i] - 1, i);
            }
        }
        // 找到消失的整数
        for (int i = 0; i < numsLen; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return numsLen + 1;
    }

    private void swapTwoNum(int[] nums, int source, int target) {
        int temp = nums[source];
        nums[source] = nums[target];
        nums[target] = temp;
    }

}
