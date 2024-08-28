package com.shuttle.algorithm.leetcode.slidingwindow;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/minimum-size-subarray-sum/description">长度最小的子数组</a>
 */
public class LC_0209 {

    /**
     * 思路：滑动窗口
     * 时间复杂度：O(n)，n 是数组长度
     * 空间复杂度：O(1)
     *
     * @param target 目标正整数
     * @param nums   正整数数组
     * @return 返回数组 nums 中最短的子数组，其元素总和大于等于 target 的长度，如果不存在则返回 0
     */
    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int res = Integer.MAX_VALUE;
        // 最小连续数组的开始和结束位置
        int start = 0;
        int end = 0;
        // 记录当前总和
        int sum = 0;

        while (end < len) {
            sum += nums[end];
            // 如果当前总和超过了 target，就尝试向右滑动
            while (sum >= target) {
                res = Math.min(res, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
