package com.shuttle.algorithm.leetcode.dynamicprogramming;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/decode-ways/description">解码方法</a>
 */
public class LC_0091 {

    /**
     * 解法一：动态规划
     * 时间复杂度：O(n)，n 是字符串 s 的长度
     * 空间复杂度：O(n)
     *
     * @param s 消息体
     * @return 解码后的总数
     */
    public int numDecodingsSolution1(String s) {
        int sLen = s.length();
        if (sLen == 0) {
            return 0;
        }
        // dp[i] 代表以 s[i] 结尾的前缀子串有多少种解法
        int[] dp = new int[sLen];
        char[] sChars = s.toCharArray();
        if (sChars[0] == '0') {
            return 0;
        }
        dp[0] = 1;

        for (int i = 1; i < sLen; i++) {
            // 如果当前字符不是 '0'，则它可以单独解码
            if (sChars[i] != '0') {
                dp[i] = dp[i - 1];
            }
            // 计算当前字符和前一个字符组成的两位数
            int num = (sChars[i - 1] - '0') * 10 + (sChars[i] - '0');
            // 如果这个两位数在 10 到 26 之间，它可以作为一个有效的解码
            if (num >= 10 && num <= 26) {
                // 第一位加 1，后续加上 dp[i - 2]
                if (i == 1) {
                    dp[i]++;
                } else {
                    dp[i] += dp[i - 2];
                }
            }
        }

        return dp[sLen - 1];
    }

    /**
     * 解法二：滚动数组
     * 时间复杂度：O(n)，n 是字符串 s 的长度
     * 空间复杂度：O(1)
     *
     * @param s 消息体
     * @return 解码后的总数
     */
    public int numDecodingsSolution2(String s) {
        if (s == null || s.isEmpty() || s.charAt(0) == '0') {
            return 0;
        }
        int sLen = s.length();
        char[] sChars = s.toCharArray();
        // count => dp[i], temp1 => dp[i - 1], temp2 => dp[i - 2]
        int count = 0;
        int temp1 = 1;
        int temp2 = 0;

        for (int i = 1; i <= sLen; i++) {
            count = 0;
            // 如果当前字符不是 '0'，它可以单独解码
            if (sChars[i - 1] != '0') {
                count = temp1;
            }
            // 前一个字符不是 '0'
            if (i > 1 && sChars[i - 2] != '0') {
                // 计算前一个字符和当前字符组成的两位数
                int num = (sChars[i - 2] - '0') * 10 + (sChars[i - 1] - '0');
                // 如果这个两位数在 10 到 26 之间，可以作为一个有效的解码
                if (num >= 10 && num <= 26) {
                    count += temp2;
                }
            }
            // 更新解码数临时变量
            temp2 = temp1;
            temp1 = count;
        }

        return count;
    }

}
