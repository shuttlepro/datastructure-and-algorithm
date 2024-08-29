package com.shuttle.algorithm.leetcode.slidingwindow;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/maximum-length-of-repeated-subarray/description">最长重复子数组</a>
 */
public class LC_0718 {

    /**
     * 思路：滑动窗口
     * 时间复杂度：O(n * m)，n 是 nums1 的长度，m 是 nums2 的长度
     * 空间复杂度：O(1)
     *
     * @param nums1 整数数组 1
     * @param nums2 整数数组 2
     * @return 最长重复子数组长度
     */
    public int findLength(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return 0;
        }

        return nums1.length >= nums2.length ? getMaxSequence(nums1, nums2) : getMaxSequence(nums2, nums1);
    }

    /**
     * 寻找最长重复子数组长度，nums1 的长度需要大于 nums2，nums2 不动，nums1 向右滑
     *
     * @param nums1 数组 1
     * @param nums2 数组 2
     * @return 最长重复子数组长度
     */
    private int getMaxSequence(int[] nums1, int[] nums2) {
        int n1Len = nums1.length;
        int n2Len = nums2.length;
        int maxLen = Integer.MIN_VALUE;

        // 第一部分，刚重合到完全重合
        for (int i = 1; i < n2Len; i++) {
            maxLen = Math.max(maxLen, getMaxLen(nums1, n1Len - i, nums2, 0, i));
        }
        // 第二部分，完全重合到开始滑出
        for (int i = n1Len - n2Len; i >= 0; i--) {
            maxLen = Math.max(maxLen, getMaxLen(nums1, i, nums2, 0, n2Len));
        }
        // 第三部分，开始滑出到完全滑出
        for (int i = 1; i < n2Len; i++) {
            maxLen = Math.max(maxLen, getMaxLen(nums1, 0, nums2, i, n2Len - i));
        }

        return maxLen;
    }

    /**
     * 从 nums1 的 n1Index 处和 nums2 的 n2Index 处后的长度找最长连续子数组
     *
     * @param nums1   数组 1
     * @param n1Index 数组 1 的索引起始处
     * @param nums2   数组 2
     * @param n2Index 数组 2 的索引起始处
     * @param len 寻找长度
     * @return 最长连续子数组
     */
    private int getMaxLen(int[] nums1, int n1Index, int[] nums2, int n2Index, int len) {
        int count = 0;
        int maxLen = 0;

        for (int i = 0; i < len; i++) {
            if (nums1[n1Index + i] == nums2[n2Index + i]) {
                count++;
            } else if (count > 0) {
                maxLen = Math.max(maxLen, count);
                count = 0;
            }
        }

        // count 计数的最后一次可能没进入 else if 块
        if (count > 0) {
            maxLen = Math.max(maxLen, count);
        }

        return maxLen;
    }

}
