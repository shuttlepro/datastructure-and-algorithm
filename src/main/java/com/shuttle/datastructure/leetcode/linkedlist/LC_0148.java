package com.shuttle.datastructure.leetcode.linkedlist;

import com.shuttle.helper.ListNode;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/sort-list/description">排序链表</a>
 */
public class LC_0148 {

    /**
     * 思路：这里使用归并排序，将链表分为两个部分，然后分别对两个部分进行排序，最后合并两个有序链表。
     * 时间复杂度：O(n * log n)
     * 空间复杂度：O(log n)
     *
     * @param head 给定的头节点
     * @return 排序后的头节点
     */
    public ListNode sortList(ListNode head) {
        return head == null ? null : mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        if (head.next == null) {
            return head;
        }

        ListNode slow = head, fast = head, pre = null;

        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        pre.next = null;
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(slow);

        return merge(left, right);
    }

    ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                cur = cur.next;
                list1 = list1.next;
            } else {
                cur.next = list2;
                cur = cur.next;
                list2 = list2.next;
            }
        }
        cur.next = list1 != null ? list1 : list2;

        return dummyHead.next;
    }
}
