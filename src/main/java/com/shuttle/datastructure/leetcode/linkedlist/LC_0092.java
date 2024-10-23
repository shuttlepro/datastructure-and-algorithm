package com.shuttle.datastructure.leetcode.linkedlist;

import com.shuttle.helper.ListNode;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/reverse-linked-list-ii/description">反转链表 II</a>
 */
public class LC_0092 {

    /**
     * 思路：分段讨论
     * 时间复杂度：O(n)，n 是链表的长度
     * 空间复杂度：O(1)
     *
     * @param head 给定的头指针
     * @param left 反转左边界
     * @param right 反转右边界
     * @return 反转后的链表头结点
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 反转链表的 [left, right] 区间
        // head = [1, 2, 3, 4, 5], left = 2, right = 4 [1, 4, 3, 2, 5]
        // 哨兵节点辅助查找
        ListNode newHead = new ListNode(-1);
        newHead.next = head;

        // 找到第一段链表的尾部节点
        ListNode firstTailNode = newHead;
        for (int i = 0; i < left - 1; i++) {
            firstTailNode = firstTailNode.next;
        }

        // 找到第三段链表的头节点
        ListNode thirdHeadNode = newHead;
        for (int i = 0; i < right + 1; i++) {
            thirdHeadNode = thirdHeadNode.next;
        }

        // 找到待反转链表的头节点和尾节点
        ListNode secondHeadNode = firstTailNode.next;
        firstTailNode.next = reverseList(secondHeadNode, left, right);
        secondHeadNode.next = thirdHeadNode;

        return newHead.next;
    }

    public ListNode reverseList(ListNode head, int left, int right) {
        ListNode pre = null;
        ListNode cur = head;

        for (int i = 0; i < right - left + 1; i++) {
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
