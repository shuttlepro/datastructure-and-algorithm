package com.shuttle.algorithm.leetcode.unclassified;

import java.util.Arrays;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/array-partition/description">数组拆分</a>
 */
public class LC_0561 {

    /**
     * 思路：排序
     * 时间复杂度：O(n * log n)
     * 空间复杂度：O(1)
     *
     * @param nums 整数数组
     * @return 将 nums 分成 n 对 (a, b)，使得所有数对 min(a, b) 总和最大
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        int numsLen = nums.length;

        for (int i = 0; i < numsLen; i += 2) {
            res += nums[i];
        }

        return res;
    }

}
