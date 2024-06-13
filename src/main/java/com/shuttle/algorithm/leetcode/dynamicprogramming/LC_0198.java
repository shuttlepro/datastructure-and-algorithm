package com.shuttle.algorithm.leetcode.dynamicprogramming;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/house-robber/description">打家劫舍</a>
 */
public class LC_0198 {

    /**
     * 解法一：动态规划
     * 时间复杂度：O(n)，n 是 nums 的长度
     * 空间复杂度：O(n)
     *
     * @param nums 沿街房屋组成的金额数组
     * @return 在不触动警报装置的情况下，一夜之内能够偷窃到的最高金额
     */
    public int robSolution1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int numsLen = nums.length;
        if (numsLen == 1) {
            return nums[0];
        }

        // dp[i] 代表偷第 i 个房子最高金额
        int[] dp = new int[numsLen];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < numsLen; i++) {
            // 昨天偷 || 今天偷
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[numsLen - 1];
    }

    /**
     * 解法二：滚动数组
     * 时间复杂度：O(n)，n 是 nums 的长度
     * 空间复杂度：O(1)
     *
     * @param nums 沿街房屋组成的金额数组
     * @return 在不触动警报装置的情况下，一夜之内能够偷窃到的最高金额
     */
    public int robSolution2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int numsLen = nums.length;
        if (numsLen == 1) {
            return nums[0];
        }

        // pre 表示前一个位置能抢到的最大金额
        int pre = nums[0];
        // max 表示前两个位置能抢到的最大金额
        int max = Math.max(nums[0], nums[1]);

        for (int i = 2; i < numsLen; i++) {
            int temp = max;
            // 计算当前位置能抢到的最大金额
            max = Math.max(pre + nums[i], max);
            pre = temp;
        }

        return max;
    }

}
