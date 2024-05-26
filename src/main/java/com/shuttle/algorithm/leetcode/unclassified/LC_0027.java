package com.shuttle.algorithm.leetcode.unclassified;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/remove-element">移除元素</a>
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
