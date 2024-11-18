package com.shuttle.datastructure.leetcode.linkedlist;

import com.shuttle.helper.ListNode;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/split-linked-list-in-parts/description">分隔链表</a>
 */
public class LC_0725 {

    /**
     * 思路：遍历链表，计算链表的长度，然后根据长度和段数计算每段链表的初始和附加长度
     * 时间复杂度：O(n)，n 是链表的长度
     * 空间复杂度：O(n)
     *
     * @param head 给定的链表头节点
     * @param k    分割的段数
     * @return 分割后的链表数组
     */
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode cur = head;
        int length = 0;

        while (cur != null) {
            length++;
            cur = cur.next;
        }

        ListNode[] nodeArr = new ListNode[k];
        // 每段链表的初始长度和附加长度，只有前部分能附加 1
        int initialCount = length / k;
        int supplyCount = length % k;
        cur = head;

        for (int i = 0; i < k && cur != null; i++) {
            nodeArr[i] = cur;
            int partSize = initialCount + (supplyCount > i ? 1 : 0);

            for (int j = 1; j < partSize; j++) {
                cur = cur.next;
            }

            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }

        return nodeArr;
    }
}
