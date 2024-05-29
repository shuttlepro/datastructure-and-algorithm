package com.shuttle.algorithm.leetcode.unclassified;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/group-anagrams/description">字母异位词分组</a>
 */
public class LC_0049 {

    /**
     * 思路：Word 中字符 + 数量组合作为异位词唯一键进行分组
     * 时间复杂度：O(n * m) n 是字符串数组 strs 的长度，m 是数组中 word 的平均长度
     * 空间复杂度：O(n) uniqueCharCountKeyToGroupAnagramsMap 和结果列表 anagramsGroupList
     *
     * @param strs 字符串数组
     * @return 异位词分组列表
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anagramsGroupList = new ArrayList<>();

        if (strs == null || strs.length == 0) {
            return anagramsGroupList;
        }
        // <wordUniqueCharCountKey, groupAnagrams>
        Map<String, List<String>> uniqueCharCountKeyToGroupAnagramsMap = new HashMap<>();

        for (String word : strs) {
            int[] uniqueCharCounts = new int[26];
            int wordLen = word.length();
            // 统计当前 word 中每个字符出现的次数
            for (int i = 0; i < wordLen; i++) {
                uniqueCharCounts[word.charAt(i) - 'a']++;
            }
            // 将出现次数 > 0 的字符 + 次数拼接作为 HashKey
            StringBuilder uniqueCharCountKeyBuilder = new StringBuilder();

            for (int i = 0; i < 26; i++) {
                if (uniqueCharCounts[i] > 0) {
                    uniqueCharCountKeyBuilder
                            .append((char) (i + 'a'))
                            .append(uniqueCharCounts[i]);
                }
            }

            String uniqueCharCountKey = uniqueCharCountKeyBuilder.toString();
            List<String> groupAnagrams = uniqueCharCountKeyToGroupAnagramsMap.getOrDefault(uniqueCharCountKey, new ArrayList<>());
            groupAnagrams.add(word);
            uniqueCharCountKeyToGroupAnagramsMap.put(uniqueCharCountKey, groupAnagrams);
        }
        anagramsGroupList.addAll(uniqueCharCountKeyToGroupAnagramsMap.values());

        return anagramsGroupList;
    }

}
