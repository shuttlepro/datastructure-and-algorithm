package com.shuttle.datastructure.leetcode.linkedlist;

import com.shuttle.helper.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/linked-list-cycle/description">环形链表</a>
 */
public class LC_0141 {

    /**
     * 解法一：哈希表
     * 时间复杂度：O(n)，n 是链表的长度
     * 空间复杂度：O(n)
     *
     * @param head 给定的链表头节点
     * @return 是否存在环
     */
    public boolean hasCycleSolution1(ListNode head) {
        Set<ListNode> set = new HashSet<>();

        while (head != null) {
            boolean notExist = set.add(head);
            if (!notExist) {
                return true;
            }
            head = head.next;
        }

        return false;
    }

    /**
     * 解法二：快慢指针
     * 时间复杂度：O(n)，n 是链表的长度
     * 空间复杂度：O(1)
     *
     * @param head 给定的链表头节点
     * @return 是否存在环
     */
    public boolean hasCycleSolution2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        // 定义快慢指针
        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }
}
