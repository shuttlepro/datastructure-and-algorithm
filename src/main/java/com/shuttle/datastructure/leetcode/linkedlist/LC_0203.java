package com.shuttle.datastructure.leetcode.linkedlist;

import com.shuttle.helper.ListNode;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/remove-linked-list-elements/description">移除链表元素</a>
 */
public class LC_0203 {

    /**
     * 思路：记录下一个结点，如果下一个结点值等于 val，则将当前结点的 next 指针指向下一个结点的下一个结点
     * 时间复杂度：O(n)，n 是链表长度
     * 空间复杂度：O(1)
     *
     * @param head 给定的头结点
     * @param val  给定的整数
     * @return 移除指定值的链表头结点
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode curNode = newHead;

        while (curNode.next != null) {
            if (curNode.next.val == val) {
                // 找到直接将指向下一个 next 域的指针再挪一位
                curNode.next = curNode.next.next;
            } else {
                // 没找到移动当前结点
                curNode = curNode.next;
            }

        }

        return newHead.next;
    }
}
