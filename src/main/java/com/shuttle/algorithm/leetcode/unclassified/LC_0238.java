package com.shuttle.algorithm.leetcode.unclassified;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/product-of-array-except-self/description">除自身以外数组的乘积</a>
 */
public class LC_0238 {

    /**
     * 思路：除当前元素的数组乘积 = 当前元素左边的乘积 * 右边的乘积
     * 时间复杂度：O(n)，n 是 nums 数组的长度
     * 空间复杂度：O(n)
     *
     * @param nums 整数数组
     * @return 除自身以外数组的乘积
     */
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        int tempLeft = 1;
        int tempRight = 1;
        int numsLen = nums.length;
        int[] res = new int[numsLen];

        // 计算当前元素左边的数组乘积
        for (int i = 0; i < numsLen; i++) {
            res[i] = tempLeft;
            tempLeft *= nums[i];
        }
        // 计算当前元素右边的数组乘积同时计算结果
        for (int i = numsLen - 1; i > 0; i--) {
            tempRight *= nums[i];
            res[i - 1] *= tempRight;
        }

        return res;
    }

}
