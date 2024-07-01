package com.shuttle.algorithm.leetcode.dynamicprogramming;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/edit-distance/description">编辑距离</a>
 */
public class LC_0072 {

    /**
     * 思路：动态规划
     * 时间复杂度：O(n * m)，n 是 word1 的长度，m 是 word2 的长度
     * 空间复杂度：O(n * m)
     *
     * @param word1 单词 1
     * @param word2 单词 2
     * @return 将 word1 转换成 word2 所使用的最少操作数
     */
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return 0;
        }
        int w1Len = word1.length();
        int w2Len = word2.length();
        if (w1Len == 0 || w2Len == 0) {
            return w1Len == 0 ? w2Len : w1Len;
        }
        // dp[i][j] 表示 word1 的前 i 个字符和 word2 的前 j 个字符之间的最少操作数
        int[][] dp = new int[w1Len + 1][w2Len + 1];
        // 初始化 dp
        for (int i = 0; i <= w1Len; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= w2Len; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= w1Len; i++) {
            for (int j = 1; j <= w2Len; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // 相等说明不需要变
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 不相等说明需要修改或插入一个元素
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }

        return dp[w1Len][w2Len];
    }

}
