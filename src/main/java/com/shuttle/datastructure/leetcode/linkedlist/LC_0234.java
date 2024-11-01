package com.shuttle.datastructure.leetcode.linkedlist;

import com.shuttle.helper.ListNode;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/palindrome-linked-list/description">回文链表</a>
 */
public class LC_0234 {

    /**
     * 思路：找到中点，然后翻转后半部分链表，然后和前半部分链表进行比较即可。
     * 时间复杂度：O(n)，n 是链表的长度
     * 空间复杂度：O(1)
     *
     * @param head 给定的根节点
     * @return 是否是回文链表
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // 找到中点后的一个节点，进行翻转后和链表比较
        ListNode midNode = findMidNode(head);
        ListNode midNextNode = midNode.next;
        ListNode secondHead = reverseLinkedList(midNextNode);
        ListNode secondCurNode = secondHead;
        ListNode curNode = head;

        while (secondCurNode != null) {
            if (curNode.val != secondCurNode.val) {
                // 将链表还原
                midNode.next = reverseLinkedList(secondHead);
                return false;
            }
            curNode = curNode.next;
            secondCurNode = secondCurNode.next;
        }
        // 将链表还原
        midNode.next = reverseLinkedList(secondHead);

        return true;
    }

    private ListNode reverseLinkedList(ListNode head) {
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

    private ListNode findMidNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
