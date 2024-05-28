package com.shuttle.algorithm.leetcode.binarysearch;

import java.util.Arrays;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/split-array-largest-sum/description">分割数组的最大值</a>
 */
class LC_0410 {

    /**
     * 思路：从数组中挖掘单调性，如果设置的数组各自和的最大值很大，那么必然导致分割数很小，反之。
     * 时间复杂度：O(n * log n)
     * 空间复杂度：O(1)
     *
     * @param nums 非负整数数组
     * @param m    将非负整数数组分成 m 个非空的连续子数组
     * @return m 个非空的连续子数组中最小的最大值
     */
    public int splitArray(int[] nums, int m) {
        if (nums == null || nums.length == 0 || m <= 0) {
            return -1;
        }
        // left 和 right 分别对应 nums 的 最大值 和 总和
        int left = Arrays.stream(nums).max().orElse(0);
        int right = Arrays.stream(nums).sum();

        while (left < right) {
            int mid = left + (right - left) / 2;
            // 若满足分割条件，则继续缩小范围尝试
            if (check(nums, mid, m)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    /**
     * 检查 nums 数组在不大于指定阈值的情况下是否能被分割成 k 个连续子数组
     *
     * @param nums      待分割的数组
     * @param threshold 阈值
     * @param k         k 个连续子数组
     * @return 是否能满足分割条件
     */
    private boolean check(int[] nums, int threshold, int k) {
        int sum = 0;
        int count = 1;
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            if (sum + nums[i] > threshold) {
                count++;
                sum = nums[i];
            } else {
                sum += nums[i];
            }
        }

        return k >= count;
    }

}
