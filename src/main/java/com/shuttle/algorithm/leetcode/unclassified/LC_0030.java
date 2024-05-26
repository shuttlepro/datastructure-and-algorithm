package com.shuttle.algorithm.leetcode.unclassified;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/substring-with-concatenation-of-all-words">串联所有单词的子串</a>
 */
public class LC_0030 {

    /**
     * 思路：遍历的同时利用额外的 word -> count 映射表进行对比
     * 时间复杂度：O(n * m)，n 是字符串 s 的长度，m 是 words 数组的长度
     * 空间复杂度：O(n)，wordCountMap 和 tempWordCountMap
     *
     * @param s 字符串
     * @param words 字符串数组
     * @return 所有串联子串在字符串 s 中的索引集合
     */
    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || words == null || words.length == 0) {
            return null;
        }
        List<Integer> substrings = new ArrayList<>();
        int sLen = s.length();
        int wordsLen = words.length;
        int singleWordLen = words[0].length();
        // [word, count]
        Map<String, Integer> wordCountMap = new HashMap<>();
        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i + wordsLen * singleWordLen <= sLen; i++) {
            // 字符串 s 在 [i, i + wordsLen * singleWordLen) 范围里的 [word, count]
            Map<String, Integer> tempWordCountMap = new HashMap<>();
            String sub = s.substring(i, i + wordsLen * singleWordLen);
            int subLen = sub.length();

            for (int j = 0; j < subLen; j += singleWordLen) {
                String word = sub.substring(j, j + singleWordLen);
                if (!wordCountMap.containsKey(word)) {
                    break;
                }
                tempWordCountMap.put(word, tempWordCountMap.getOrDefault(word, 0) + 1);
            }
            if (tempWordCountMap.equals(wordCountMap)) {
                substrings.add(i);
            }
        }

        return substrings;
    }

}
