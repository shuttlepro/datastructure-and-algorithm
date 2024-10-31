package com.shuttle.datastructure.leetcode.linkedlist;

import com.shuttle.helper.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/rotate-list/description">旋转链表</a>
 */
public class LC_0061 {

    /**
     * 解法一：将所有节点放入列表中，改变每一个节点的 next 指针
     * 时间复杂度：O(n)，n 是链表的长度
     * 空间复杂度：O(n)
     *
     * @param head 给定的链表头节点
     * @param k    向右移动的步数
     * @return 旋转后的链表头节点
     */
    public ListNode rotateRightSolution1(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        List<ListNode> nodeList = new ArrayList<>();
        ListNode cur = head;

        while (cur != null) {
            nodeList.add(cur);
            cur = cur.next;
        }

        ListNode sentinelNode = new ListNode(-1);
        cur = sentinelNode;
        int size = nodeList.size();
        // k 有可能超过 size
        int newK = k % size;

        for (int i = 0; i < size; i++) {
            cur.next = nodeList.get((i + (size - newK)) % size);
            cur = cur.next;
        }
        cur.next = null;

        return sentinelNode.next;
    }

    /**
     * 解法二：头尾相连后找到断开的地方
     * 时间复杂度：O(n)，n 是链表的长度
     * 空间复杂度：O(1)
     *
     * @param head 给定的链表头节点
     * @param k    向右移动的步数
     * @return 旋转后的链表头节点
     */
    public ListNode rotateRightSolution2(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0) {
            return head;
        }

        int size = 1;
        ListNode cur = head;

        // 将链表头尾连接
        while (cur.next != null) {
            cur = cur.next;
            size++;
        }

        cur.next = head;
        // 同上
        int newK = k % size;

        // 找到断开的位置
        for (int i = 0; i < size - newK; i++) {
            cur = cur.next;
        }
        ListNode newHead = cur.next;
        cur.next = null;

        return newHead;
    }
}
