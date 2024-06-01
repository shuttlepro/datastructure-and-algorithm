package com.shuttle.algorithm.leetcode.unclassified;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/majority-element/description">多数元素</a>
 */
public class LC_0169 {

    /**
     * 思路：利用 “同归于尽” 法
     * 时间复杂度：O(n) n 是 nums 数组的长度
     * 空间复杂度：O(1)
     *
     * @param nums 整数数组
     * @return 最多个数的元素值
     */
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // 维护当前组
        int group = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                // 没有组
                group = num;
            }
            // 不是当前组就 “同归于尽” 1 换 1
            count += group == num ? 1 : -1;
        }

        return group;
    }

}
