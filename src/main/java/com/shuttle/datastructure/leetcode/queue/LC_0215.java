package com.shuttle.datastructure.leetcode.queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/kth-largest-element-in-an-array/description">数组中的第K个最大元素</a>
 */
public class LC_0215 {

    /**
     * 思路：优先队列
     * 时间复杂度：O(n)，n 是数组的长度
     * 空间复杂度：O(n)
     *
     * @param nums 整数数组
     * @param k    数组中第 k 大
     * @return k 大的元素
     */
    public int findKthLargest1(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return -1;
        }

        int numsLen = nums.length;
        Queue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o));
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }

        for (int i = k; i < numsLen; i++) {
            // 拿到堆顶元素，也就是最小的元素
            Integer topVal = minHeap.peek();
            if (nums[i] > topVal) {
                // 只要当前元素比队首元素大就弹出来，弹出来的就是最小的元素
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }

        return minHeap.peek();
    }
}
