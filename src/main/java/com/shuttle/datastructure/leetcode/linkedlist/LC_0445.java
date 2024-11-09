package com.shuttle.datastructure.leetcode.linkedlist;

import com.shuttle.helper.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/add-two-numbers-ii/description">两数相加 II</a>
 */
public class LC_0445 {

    /**
     * 解法一：反转后再计算，计算完再反转
     * 时间复杂度：O(m + n)，m 是 l1 的长度，n 是 l2 的长度
     * 空间复杂度：O(max(m + n))
     *
     * @param l1 链表 1
     * @param l2 链表 2
     * @return 合并后的链表头节点
     */
    public ListNode addTwoNumbersSolution1(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        ListNode reverseL1 = reverseLinkedList(l1);
        ListNode reverseL2 = reverseLinkedList(l2);

        return reverseLinkedList(addTwoNumbers(reverseL1, reverseL2));
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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

    /**
     * 解法二：利用栈的数据结构进行累加
     * 时间复杂度：O(m + n)，m 是 l1 的长度，n 是 l2 的长度
     * 空间复杂度：O(m + n)
     *
     * @param l1 链表 1
     * @param l2 链表 2
     * @return 合并后的链表头节点
     */
    public ListNode addTwoNumbersSolution2(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();

        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        int sum = 0;
        ListNode res = null;
        ListNode cur = null;

        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int l1Val = stack1.isEmpty() ? 0 : stack1.pop();
            int l2Val = stack2.isEmpty() ? 0 : stack2.pop();
            sum = l1Val + l2Val + carry;
            carry = sum / 10;
            cur = new ListNode(sum % 10);
            cur.next = res;
            res = cur;
        }

        return res;
    }
}
