package com.shuttle.algorithm.leetcode.dynamicprogramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/longest-string-chain/description">最长字符串链</a>
 */
public class LC_1048 {

    /**
     * 思路：动态规划
     * 时间复杂度：O(n × m × (log n + m))，n 是 words 数组的长度，m 是单词的平均长度
     * 空间复杂度：O(n × m)
     *
     * @param words 单词数组
     * @return 最长字符串链长度
     */
    public int longestStrChain(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }

        Arrays.sort(words, Comparator.comparingInt(String::length));
        // <当前单词, 当前单词前部分子序列最大长度>
        Map<String, Integer> map = new HashMap<>();
        int res = 0;

        for (String word : words) {
            int temp = 0;
            int wordLen = word.length();

            for (int i = 0; i < wordLen; i++) {
                // 将当前单词依次移除一个字符进行查表
                String pre = word.substring(0, i) + word.substring(i + 1);
                temp = Math.max(temp, map.getOrDefault(pre, 0) + 1);
            }

            map.put(word, temp);
            res = Math.max(res, temp);
        }

        return res;
    }

}
