package com.shuttle.datastructure.leetcode.linkedlist;

import com.shuttle.helper.ListNode;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/linked-list-cycle-ii/description">环形链表 II</a>
 */
public class LC_0142 {

    /**
     * 思路：快慢指针
     * 时间复杂度：O(n)，n 是链表的长度
     * 空间复杂度：O(1)
     *
     * @param head 给定的链表头节点
     * @return 环的起始节点，如果没有环，返回 null
     */
    public ListNode detectCycle(ListNode head) {
        // 定义快慢指针
        ListNode slow = head;
        ListNode fast = head;
        /*
           a 代表起始位置到环入口的前一个位置的距离
           b 代表环内节点数，n 代表环的圈数
           第一次相遇 fast = slow + nb  fast = 2 * slow
           可以得到 fast = 2nb, slow = nb
           需要找的位置是 k = a + nb
           所以 slow 再走 a 步就能到入口
         */
        do {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);

        // 让 fast 从头开始走 a 步与 slow 相遇就是入口处
        fast = head;

        // 第二次相遇
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
