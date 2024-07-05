package com.shuttle.algorithm.leetcode.dynamicprogramming;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/longest-palindromic-subsequence/description">最长回文子序列</a>
 */
public class LC_0516 {

    /**
     * 思路：动态规划
     * 时间复杂度：O(n²)，n 是字符串 s 的长度
     * 空间复杂度：O(n²)
     *
     * @param s 字符串 s
     * @return 最长回文子序列长度
     */
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int sLen = s.length();
        // dp[i][j] 代表字符串 s 的索引 [i, j] 区间的最长回文子序列
        int[][] dp = new int[sLen][sLen];

        for (int i = sLen - 1; i >= 0; i--) {
            // 每一个字符都是回文子序列
            dp[i][i] = 1;
            for (int j = i + 1; j < sLen; j++) {
                // 如果 i 和 j 位置上字符相等说明可以继承 dp[i - 1][j - 1]
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    // 否则从 [i, j - 1] 和 [i + 1, j] 两个区间中找最大
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }

        return dp[0][sLen - 1];
    }

}
