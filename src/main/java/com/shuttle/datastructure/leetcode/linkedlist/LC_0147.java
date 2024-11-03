package com.shuttle.datastructure.leetcode.linkedlist;

import com.shuttle.helper.ListNode;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/insertion-sort-list/description">对链表进行插入排序</a>
 */
public class LC_0147 {

    /**
     * 思路：与列表的插入排序类似
     * 时间复杂度：O(n²)
     * 空间复杂度：O(1)
     *
     * @param head 链表头节点
     * @return 排序后的链表头节点
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode sentinelNode = new ListNode(-1);
        sentinelNode.next = head;
        // 记录当前已排序链表的最后一个节点
        ListNode lastSortedNode = head;
        // 当前需要进入排序链表的节点
        ListNode cur = head.next;
        ListNode pre = null;

        while (cur != null) {
            // 如果当前节点数值比排序链表中最后一个节点的数值大，直接放到后面即可
            if (lastSortedNode.val <= cur.val) {
                lastSortedNode = lastSortedNode.next;
            } else {
                // 小的话就找到应该插入的位置
                pre = sentinelNode;
                while (pre.next.val <= cur.val) {
                    pre = pre.next;
                }
                // 修改链表指向
                lastSortedNode.next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
            }

            cur = lastSortedNode.next;
        }

        return sentinelNode.next;
    }
}
