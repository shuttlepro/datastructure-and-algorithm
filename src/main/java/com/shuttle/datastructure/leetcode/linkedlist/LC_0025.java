package com.shuttle.datastructure.leetcode.linkedlist;

import com.shuttle.helper.ListNode;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/reverse-nodes-in-k-group/description">K 个一组翻转链表</a>
 */
public class LC_0025 {

    /**
     * 思路：根据给定 k 值找到每段反转的头节点和尾节点，然后对每段进行反转，并拼接。
     * 时间复杂度：O(n)，n 是链表的节点
     * 空间复杂度：O(1)
     *
     * @param head 给定的头节点
     * @param k    每段反转的长度
     * @return 反转后的头节点
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        // 哨兵节点
        ListNode sentinelNode = new ListNode(-1);
        sentinelNode.next = head;
        // 维护待反转链表头节点的前一个节点和待反转链表的尾节点
        ListNode pre = sentinelNode;
        ListNode end = sentinelNode;

        // [-1, 1, 2, 3, 4, 5]
        while (end.next != null) {
            // 找每一段的 end
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }

            // 存储下一段待反转的链表
            ListNode nextLinkedList = end.next;
            // 待反转链表的头节点
            ListNode start = pre.next;
            // 将待反转区间的尾部断开
            end.next = null;
            pre.next = reverseList(start);
            start.next = nextLinkedList;
            pre = start;
            end = start;
        }

        return sentinelNode.next;
    }

    private ListNode reverseList(ListNode head) {
        // 暂存当前结点和上一个处理结点
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            // 暂存下一段链表
            ListNode next = cur.next;
            // 当前节点的 next 域指向 pre
            cur.next = pre;
            // pre、cur 后移
            pre = cur;
            cur = next;
        }

        return pre;
    }
}
