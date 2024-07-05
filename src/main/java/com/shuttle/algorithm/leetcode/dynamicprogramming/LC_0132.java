package com.shuttle.algorithm.leetcode.dynamicprogramming;

import java.util.Arrays;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/palindrome-partitioning-ii/description">分割回文串 II</a>
 */
public class LC_0132 {

    /**
     * 思路：动态规划
     * 时间复杂度：O(n²)，n 是字符串 s 的长度
     * 空间复杂度：O(n²)
     *
     * @param s 字符串 s
     * @return 将 s 分割成每个子串都是回文子串的最小分割数
     */
    public int minCut(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int sLen = s.length();
        // dpPalindrome[i][j] 代表字符串索引 i ~ j 部分是否回文
        boolean[][] dpPalindrome = new boolean[sLen][sLen];
        for (int i = 0; i < sLen; i++) {
            Arrays.fill(dpPalindrome[i], true);
        }

        // 从后往前检查 i ~ j 是否回文
        for (int i = sLen - 1; i >= 0; i--) {
            for (int j = i + 1; j < sLen; j++) {
                dpPalindrome[i][j] = s.charAt(i) == s.charAt(j) && dpPalindrome[i + 1][j - 1];
            }
        }

        // dpPartitionCount[i] 代表字符串 s 的前 i 个字符的最少分割数
        int[] dpPartitionCounts = new int[sLen];
        Arrays.fill(dpPartitionCounts, Integer.MAX_VALUE);

        for (int i = 0; i < sLen; i++) {
            if (dpPalindrome[0][i]) {
                // 说明已经为 0 ~ i 已经为回文
                dpPartitionCounts[i] = 0;
            } else {
                // 否则要枚举 [1 ~ i - 1, i]
                for (int j = 0; j < i; j++) {
                    if (dpPalindrome[j + 1][i]) {
                        dpPartitionCounts[i] = Math.min(dpPartitionCounts[i], dpPartitionCounts[j] + 1);
                    }
                }
            }
        }

        return dpPartitionCounts[sLen - 1];
    }

}
