package com.shuttle.datastructure.leetcode.stack;

import com.shuttle.helper.ListNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/next-greater-node-in-linked-list/description">链表中的下一个更大节点</a>
 */
public class LC_1019 {

    /**
     * 解法一：单调栈
     * 时间复杂度：O(n)，n 为链表长度
     * 空间复杂度：O(n)
     *
     * @param head 给定的链表头结点
     * @return 下一个更大结点数组
     */
    public int[] nextLargerNodesSolution1(ListNode head) {
        if (head == null) {
            return new int[]{};
        }

        List<Integer> nodeVals = new ArrayList<>();

        // 链表元素存储到集合中
        while (head != null) {
            nodeVals.add(head.val);
            head = head.next;
        }

        // 单调栈从栈底到栈顶对应的值是从大到小的，存储的是元素的下标
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[nodeVals.size()];

        for (int i = 0; i < nodeVals.size(); i++) {
            // 如果栈顶元素对应的值小于当前值，出栈
            while (!stack.isEmpty() && nodeVals.get(stack.peek()) < nodeVals.get(i)) {
                int index = stack.pop();
                res[index] = nodeVals.get(i);
            }

            stack.push(i);
        }

        return res;
    }

    /**
     * 解法二：从后往前遍历，剪枝法
     * 时间复杂度：O(n²)，n 为链表长度
     * 空间复杂度：O(n)
     *
     * @param head 给定的链表头结点
     * @return 下一个更大结点数组
     */
    public int[] nextLargerNodesSolution2(ListNode head) {
        if (head == null) {
            return new int[]{};
        }

        List<Integer> nodeVals = new ArrayList<>();

        while (head != null) {
            nodeVals.add(head.val);
            head = head.next;
        }

        int size = nodeVals.size();
        int[] res = new int[size];

        // 倒数第二位开始
        for (int i = size - 2; i >= 0; i--) {
            int rightIdx = i + 1;
            int num = nodeVals.get(rightIdx);
            int val = nodeVals.get(i);

            while (rightIdx < res.length) {
                // 找到比 i 位置大的第一个元素
                if (num > val) {
                    res[i] = num;
                    break;
                } else if (num == 0) {
                    // 为 0 则说明后面已经没有比 i 位置元素大的值了，退出即可
                    break;
                } else {
                    // 继续往后找
                    num = res[rightIdx++];
                }
            }
        }

        return res;
    }
}
