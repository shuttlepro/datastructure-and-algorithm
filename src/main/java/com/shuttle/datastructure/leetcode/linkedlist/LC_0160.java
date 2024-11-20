package com.shuttle.datastructure.leetcode.linkedlist;

import com.shuttle.helper.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/intersection-of-two-linked-lists/description">相交链表</a>
 */
public class LC_0160 {

    /**
     * 解法一：哈希表
     * 时间复杂度：O(n + m)，n 是链表 A 的长度，m 是链表 B 的长度
     * 空间复杂度：O(n + m)
     *
     * @param headA 链表 A 的头节点
     * @param headB 链表 B 的头节点
     * @return 相交链表的头节点，如果没有相交链表，则返回 null
     */
    public ListNode getIntersectionNodeSolution1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        Set<ListNode> nodeSet = new HashSet<>();
        ListNode curNode = headA;

        while (curNode != null) {
            nodeSet.add(curNode);
            curNode = curNode.next;
        }

        curNode = headB;
        while (curNode != null) {
            boolean notExist = nodeSet.add(curNode);
            if (!notExist) {
                return curNode;
            }
            curNode = curNode.next;
        }

        return null;
    }

    /**
     * 解法二：双指针
     * 时间复杂度：O(n + m)，n 是链表 A 的长度，m 是链表 B 的长度
     * 空间复杂度：O(1)
     *
     * @param headA 链表 A 的头节点
     * @param headB 链表 B 的头节点
     * @return 相交链表的头节点，如果没有相交链表，则返回 null
     */
    public ListNode getIntersectionNodeSolution2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode curA = headA;
        ListNode curB = headB;

        while (curA != curB) {
            curA = curA == null ? headB : curA.next;
            curB = curB == null ? headA : curB.next;
        }

        return curA;
    }
}
