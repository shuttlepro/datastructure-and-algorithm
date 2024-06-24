package com.shuttle.algorithm.leetcode.dynamicprogramming;

import java.util.Arrays;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/longest-continuous-increasing-subsequence/description">最长连续递增序列</a>
 */
public class LC_0674 {

    /**
     * 解法一：动态规划
     * 时间复杂度：O(n)，n 是 nums 数组的长度
     * 空间复杂度：O(n)
     *
     * @param nums 整数数组
     * @return 数组中最长且递增的子序列的长度
     */
    public int findLengthOfLCISSolution1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[len];
        // 每一个元素都是一个递增子序列
        Arrays.fill(dp, 1);

        for (int i = 1; i < len; i++) {
            // 如果当前元素大于前一个元素，则当前元素可以加入到前一个元素的递增子序列中
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }

    /**
     * 解法二：贪心算法
     * 时间复杂度：O(n)，n 是 nums 数组的长度
     * 空间复杂度：O(1)
     *
     * @param nums 整数数组
     * @return 数组中最长且递增的子序列的长度
     */
    public int findLengthOfLCISSolution2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int res = 1;
        int start = 0;

        for (int i = 1; i < len; i++) {
            // 如果当前元素不大于前一个元素，说明当前连续递增子序列结束，更新起始索引为当前索引
            if (nums[i - 1] >= nums[i]) {
                start = i;
            }
            // 更新最长递增子序列长度，取当前计算的最大长度和之前记录的最大长度的较大值
            // i - start + 1 表示以当前元素结尾的递增子序列长度
            res = Math.max(res, i - start + 1);
        }

        return res;
    }

}
