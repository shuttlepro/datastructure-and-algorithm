package com.shuttle.datastructure.leetcode.queue;

import java.util.*;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/top-k-frequent-elements/description">前 K 个高频元素</a>
 */
public class LC_0347 {

    /**
     * 思路：优先队列
     * 时间复杂度：O(n * log k)，n 是数组的长度，k 是入参
     * 空间复杂度：O(n + k)
     *
     * @param nums 整数数组
     * @param k    前 K 个
     * @return 数组中出现频率最高的 k 个元素
     */
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        // <num, frequency>
        Map<Integer, Integer> num2FrequencyMap = new HashMap<>();
        for (int num : nums) {
            num2FrequencyMap.put(num, num2FrequencyMap.getOrDefault(num, 0) + 1);
        }
        // 优先队列: [数值，频率]
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        for (Map.Entry<Integer, Integer> entry : num2FrequencyMap.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            // size 等于 k 就开始比较频率
            if (queue.size() == k) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count});
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll()[0];
        }

        return res;
    }
}
