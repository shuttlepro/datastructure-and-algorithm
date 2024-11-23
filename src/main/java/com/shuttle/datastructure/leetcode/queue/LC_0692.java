package com.shuttle.datastructure.leetcode.queue;

import java.util.*;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/top-k-frequent-words/description">前K个高频单词</a>
 */
public class LC_0692 {

    /**
     * 思路：优先队列
     * 时间复杂度：O(n * log k)，n 是单词数量，k 是入参
     * 空间复杂度：O(n + k)
     *
     * @param words 单词列表
     * @param k     前 k 个
     * @return 前 k 个高频单词
     */
    public List<String> topKFrequent(String[] words, int k) {
        if (words == null || words.length == 0 || k <= 0) {
            return new ArrayList<>();
        }

        // <word, count>
        Map<String, Integer> wordCountMap = new HashMap<>();
        for (String num : words) {
            wordCountMap.put(num, wordCountMap.getOrDefault(num, 0) + 1);
        }

        // 优先队列: 按 wordCount 升序，相同则按字典序降序
        Queue<String> queue = new PriorityQueue<>(
                (o1, o2) -> wordCountMap.get(o1).equals(wordCountMap.get(o2)) ? o2.compareTo(o1) : wordCountMap.get(o1) - wordCountMap.get(o2));

        for (String str : wordCountMap.keySet()) {
            queue.offer(str);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        List<String> res = new ArrayList<>(k);
        while (!queue.isEmpty()) {
            res.add(queue.poll());
        }
        Collections.reverse(res);

        return res;
    }
}
