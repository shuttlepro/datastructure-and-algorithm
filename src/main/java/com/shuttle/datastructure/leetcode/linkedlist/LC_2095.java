package com.shuttle.datastructure.leetcode.linkedlist;

import com.shuttle.helper.ListNode;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/delete-the-middle-node-of-a-linked-list/description">删除链表的中间节点</a>
 */
public class LC_2095 {

    /**
     * 思路：利用快慢指针找到链表中点，然后删除该节点，返回头节点
     * 时间复杂度：O(n)，n 为链表节点数
     * 空间复杂度：O(1)
     *
     * @param head 给定的头节点
     * @return 删除中间节点后的链表头节点
     */
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        // 找到中间节点的前一个节点
        ListNode midPreNode = null;
        ListNode slowNode = head;
        ListNode fastNode = head;

        while (fastNode != null && fastNode.next != null) {
            midPreNode = slowNode;
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        // 退出循环时 slowNode 为待删除节点
        midPreNode.next = slowNode.next;

        return head;
    }
}
