package com.shuttle.datastructure.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/next-greater-element-ii/description">下一个更大元素 II</a>
 */
public class LC_0503 {

    /**
     * 思路：环形数组，遍历两遍，取模运算
     * 时间复杂度：O(n)，n 为数组长度
     * 空间复杂度：O(n)
     *
     * @param nums 给定的循环数组
     * @return nums 中每个元素的下一个更大元素组成的数组
     */
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        int numsLen = nums.length;
        int[] res = new int[numsLen];
        // 初始化结果数组，没找到默认为 -1
        Arrays.fill(res, -1);
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < numsLen * 2; i++) {
            int curNum = nums[i % numsLen];

            // 如果当前元素大于栈顶元素对应的值，出栈并更新结果数组
            while (!stack.isEmpty() && curNum > nums[stack.peek()]) {
                res[stack.pop()] = curNum;
            }

            stack.push(i % numsLen);
        }

        return res;
    }
}
