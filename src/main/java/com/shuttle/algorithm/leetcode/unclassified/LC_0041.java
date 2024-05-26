package com.shuttle.algorithm.leetcode.unclassified;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/first-missing-positive">缺失的第一个正数</a>
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
