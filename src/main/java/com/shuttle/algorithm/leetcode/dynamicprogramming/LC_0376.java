package com.shuttle.algorithm.leetcode.dynamicprogramming;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/wiggle-subsequence/description">摆动序列</a>
 */
public class LC_0376 {

    /**
     * 解法一：动态规划
     * 时间复杂度：O(n)，n 是 nums 数组的长度
     * 空间复杂度：O(n)
     *
     * @param nums 整数数组
     * @return 为摆动序列的最长子序列的长度
     */
    public int wiggleMaxLengthSolution1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        // up[i] 代表以 nums[i] 结尾最长的上升摆动序列
        // down[i] 代表以 nums[i] 结尾最长的下降摆动序列
        int[] up = new int[len];
        int[] down = new int[len];
        up[0] = 1;
        down[0] = 1;

        for (int i = 1; i < len; i++) {
            // 如果当前数字大于前一个数字，则当前数字可以构成上升摆动序列，则当前上升摆动序列长度为前一个上升摆动序列长度 + 1
            if (nums[i] > nums[i - 1]) {
                up[i] = Math.max(up[i - 1], down[i - 1] + 1);
                down[i] = down[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                // 如果当前数字小于前一个数字，则当前数字可以构成下降摆动序列，则当前下降摆动序列长度为前一个下降摆动序列长度 + 1
                down[i] = Math.max(down[i - 1], up[i - 1] + 1);
                up[i] = up[i - 1];
            } else {
                // 相等则不变
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            }
        }

        // 返回最长的摆动子序列
        return Math.max(up[len - 1], down[len - 1]);
    }

    /**
     * 解法二：滚动数组，在解法一的基础上进行空间优化
     * 时间复杂度：O(n)，n 是 nums 数组的长度
     * 空间复杂度：O(1)
     *
     * @param nums 整数数组
     * @return 为摆动序列的最长子序列的长度
     */
    public int wiggleMaxLengthSolution2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int maxUpLen = 1;
        int maxDownLen = 1;
        int preMaxUpLen = maxDownLen;
        int preMaxDownLen = maxDownLen;

        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) {
                maxUpLen = Math.max(preMaxUpLen, preMaxDownLen + 1);
                preMaxUpLen = maxUpLen;
            } else if (nums[i] < nums[i - 1]) {
                maxDownLen = Math.max(preMaxDownLen, preMaxUpLen + 1);
                preMaxDownLen = maxDownLen;
            }
        }

        return Math.max(maxUpLen, maxDownLen);
    }

    /**
     * 解法三：贪心算法
     * 时间复杂度：O(n)，n 是 nums 数组的长度
     * 空间复杂度：O(1)
     *
     * @param nums 整数数组
     * @return 为摆动序列的最长子序列的长度
     */
    public int wiggleMaxLengthSolution3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        // 记录前一个差值和当前差值
        int preDiff = 0;
        int curDiff = 0;
        int count = 1;

        for (int i = 1; i < len; i++) {
            curDiff = nums[i] - nums[i - 1];
            // 如果【当前差值大于 0 且 前一个差值小于等于 0】 或【相反的情况】就说明是摆动子序列
            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
                count++;
                preDiff = curDiff;
            }
        }

        return count;
    }

}
