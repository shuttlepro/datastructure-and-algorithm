package com.shuttle.algorithm.leetcode.dynamicprogramming;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/minimum-insertion-steps-to-make-a-string-palindrome/description">让字符串成为回文串的最少插入次数</a>
 */
public class LC_1312 {

    /**
     * 思路：动态规划
     * 时间复杂度：O(n²)，n 是字符串长度
     * 空间复杂度：O(n²)
     *
     * @param s 字符串 s
     * @return 让字符串 s 成为回文串的最少插入次数
     */
    public int minInsertions(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int sLen = s.length();
        // dp[i][j] 代表 s 中索引 [i, j] 区间中成为回文的最小插入次数
        int[][] dp = new int[sLen][sLen];

        for (int i = sLen - 2; i >= 0; i--) {
            // 每一个字符都是回文串，数组初始化默认 0，可以忽略
//            dp[i][i] = 0;
            for (int j = i + 1; j < sLen; j++) {
                // 当前字符相等，则不需要插入字符
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    // 当前字符不相等，则需要插入字符，两边区间取最小
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }

        return dp[0][sLen - 1];
    }

}
