package com.shuttle.algorithm.leetcode.unclassified;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/longest-mountain-in-array/description">数组中的最长山脉</a>
 */
public class LC_0845 {

    /**
     * 思路：枚举，定位山脉起点
     * 时间复杂度：O(n)，n 为山脉数组的长度
     * 空间复杂度：O(1)
     *
     * @param arr 山脉数组
     * @return 最长山脉子数组的长度
     */
    public int longestMountain(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int res = 0;
        // 山脉起点
        int start = -1;
        int length = arr.length;

        for (int i = 1; i < length; i++) {
            if (arr[i] > arr[i - 1]) {
                // 在上升阶段，确定山脉起点
                if (i == 1 || arr[i - 2] >= arr[i - 1]) {
                    start = i - 1;
                }
            } else if (arr[i] < arr[i - 1]) {
                if (start != -1) {
                    // 在下降阶段需要不断更新最长山脉长度
                    res = Math.max(res, i - start + 1);
                }
            } else {
                // 平缓期
                start = -1;
            }
        }

        return res;
    }

}
