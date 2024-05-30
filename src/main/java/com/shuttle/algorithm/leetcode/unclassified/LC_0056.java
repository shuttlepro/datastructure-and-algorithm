package com.shuttle.algorithm.leetcode.unclassified;

import java.util.Arrays;
import java.util.BitSet;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/merge-intervals/description">合并区间</a>
 */
public class LC_0056 {

    /**
     * 解法一：排序后遍历比较
     * 时间复杂度：O(n * log n) 排序 + 遍历，n 是 intervals 中区间数量
     * 空间复杂度：O(n) mergeResult
     *
     * @param intervals 若干个区间的集合
     * @return 合并后的区间集合
     */
    public int[][] mergeSolution1(int[][] intervals) {
        if (intervals == null || intervals[0].length == 0) {
            return new int[][]{};
        }
        int[][] mergeResult = new int[intervals.length][2];

        // 先按区间起始位置排序
        Arrays.sort(intervals, (interval1, interval2) -> interval1[0] - interval2[0]);
        int curIndex = -1;

        for (int[] interval : intervals) {
            // 如果结果数组为空 | 当前区间的起始位置大于结果数组最后区间的终止位置，说明需要插在数组尾部
            if (curIndex == -1 || interval[0] > mergeResult[curIndex][1]) {
                mergeResult[++curIndex] = interval;
            } else {
                // 当前区间的起始位置小于结果数组最后区间的终止位置，说明需要进行比较 + 合并
                mergeResult[curIndex][1] = Math.max(mergeResult[curIndex][1], interval[1]);
            }
        }

        return Arrays.copyOf(mergeResult, curIndex + 1);
    }

    /**
     * 解法二：利用数据结构 BitSet
     * 时间复杂度：O(n) n 是 intervals 中区间数量
     * 空间复杂度：O(n + maxRange) n 是 intervals 区间集合并后的结果数组，maxRange 代表 intervals 中最大数 * 2 + 1
     *
     * @param intervals 若干个区间的集合
     * @return 合并后的区间集合
     */
    public int[][] mergeSolution2(int[][] intervals) {
        if (intervals == null || intervals[0].length == 0) {
            return new int[][]{};
        }
        // 将所有结果摊开，想象 bitSet 为一根 0 和 1 组成的数轴
        BitSet bitSet = new BitSet();
        // 记录数轴的终点
        int terminal = 0;
        int intervalsLen = intervals.length;

        for (int i = 0; i < intervalsLen; i++) {
            // 需要 * 2 是防止 [1, 2] [3, 4] 这样的两个连续区间会合并
            int startIndex = intervals[i][0] * 2;
            // endIndex 除了 * 2 还需要 +1，因为出现 [3, 3] 这样的区间可能会导致 nextSetBit(startIndex) 方法返回 -1，最终导致 nextClearBit(startVal) 方法越界
            int endIndex = intervals[i][1] * 2 + 1;
            terminal = Math.max(terminal, endIndex);
            // set(int fromIndex, int toIndex, boolean value) 是将 bitSet 的 [fromIndex, toIndex) 范围内的位置为 1
            bitSet.set(startIndex, endIndex, true);
        }
        // 这里假设入参 intervals = [[1, 2], [2, 3], [4, 5]]，循环执行完 bitSet -> 00111110111，terminal -> 11

        int intervalCount = 0;
        int curIndex = 0;

        while (curIndex < terminal) {
            // nextSetBit(int fromIndex) 是获取从 fromIndex 开始，bitSet 中第一个 bit 位 val = 1 的索引值
            // nextClearBit(int fromIndex) 是获取从 fromIndex 开始，bitSet 中第一个 bit 位 val = 0 的索引值
            // bitSet -> 00111110111 第一轮 startIndex = 2, endIndex = 7; 第二轮 startIndex = 8, endIndex = 11
            int startIndex = bitSet.nextSetBit(curIndex);
            int endIndex = bitSet.nextClearBit(startIndex);
            intervals[intervalCount++] = new int[]{startIndex / 2, (endIndex - 1) / 2};
            curIndex = endIndex;
        }

        int[][] mergeResult = new int[intervalCount][2];

        for (int i = 0; i < intervalCount; i++) {
            mergeResult[i] = intervals[i];
        }

        return mergeResult;
    }

}
