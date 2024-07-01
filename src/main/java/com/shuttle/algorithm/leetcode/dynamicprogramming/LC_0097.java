package com.shuttle.algorithm.leetcode.dynamicprogramming;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/interleaving-string/description">交错字符串</a>
 */
public class LC_0097 {

    /**
     * 思路：动态规划
     * 时间复杂度：O(n * m)，n 为 s1 的长度，m 为 s2 的长度
     * 空间复杂度：O(n * m)
     *
     * @param s1 字符串 s1
     * @param s2 字符串 s2
     * @param s3 字符串 s3
     * @return 验证 s3 是否可由 s1 和 s2 交错组成
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null
                || s1.length() + s2.length() != s3.length()) {
            return false;
        }

        int s1Len = s1.length();
        int s2Len = s2.length();
        // dp[i][j] 代表 s1 的前 i 个字符与 s2 的前 j 个字符是否能组成 s3 的前 i + j 个字符
        boolean[][] dp = new boolean[s1Len + 1][s2Len + 1];
        dp[0][0] = true;

        for (int i = 0; i <= s1Len; i++) {
            for (int j = 0; j <= s2Len; j++) {
                int s3Index = i + j - 1;
                // 分别尝试 s1 和 s2，如果 s1 已经满足则 s2 可以跳过判断
                if (i > 0) {
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(s3Index);
                }
                if (j > 0 && !dp[i][j]) {
                    dp[i][j] = dp[i][j] || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(s3Index));
                }
            }
        }

        return dp[s1Len][s2Len];
    }

}
