package com.shuttle.algorithm.leetcode.dynamicprogramming;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/regular-expression-matching/description">正则表达式匹配</a>
 */
public class LC_0010 {

    /**
     * 思路：动态规划
     * 时间复杂度：O(n * m)，n 是 s 的长度，m 是 p 的长度
     * 空间复杂度：O(n * m)
     *
     * @param s 字符串 s
     * @param p 字符规律 p
     * @return s 是否能被 p 匹配
     */
    public boolean isMatch(String s, String p) {
        if (s == null || p == null || s.isEmpty() || p.isEmpty()) {
            return false;
        }

        char[] sCharArray = s.toCharArray();
        char[] pCharArray = p.toCharArray();
        int sLen = s.length();
        int pLen = p.length();
        // dp[i][j] 表示 s 的前 i 个字符能否被 p 的前 j 个字符匹配
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true;

        // 处理 p 以 * 结尾的特殊情况，s 可为空或忽略前导 *
        for (int i = 2; i <= pLen; i++) {
            if (pCharArray[i - 1] == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }

        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                // 文本串和模式串末位字符能匹配上
                if (sCharArray[i - 1] == pCharArray[j - 1] || pCharArray[j - 1] == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pCharArray[j - 1] == '*') {
                    // 检测模式串 * 的前一个字符是否能跟文本串的末位匹配上
                    if ((pCharArray[j - 2] == sCharArray[i - 1]) || pCharArray[j - 2] == '.') {
                        dp[i][j] = dp[i][j - 2] // * 匹配 0 次
                                || dp[i - 1][j]; // * 匹配 1 次或 N 次
                    } else {
                        // * 只能匹配 0 次
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }

        return dp[sLen][pLen];
    }

}
