package com.shuttle.datastructure.leetcode.linkedlist;

import com.shuttle.helper.ListNode;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/add-two-numbers/description">两数相加</a>
 */
public class LC_0002 {

    /**
     * 思路：遍历链表，同时进位，直到所有位都遍历完
     * 时间复杂度：O(max(m, n))
     * 空间复杂度：O(max(m, n))
     *
     * @param l1 链表 1 的头节点
     * @param l2 链表 2 的头节点
     * @return 两数相加的结果
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        ListNode head = null;
        ListNode tail = null;
        int carry = 0;
        int sum = 0;

        while (l1 != null || l2 != null) {
            int l1Val = l1 == null ? 0 : l1.val;
            int l2Val = l2 == null ? 0 : l2.val;
            sum = l1Val + l2Val + carry;

            if (head == null) {
                // 首次要进行初始化 head 和 tail
                head = new ListNode(sum % 10);
                tail = head;
            } else {
                // 后续接在 tail 指针的 next 域即可
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }

            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        // 最后一位可能会进位
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }

        return head;
    }
}
