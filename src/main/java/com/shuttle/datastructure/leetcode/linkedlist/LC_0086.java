package com.shuttle.datastructure.leetcode.linkedlist;

import com.shuttle.helper.ListNode;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/partition-list/description">分隔链表</a>
 */
public class LC_0086 {

    /**
     * 思路：构造两条链表，分别存储小于 x 和大于等于 x 的节点，最后连接起来
     *
     * @param head 给定的头节点
     * @param x    给定的分隔值
     * @return 分隔后的头节点
     */
    public ListNode partition(ListNode head, int x) {
        // 构造两条链表
        ListNode smallSentinel = new ListNode(-1);
        ListNode smallCurNode = smallSentinel;
        ListNode largeSentinel = new ListNode(-1);
        ListNode largeCurNode = largeSentinel;

        while (head != null) {
            // 当前节点的值大于等于 x 就放到 large 中
            if (head.val >= x) {
                largeCurNode.next = head;
                largeCurNode = largeCurNode.next;
            } else {
                // 否则放到 small 中
                smallCurNode.next = head;
                smallCurNode = smallCurNode.next;
            }
            head = head.next;
        }

        // 连接 small 和 large
        smallCurNode.next = largeSentinel.next;
        largeCurNode.next = null;

        return smallSentinel.next;
    }
}
