package com.shuttle.algorithm.leetcode.dynamicprogramming;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/burst-balloons/description">戳气球</a>
 */
public class LC_0312 {

    /**
     * 思路：动态规划
     * 时间复杂度：O(n³)，n 是 nums 数组的长度
     * 空间复杂度：O(n²)
     *
     * @param nums 由 n 个气球数字组成的数组
     * @return 戳破气球后，可以获得的最大硬币数
     */
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int numsLen = nums.length;
        // 填充新数组 0 和 numsLen + 1 的位置是 1，其它地方不变
        int[] newNums = new int[numsLen + 2];
        for (int i = 0; i < numsLen + 2; i++) {
            if (i == 0 || i == numsLen + 1) {
                newNums[i] = 1;
            } else {
                newNums[i] = nums[i - 1];
            }
        }
        // dp[i][j] 代表 newNums 中从索引 i ~ j 位置最大获得硬币数
        int[][] dp = new int[numsLen + 2][numsLen + 2];

        for (int j = 2; j < numsLen + 2; j++) { // 区间的右端点
            for (int i = j - 2; i >= 0; i--) { // 区间的左端点
                for (int k = i + 1; k < j; k++) { // 当前射击的点
                    // 计算以 k 为最后爆破气球时，可以获得的最大硬币数
                    // 包括 k 本身带来的价值以及左右两侧子区间爆破气球获得的价
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + newNums[i] * newNums[k] * newNums[j]);
                }
            }
        }

        return dp[0][numsLen + 1];
    }

}
