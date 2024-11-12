package com.shuttle.datastructure.leetcode.linkedlist;

import com.shuttle.helper.ListNode;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/description">删除排序链表中的重复元素 II</a>
 */
public class LC_0082 {

    /**
     * 思路：遍历链表，如果下一个节点和下下个节点相等，节点后移
     * 时间复杂度：O(n)，n 是链表的长度
     * 空间复杂度：O(1)
     *
     * @param head 给定的链表头节点
     * @return 删除重复节点后的链表头节点
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 需要维护当前节点的下一个和下下个节点
        ListNode sentinelNode = new ListNode(-1);
        sentinelNode.next = head;
        // 当前节点
        ListNode curNode = sentinelNode;

        // 比较当前节点的后两个节点
        while (curNode.next != null && curNode.next.next != null) {
            // 如果相等则先记录待删除的值，遍历到不相等退出，改变指针即可
            if (curNode.next.val == curNode.next.next.val) {
                int delVal = curNode.next.val;
                while (curNode.next != null && curNode.next.val == delVal) {
                    curNode.next = curNode.next.next;
                }
            } else {
                curNode = curNode.next;
            }
        }

        return sentinelNode.next;
    }
}
