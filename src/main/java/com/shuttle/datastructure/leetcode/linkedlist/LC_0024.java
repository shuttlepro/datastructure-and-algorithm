package com.shuttle.datastructure.leetcode.linkedlist;

import com.shuttle.helper.ListNode;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/swap-nodes-in-pairs/description">两两交换链表中的节点</a>
 */
public class LC_0024 {

    /**
     * 解法一：迭代
     * 时间复杂度：O(n)，n 是链表节点个数
     * 空间复杂度：O(1)
     *
     * @param head 给定的头节点
     * @return 两两交换后的头节点
     */
    public ListNode swapPairsSolution1(ListNode head) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        // 代表待反转段的前一个节点
        ListNode temp = newHead;

        while (temp.next != null && temp.next.next != null) {
            // 存储待反转的第一、二个节点
            ListNode first = temp.next;
            ListNode second = temp.next.next;
            // 前一个节点的 next 域指向待反转的第二个节点
            temp.next = second;
            // 待反转的第一个节点的 next 域指向待反转的第二个节点的下一段链表
            first.next = second.next;
            // 待反转的第二个节点的 next 域指向待反转的第一个节点
            second.next = first;
            // 移动 temp 到下一段待反转区间的前一个节点
            temp = first;
        }

        return newHead.next;
    }

    /**
     * 解法二：递归
     * 时间复杂度：O(n)，n 是链表节点个数
     * 空间复杂度：O(n)，递归栈深度
     *
     * @param head 给定的头节点
     * @return 两两交换后的头节点
     */
    public ListNode swapPairsSolution2(ListNode head) {
        // 最后没有节点或者一个节点直接返回
        if (head == null || head.next == null) {
            return head;
        }
        /*
         * 返回值：交换完成的子链表
         * 调用单元：设需要交换的两个点为 head 和 next，head 连接后面交换完成的子链表，next 连接 head，完成交换
         * 终止条件：head 为空指针或者 next 为空指针，也就是当前无节点或者只有一个节点，无法进行交换
         */
        // 1 -> 2 -> 3 -> 4 -> 5  ==> 2 -> 1 -> 4 -> 3 -> 5
        ListNode next = head.next;
        head.next = swapPairsSolution2(next.next);
        next.next = head;

        return next;
    }
}
