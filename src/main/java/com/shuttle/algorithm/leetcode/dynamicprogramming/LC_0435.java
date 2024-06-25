package com.shuttle.algorithm.leetcode.dynamicprogramming;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/non-overlapping-intervals/description">无重叠区间</a>
 */
public class LC_0435 {

    /**
     * 解法一：动态规划
     * 时间复杂度：O(n²)，忽略排序，n 为区间数组的长度
     * 空间复杂度：O(n)
     *
     * @param intervals 区间数组
     * @return 在剩余区间互不重叠的情况下需要移除区间的最小数量
     */
    public int eraseOverlapIntervalsSolution1(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int len = intervals.length;
        // dp[i] 表示前 i 个区间中最大不重合区间的个数
        int[] dp = new int[len];
        // 每一个区间都是一个不重合区间
        Arrays.fill(dp, 1);

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                // 如果当前区间的起始位置大于等于前一个区间的结束位置，说明这两个区间不重合
                if (intervals[i][0] >= intervals[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // 找到 dp 数组中的最大值，即为在所有可能的选择中，能保留的最多不重合区间数
        int max = Arrays.stream(dp).max().getAsInt();

        return len - max;
    }

    /**
     * 解法二：贪心算法
     * 时间复杂度：O(n)，忽略排序，n 为区间数组的长度
     * 空间复杂度：O(1)
     *
     * @param intervals 区间数组
     * @return 在剩余区间互不重叠的情况下需要移除区间的最小数量
     */
    public int eraseOverlapIntervalsSolution2(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        // 按区间的结束时间从小到大排序，优先考虑结束较早的区间
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int len = intervals.length;
        int res = 1;
        int right = intervals[0][1];

        for (int i = 1; i < len; i++) {
            // 如果当前区间的起始位置大于等于前一个区间的结束位置，说明这两个区间不重合
            if (intervals[i][0] >= right) {
                res++;
                right = intervals[i][1];
            }
        }

        return len - res;
    }

}
