package com.shuttle.algorithm.leetcode.dynamicprogramming;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/uncrossed-lines/description">不相交的线</a>
 */
public class LC_1035 {

    /**
     * 思路：动态规划
     * 时间复杂度：O(n * m)，n 是 nums1 的长度，m 是 nums2 的长度
     * 空间复杂度：O(n * m)
     *
     * @param nums1 整数数组 1
     * @param nums2 整数数组 2
     * @return 可以绘制的最大连线数，等价于 最长公共子序列的长度
     */
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return 0;
        }

        int n1Len = nums1.length;
        int n2Len = nums2.length;
        // dp[i][j] 代表 nums1 的前 i 个元素和 nums2 的前 j 个元素之间的最长公共子序列
        int[][] dp = new int[n1Len + 1][n2Len + 1];

        for (int i = 1; i <= n1Len; i++) {
            for (int j = 1; j <= n2Len; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n1Len][n2Len];
    }

}
