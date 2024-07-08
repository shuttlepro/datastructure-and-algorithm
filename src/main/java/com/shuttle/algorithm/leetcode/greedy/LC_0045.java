package com.shuttle.algorithm.leetcode.greedy;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/jump-game-ii/description">跳跃游戏 II</a>
 */
public class LC_0045 {

    /**
     * 思路：贪心算法
     * 时间复杂度：O(n)，n 为数组长度
     * 空间复杂度：O(1)
     *
     * @param nums 由跳跃长度组成的整数数组
     * @return 能否跳过所有位置
     */
    public int jump(int[] nums) {
        // 从当前位置能跳的最远位置
        int maxDistance = 0;
        // 当次跳跃的最远右边界
        int rightBoundary = 0;
        // 需要跳到的最终距离
        int distance = nums.length - 1;
        int count = 0;

        for (int i = 0; i < distance; i++) {
            maxDistance = Math.max(maxDistance, i + nums[i]);
            // 如果已经到了右边界就更新为最远位置
            if (i == rightBoundary) {
                rightBoundary = maxDistance;
                count++;
            }
        }

        return count;
    }

}
