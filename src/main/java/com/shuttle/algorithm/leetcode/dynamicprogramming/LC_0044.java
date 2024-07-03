package com.shuttle.algorithm.leetcode.dynamicprogramming;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/wildcard-matching/description">通配符匹配</a>
 */
public class LC_0044 {

    /**
     * 思路：动态规划
     * 时间复杂度：O(n * m)，n 是 s 的长度，m 是 p 的长度
     * 空间复杂度：O(n * m)
     *
     * @param s 字符串 s
     * @param p 字符模式串 p
     * @return s 是否能被 p 匹配
     */
    public boolean isMatch(String s, String p) {
        if (s == null || p == null || (!s.isEmpty() && p.isEmpty())) {
            return false;
        }

        char[] sCharArray = s.toCharArray();
        char[] pCharArray = p.toCharArray();
        int sLen = s.length();
        int pLen = p.length();

        // dp[i][j] 表示 s 的前 i 个字符能否被 p 的前 j 个字符匹配
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true;
        // 当 s == "" 初始化 dp，模式串后缀为 * 都能匹配上空串
        for (int i = 1; i <= pLen; i++) {
            if (pCharArray[i - 1] == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }

        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                // 当前字符匹配或模式字符为 ?
                if (sCharArray[i - 1] == pCharArray[j - 1] || pCharArray[j - 1] == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pCharArray[j - 1] == '*') {
                    // * 匹配 0 次 || N 次
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }

        return dp[sLen][pLen];
    }

}
