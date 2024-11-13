package com.shuttle.datastructure.leetcode.linkedlist;

import com.shuttle.helper.ListNode;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-list/description">删除排序链表中的重复元素</a>
 */
public class LC_0083 {

    /**
     * 思路：遍历链表，如果当前节点和下个节点相等，节点后移
     * 时间复杂度：O(n)，n 是链表长度
     * 空间复杂度：O(1)
     *
     * @param head 给定的链表头节点
     * @return 删除重复元素后的链表头节点
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode sentinelNode = new ListNode(-1);
        sentinelNode.next = head;
        // 当前节点
        ListNode curNode = sentinelNode.next;

        // 当前节点和下一节点比较
        while (curNode != null && curNode.next != null) {
            // 如果相等则记录当前待删除的值，遍历链表直到找到一个不相等的节点
            if (curNode.val == curNode.next.val) {
                int delVal = curNode.val;
                while (curNode.next != null && curNode.next.val == delVal) {
                    curNode.next = curNode.next.next;
                }
            }
            curNode = curNode.next;
        }

        return sentinelNode.next;
    }
}
