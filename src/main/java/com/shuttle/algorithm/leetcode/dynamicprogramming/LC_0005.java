package com.shuttle.algorithm.leetcode.dynamicprogramming;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/longest-palindromic-substring/description">最长回文子串</a>
 */
public class LC_0005 {

    /**
     * 思路：动态规划
     * 时间复杂度：O(n²)，n 为字符串 s 的长度
     * 空间复杂度：O(n²)
     *
     * @param s 字符串 s
     * @return s 中的最长回文子串
     */
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }

        int start = 0;
        int maxLen = 1;
        int sLen = s.length();
        // dp[i][j] 代表字符串索引 i ~ j 部分是否回文
        boolean[][] dp = new boolean[sLen][sLen];
        for (int i = 0; i < sLen; i++) {
            dp[i][i] = true;
        }
        char[] sChars = s.toCharArray();

        for (int i = sLen - 2; i >= 0; i--) {
            for (int j = i + 1; j < sLen; j++) {
                if (sChars[i] != sChars[j]) {
                    dp[i][j] = false;
                } else {
                    // 边界条件
                    if ((j - 1) - (i + 1) + 1 < 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                // 回文串成立，记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    start = i;
                }
            }
        }

        return s.substring(start, start + maxLen);
    }

}
