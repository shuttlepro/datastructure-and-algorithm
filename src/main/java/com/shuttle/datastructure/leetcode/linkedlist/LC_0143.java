package com.shuttle.datastructure.leetcode.linkedlist;

import com.shuttle.helper.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/reorder-list/description">重排链表</a>
 */
public class LC_0143 {

    /**
     * 解法一：把节点放进列表里，迭代重排
     * 时间复杂度：O(n)，n 是链表节点个数
     * 空间复杂度：O(n)
     *
     * @param head 给定的头节点
     */
    public void reorderListSolution1(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        List<ListNode> nodeList = new ArrayList<>();
        ListNode cur = head;

        while (cur != null) {
            nodeList.add(cur);
            cur = cur.next;
        }

        // [1, 2, 3, 4, 5]
        // [1, 5, 2, 4, 3]
        int leftIndex = 0;
        int rightIndex = nodeList.size() - 1;

        while (leftIndex < rightIndex) {
            // 1 -> 5
            nodeList.get(leftIndex).next = nodeList.get(rightIndex);
            leftIndex++;
            if (leftIndex == rightIndex) {
                break;
            }
            // 5 -> 2
            nodeList.get(rightIndex).next = nodeList.get(leftIndex);
            rightIndex--;
        }

        // 结束、将尾部多余的节点置为 null
        nodeList.get(leftIndex).next = null;
    }

    /**
     * 解法二：找到中间节点并反转，交叉连接即可
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param head 给定的头节点
     */
    public void reorderListSolution2(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // 找到待反转链表的中间节点的下一个节点
        ListNode midNode = middleNode(head);
        // 反转链表
        ListNode reverseList = reverseList(midNode);

        // [1, 2, 3, 4, 5] 和 [5, 4] 交叉连接即可
        ListNode next = null;
        ListNode midNext = null;
        ListNode curMidNode = reverseList;
        ListNode curHeadNode = head;

        while (curMidNode != null) {
            // 暂存第一段链表的next
            next = curHeadNode.next;
            // 交叉指向
            curHeadNode.next = curMidNode;
            midNext = curMidNode.next;
            curMidNode.next = next;
            curHeadNode = next;
            curMidNode = midNext;
        }

        // 最后把多余的部分置为null
        curHeadNode.next = null;
    }

    /**
     * 计算链表的中间节点，方式二：快慢指针
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.next;
    }

    /**
     * 计算链表的中间节点，方式一：遍历找中间节点
     */
    private ListNode computeMidNode(ListNode head) {
        int size = 0;
        ListNode cur = head;

        while (cur != null) {
            cur = cur.next;
            size++;
        }

        int mid;

        if (size % 2 == 0) {
            mid = size / 2;
        } else {
            mid = size / 2 + 1;
        }

        cur = head;
        for (int i = 0; i < mid; i++) {
            cur = cur.next;
        }

        return cur;
    }

    private ListNode reverseList(ListNode head) {
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
