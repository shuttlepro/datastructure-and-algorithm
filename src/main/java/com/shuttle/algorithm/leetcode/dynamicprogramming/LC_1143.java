package com.shuttle.algorithm.leetcode.dynamicprogramming;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/longest-common-subsequence/description">最长公共子序列</a>
 */
public class LC_1143 {

    /**
     * 思路：动态规划
     * 时间复杂度：O(n * m)，n 是 text1 的长度，m 是 text2 的长度
     * 空间复杂度：O(n * m)
     *
     * @param text1 字符串 1
     * @param text2 字符串 2
     * @return 最长公共子序列长度
     */
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null || text1.isEmpty() || text2.isEmpty()) {
            return 0;
        }

        int t1Len = text1.length();
        int t2Len = text2.length();
        // dp[i][j] 代表 text1 的前 i 个字符和 text2 的前 j 个字符之间的最长公共子序列
        int[][] dp = new int[t1Len + 1][t2Len + 1];

        for (int i = 1; i <= t1Len; i++) {
            for (int j = 1; j <= t2Len; j++) {
                // 如果两个字符相等，则最长公共子序列长度 + 1
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 如果两个字符不相等，则最长公共子序列长度取其左和上两个字符的最长公共子序列长度的较大值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[t1Len][t2Len];
    }

}
