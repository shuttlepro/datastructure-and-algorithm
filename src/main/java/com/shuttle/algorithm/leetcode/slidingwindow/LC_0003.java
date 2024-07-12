package com.shuttle.algorithm.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/description">无重复字符的最长子串</a>
 */
public class LC_0003 {

    /**
     * 思路：滑动窗口
     * 时间复杂度：O(n)，n 是字符串长度
     * 空间复杂度：O(1)，取决于不同字符的数量，常数级别
     *
     * @param s 字符串
     * @return 最长不重复字符子串的长度
     */
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int len = s.length();
        // <字符，字符位置 + 1>
        Map<Character, Integer> map = new HashMap<>();
        // 不重复子串的开始位置
        int start = 0;

        for (int end = 0; end < len; end++) {
            char ch = s.charAt(end);
            if (map.containsKey(ch)) {
                // 包含当前字符的话就得更新下开始位置 有 abca 和 abba 这两种情况
                start = Math.max(start, map.get(ch) + 1);
            }
            map.put(ch, end);
            // 更新最长不重复子串的长度
            res = Math.max(res, end - start + 1);
        }

        return res;
    }

}
