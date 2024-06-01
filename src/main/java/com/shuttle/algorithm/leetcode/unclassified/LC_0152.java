package com.shuttle.algorithm.leetcode.unclassified;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/maximum-product-subarray/description">乘积最大子数组</a>
 */
public class LC_0152 {

    /**
     * 思路：遍历数组的同时维护最小和最大值
     * 时间复杂度：O(log n)，n 是 nums 数组的长度
     * 空间复杂度：O(1)
     *
     * @param nums 整数数组
     * @return 乘积最大子数组
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int numsLen = nums.length;
        if (numsLen == 1) {
            return nums[0];
        }
        int maxProduct = Integer.MIN_VALUE;
        // 由于存在负数，那么会导致最大的变最小的，最小的变最大的，因此还需要维护当前最小值。
        int curMax = 1;
        int curMin = 1;

        for (int num : nums) {
            // 如果当前元素小于 0 就交换维护的最大值和最小值
            if (num < 0) {
                int temp = curMax;
                curMax = curMin;
                curMin = temp;
            }
            // 计算当前最大值和最小值
            curMax = Math.max(curMax * num, num);
            curMin = Math.min(curMin * num, num);
            maxProduct = Math.max(curMax, maxProduct);
        }

        return maxProduct;
    }

}
