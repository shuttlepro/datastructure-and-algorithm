package com.shuttle.algorithm.leetcode.dynamicprogramming;

import java.util.Arrays;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/house-robber-ii/description">打家劫舍 II</a>
 */
public class LC_0213 {

    /**
     * 解法同 LC_0198，需要考虑房屋连成环后的两种情况
     *
     * @param nums 沿街房屋组成的金额数组
     * @return 在不触动警报装置的情况下，一夜之内能够偷窃到的最高金额
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int numsLen = nums.length;
        if (numsLen == 1) {
            return nums[0];
        }
        if (numsLen == 2) {
            return Math.max(nums[0], nums[1]);
        }
        // 分成[0, i - 1] 和 [1, i] 两种情况，比较大小
        return Math.max(getMaxSolution1(nums, 0, numsLen - 1), getMaxSolution1(nums, 1, numsLen));
    }

    private int getMaxSolution1(int[] nums, int start, int len) {
        int[] copyNums = Arrays.copyOfRange(nums, start, len);
        int cLen = copyNums.length;

        // dp[i] 代表偷第i个房子最高金额
        int[] dp = new int[cLen];
        dp[0] = copyNums[0];
        dp[1] = Math.max(copyNums[0], copyNums[1]);

        for (int i = 2; i < cLen; i++) {
            // 昨天偷 || 今天偷
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + copyNums[i]);
        }

        return dp[cLen - 1];
    }

    private int getMaxSolution2(int[] nums, int start, int len) {
        int pre = nums[start];
        int max = Math.max(nums[start], nums[start + 1]);

        for (int i = start + 2; i < len; i++) {
            int temp = max;
            max = Math.max(pre + nums[i], max);
            pre = temp;
        }

        return max;
    }

}
