package com.shuttle.algorithm.leetcode.dynamicprogramming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/word-break/description">单词拆分</a>
 */
public class LC_0139 {

    /**
     * 思路：动态规划
     * 时间复杂度：O(n²) n 是字符串 s 的长度
     * 空间复杂度：O(n) wordDictSet 所占用的空间
     *
     * @param s        需要拼接出的字符串
     * @param wordDict 字符串列表
     * @return 是否能拼接
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || wordDict == null || wordDict.isEmpty()) {
            return false;
        }
        // 空间换时间，HashSet 的 contains 方法时间复杂度为 O(1)
        Set<String> wordDictSet = new HashSet<>(wordDict);
        int sLen = s.length();
        // dp[i] 代表0 ~ i - 1 的字符能否在 wordDict 找到所有组成部分
        boolean[] dp = new boolean[sLen + 1];
        dp[0] = true;

        for (int i = 1; i <= sLen; i++) {
            for (int j = 0; j < i; j++) {
                // 如果 0 ~ j - 1 能拼接 && wordDictSet 存在 j ~ i - 1 的部分，则说明 0 ~ i - 1 能拼接
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[sLen];
    }

}
