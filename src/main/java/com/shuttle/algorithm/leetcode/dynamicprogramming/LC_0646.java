package com.shuttle.algorithm.leetcode.dynamicprogramming;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/maximum-length-of-pair-chain/description">最长数对链</a>
 */
public class LC_0646 {

    /**
     * 解法一：动态规划
     * 时间复杂度：O(n²)，忽略排序，n 为数对数组的长度
     * 空间复杂度：O(n)
     *
     * @param pairs 数对数组
     * @return 最长数对链的长度
     */
    public int findLongestChainSolution1(int[][] pairs) {
        if (pairs == null || pairs.length == 0) {
            return 0;
        }

        Arrays.sort(pairs, Comparator.comparingInt(o -> o[0]));
        int len = pairs.length;
        // dp[i] 表示前 i 个区间中最大不重合区间的个数
        int[] dp = new int[len];
        // 每一个区间都是一个不重合区间
        Arrays.fill(dp, 1);

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                // 如果当前区间的起始位置大于前一个区间的结束位置，说明这两个区间不重合
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }

    /**
     * 解法二：贪心算法
     * 时间复杂度：O(n)，忽略排序，n 为数对数组的长度
     * 空间复杂度：O(1)
     *
     * @param pairs 数对数组
     * @return 最长数对链的长度
     */
    public int findLongestChainSolution2(int[][] pairs) {
        if (pairs == null || pairs.length == 0) {
            return 0;
        }

        // 按区间的结束时间从小到大排序，优先考虑结束较早的区间
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[1]));
        int len = pairs.length;
        int res = 1;
        int right = pairs[0][1];

        for (int i = 1; i < len; i++) {
            // 如果当前区间的起始位置大于前一个区间的结束位置，说明这两个区间不重合
            if (pairs[i][0] > right) {
                res++;
                right = pairs[i][1];
            }
        }

        return res;
    }

}
