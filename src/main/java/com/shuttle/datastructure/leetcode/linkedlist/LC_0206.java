package com.shuttle.datastructure.leetcode.linkedlist;

import com.shuttle.helper.ListNode;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/reverse-linked-list/description">反转链表</a>
 */
public class LC_0206 {

    /**
     * 思路：迭代
     * 时间复杂度：O(n)，n 是链表的结点个数
     * 空间复杂度：O(1)
     *
     * @param head 给定的链表头结点
     * @return 反转后的链表
     */
    public ListNode reverseList(ListNode head) {
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
}
