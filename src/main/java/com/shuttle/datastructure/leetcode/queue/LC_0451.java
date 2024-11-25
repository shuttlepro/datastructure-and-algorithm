package com.shuttle.datastructure.leetcode.queue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/sort-characters-by-frequency/description">根据字符出现频率排序</a>
 */
public class LC_0451 {

    /**
     * 思路：优先队列
     * 时间复杂度：O(n * log n)，n 是 s 的长度
     * 空间复杂度：O(n)
     *
     * @param s 给定的字符串
     * @return 根据字符出现的频率降序排序后的字符串
     */
    public String frequencySort(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        char[] sChars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : sChars) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // 优先队列 [字符，频率]，频率一样就比较字符
        Queue<int[]> charFrequencyQueue = new PriorityQueue<>((o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o2[1] - o1[1]);
        for (Character ch : map.keySet()) {
            charFrequencyQueue.add(new int[]{ch, map.get(ch)});
        }

        StringBuilder originalString = new StringBuilder();
        while (!charFrequencyQueue.isEmpty()) {
            int[] poll = charFrequencyQueue.poll();
            // 还原字符串
            int ch = poll[0];
            int count = poll[1];

            while (count > 0) {
                count--;
                originalString.append((char) (ch));
            }
        }

        return originalString.toString();
    }
}
