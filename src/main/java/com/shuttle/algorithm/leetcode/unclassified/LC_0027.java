package com.shuttle.algorithm.leetcode.unclassified;

/**
 * @author: Shuttle
 * @description: 给你一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素。
 * 输入：nums = [3,2,2,3], val = 3
 * 输出：2, nums = [2,2,_,_]
 */
public class LC_0027 {

    /**
     * 思路：维护当前元素索引，如果该索引上元素 == val 则跳过，否则更新索引值
     * 时间复杂度：O(n)，n 是 nums 数组的长度
     * 空间复杂度：O(1)
     *
     * @param nums 整数数组
     * @param val  待移除的值
     * @return 数组移除 val 后返回的新数组
     */
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int curIndex = 0;
        int numsLen = nums.length;

        for (int i = 0; i < numsLen; i++) {
            if (nums[i] != val) {
                nums[curIndex] = nums[i];
                curIndex++;
            }
        }

        return curIndex;
    }

}
