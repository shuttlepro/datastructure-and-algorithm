package com.shuttle.algorithm.leetcode.unclassified;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/single-number/description">只出现一次的数字</a>
 */
public class LC_0136 {

    /**
     * 解法一：HashMap
     * 思路：利用 HashMap 存储 nums 中所有不同整数出现的次数，找出 count == 1 即可
     *
     * @param nums 整数数组 nums
     * @return nums 中只出现一次的整数
     */
    public int singleNumberSolution1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Map<Integer, Integer> numToCountMap = new HashMap<>();

        for (int num : nums) {
            numToCountMap.put(num, numToCountMap.getOrDefault(num, 0) + 1);
        }
        Set<Map.Entry<Integer, Integer>> numToCountMapEntries = numToCountMap.entrySet();

        for (Map.Entry<Integer, Integer> entry : numToCountMapEntries) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return -1;
    }

    /**
     * 解法二：流式编程
     * 思路：遍历 nums 数组时相邻元素进行异或运算，相同的值结果为 1，最后剩下 SingleNum
     *
     * @param nums 整数数组 nums
     * @return nums 中只出现一次的整数
     */
    public int singleNumberSolution2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst().orElse(-1);
    }

    /**
     * 解法三：异或运算
     * 思路：遍历 nums 数组时相邻元素进行异或运算，相同的值结果为 1，最后剩下 SingleNum
     *
     * @param nums 整数数组 nums
     * @return nums 中只出现一次的整数
     */
    public int singleNumberSolution3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int singleNum = 0;

        for (int num : nums) {
            singleNum ^= num;
        }

        return singleNum;
    }

}
