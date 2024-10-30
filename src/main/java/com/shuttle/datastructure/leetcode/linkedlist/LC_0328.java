package com.shuttle.datastructure.leetcode.linkedlist;

import com.shuttle.helper.ListNode;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/odd-even-linked-list/description">奇偶链表</a>
 */
public class LC_0328 {

    /**
     * 思路：奇偶节点迭代交替连接
     * 时间复杂度：O(n)，n 是链表的长度
     * 空间复杂度：O(1)
     *
     * @param head 给定的头节点
     * @return 重新排序的链表头节点
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        // 需要保存偶链表的头节点
        ListNode evenHead = head.next;
        ListNode odd = head;
        ListNode even = evenHead;

        while (even != null && even.next != null) {
            // 交替连接
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;

        return head;
    }
}
