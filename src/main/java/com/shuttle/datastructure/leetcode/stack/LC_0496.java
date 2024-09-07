package com.shuttle.datastructure.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/next-greater-element-i/description">下一个更大元素 I</a>
 */
public class LC_0496 {

    /**
     * 思路：单调栈 + 哈希表
     * 时间复杂度：O(n + m)，n 是 nums1 数组的长度，m 是 nums2 数组的长度
     * 空间复杂度：O(n + m)
     *
     * @param nums1 没有重复元素的 1 号数组
     * @param nums2 没有重复元素的 2 号数组
     * @return nums1 中每个元素对应 nums2 中的下一个更大元素组成的数组
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }

        // 存储 nums2 中右边第一位大于当前值的元素
        Map<Integer, Integer> nums2NextGreaterIndexMap = new HashMap<>();
        // 维护单调栈，栈顶到栈底递增
        Deque<Integer> stack = new ArrayDeque<>();
        int nums2Len = nums2.length;

        for (int i = nums2Len - 1; i >= 0; i--) {
            int curNums2 = nums2[i];
            // 遇到比当前栈顶大的元素就要出栈
            while (!stack.isEmpty() && curNums2 >= stack.peek()) {
                stack.pop();
            }
            // 右边没值放 -1
            int val = stack.isEmpty() ? -1 : stack.peek();
            nums2NextGreaterIndexMap.put(curNums2, val);

            stack.push(curNums2);
        }

        int nums1Len = nums1.length;
        int[] res = new int[nums1Len];

        for (int i = 0; i < nums1Len; i++) {
            res[i] = nums2NextGreaterIndexMap.get(nums1[i]);
        }

        return res;
    }
}
