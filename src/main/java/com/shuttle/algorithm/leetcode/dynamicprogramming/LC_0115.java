package com.shuttle.algorithm.leetcode.dynamicprogramming;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/distinct-subsequences/description">不同的子序列</a>
 */
public class LC_0115 {

    /**
     * 思路：动态规划
     * 时间复杂度：O(n * m)，n 是 s 的长度，m 是 t 的长度
     * 空间复杂度：O(n * m)
     *
     * @param s 字符串 s
     * @param t 字符串 t
     * @return 在 s 的子序列中 t 出现的次数
     */
    public int numDistinct(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return 0;
        }

        int sLen = s.length();
        int tLen = t.length();
        // dp[i][j] 表示在 s 的前 i 个字符中，t 的前 j 个字符出现的次数
        int[][] dp = new int[sLen + 1][tLen + 1];
        // 空串是任何字符串的子串
        for (int i = 0; i <= sLen; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= tLen; j++) {
                if (j > i) {
                    break;
                }
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // 如果 s 和 t 的当前字符相等，则可以选择匹配或不匹配当前字符
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    // 如果 s 和 t 的当前字符不相等，则不匹配当前字符
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[sLen][tLen];
    }

}
