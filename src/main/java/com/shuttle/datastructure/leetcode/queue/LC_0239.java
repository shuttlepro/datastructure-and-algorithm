package com.shuttle.datastructure.leetcode.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/sliding-window-maximum/description">滑动窗口最大值</a>
 */
public class LC_0239 {

    /**
     * 思路：使用双端队列，保存当前窗口内的最大值
     *
     * @param nums 整数数组
     * @param k    窗口大小
     * @return 滑动窗口中的最大值
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return nums;
        }

        // 队列中保存数值的下标
        Deque<Integer> deque = new ArrayDeque<>();
        int numLen = nums.length;
        // len = 5, k = 3 [123 234 345]
        int[] res = new int[numLen - k + 1];

        for (int i = 0; i < numLen; i++) {
            int curNum = nums[i];
            // [1] -> [2] -> [3] -> [3, 2] ->... [3, 2, 1, 1]
            while (!deque.isEmpty() && nums[deque.peekLast()] <= curNum) {
                deque.pollLast();
            }
            deque.addLast(i);
            // 检查队首元素是否还在范围内
            if (deque.peek() <= i - k) {
                deque.poll();
            }
            // left - right 符合窗口条件
            if (i - k + 1 >= 0) {
                res[i - k + 1] = nums[deque.peek()];
            }
        }

        return res;
    }

}
