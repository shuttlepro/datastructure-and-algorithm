package com.shuttle.algorithm.leetcode.dynamicprogramming;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/delete-operation-for-two-strings/description">两个字符串的删除操作</a>
 */
public class LC_0583 {

    /**
     * 思路：动态规划
     * 时间复杂度：O(n * m)，n 是 word1 的长度，m 是 word2 的长度
     * 空间复杂度：O(n * m)
     *
     * @param word1 单词 1
     * @param word2 单词 2
     * @return 使得 word1 和 word2 的最长公共子序列的长度
     */
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return 0;
        }

        int w1Len = word1.length();
        int w2Len = word2.length();
        // dp[i][j] 代表 word1 的前 i 个字符和 word2 的前 j 个字符之间的最长公共子序列
        int[][] dp = new int[w1Len + 1][w2Len + 1];
        // 初始化
        for (int i = 0; i <= w1Len; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= w2Len; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= w1Len; i++) {
            for (int j = 1; j <= w2Len; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }

        return dp[w1Len][w2Len];
    }

}
