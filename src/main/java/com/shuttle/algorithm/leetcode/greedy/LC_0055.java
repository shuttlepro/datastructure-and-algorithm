package com.shuttle.algorithm.leetcode.greedy;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/jump-game/description">跳跃游戏</a>
 */
public class LC_0055 {

    /**
     * 思路：贪心算法
     * 时间复杂度：O(n)，n 为数组长度
     * 空间复杂度：O(1)
     *
     * @param nums 由跳跃长度组成的整数数组
     * @return 能否跳过所有位置
     */
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        // 维护当前能跳的最远距离
        int maxDistance = 0;
        int numsLen = nums.length;

        for (int i = 0; i < numsLen; i++) {
            // 如果当前位置能跳的最远距离大于等于当前位置，更新当前能跳的最远距离
            if (i <= maxDistance) {
                maxDistance = Math.max(maxDistance, i + nums[i]);
            }
            // 如果最远能跳的距离已经覆盖了最后一个位置，提前返回 true
            if (maxDistance >= numsLen - 1) {
                return true;
            }
        }

        return false;
    }

}
