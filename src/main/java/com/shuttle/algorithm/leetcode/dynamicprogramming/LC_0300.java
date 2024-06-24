package com.shuttle.algorithm.leetcode.dynamicprogramming;

import java.util.Arrays;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/longest-increasing-subsequence/description">最长递增子序列</a>
 */
public class LC_0300 {

    /**
     * 解法一：动态规划
     * 时间复杂度：O(n²)，n 是 nums 数组的长度
     * 空间复杂度：O(n)
     *
     * @param nums 整数数组
     * @return 数组中严格递增子序列的长度
     */
    public int lengthOfLISSolution1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        // dp[i] 表示：以 nums[i] 结尾 的 上升子序列 的长度。
        int[] dp = new int[len];
        // 初始化，每个字符至少都是1个长度
        Arrays.fill(dp, 1);

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    // 如果一个较大的数接在较小的数后面，就会形成一个更长的子序列。
                    // 只要 nums[i] 严格大于在它位置之前的某个数，
                    // 那么 nums[i] 就可以接在这个数后面形成一个更长的上升子序列。
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }

    /**
     * 解法二：二分查找
     * 时间复杂度：O(n * log n)，n 是 nums 数组的长度
     * 空间复杂度：O(n)
     *
     * @param nums 整数数组
     * @return 数组中严格递增子序列的长度
     */
    public int lengthOfLISSolution2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // tail[i] 代表长度为 i + 1 递增子序列最小尾部值
        // 例：[1, 6, 4] tail[0] = 1, tail[1] = 4
        // tails 一定是严格递增的
        int[] tails = new int[nums.length];
        int res = 0;

        for (int num : nums) {
            int i = 0;
            int j = res;
            while (i < j) {
                int mid = (i + j) / 2;
                if (tails[mid] < num) {
                    i = mid + 1;
                } else {
                    j = mid;
                }
            }
            tails[i] = num;
            // 不满足 res == j 说明 tail 数组里只有部分比 num 小，否则都比 num 小
            if (res == j) {
                res++;
            }
        }

        return res;
    }

}
