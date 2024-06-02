package com.shuttle.algorithm.leetcode.unclassified;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/subarray-sum-equals-k/description">和为 K 的子数组</a>
 */
public class LC_0560 {

    /**
     * 思路：利用 HashMap 存储前缀和
     * 时间复杂度：O(n)，n 是 nums 数组的长度
     * 空间复杂度：O(n)，prefixSumMap 存储所有前缀和与出现次数的映射
     *
     * @param nums 整数数组
     * @param k 需要在数组中找的和
     * @return 数组中连续子数组和为 k 的个数
     */
    public int subarraySum(int[] nums, int k) {
        int subarrayCount = 0;
        if (nums == null || nums.length == 0) {
            return subarrayCount;
        }
        int prefixSum = 0;
        // [前缀和, 次数]
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        // 防止 index [0 ~ numsLen] 和为 k
        prefixSumMap.put(0, 1);

        for (int num : nums) {
            prefixSum += num;
            if (prefixSumMap.containsKey(prefixSum - k)) {
                subarrayCount += prefixSumMap.get(prefixSum - k);
            }
            prefixSumMap.put(prefixSum, prefixSumMap.getOrDefault(prefixSum, 0) + 1);
        }

        return subarrayCount;
    }

}
