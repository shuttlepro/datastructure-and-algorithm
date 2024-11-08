package com.shuttle.datastructure.leetcode.linkedlist;

import com.shuttle.helper.ListNode;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/swap-nodes-in-pairs/description">合并两个有序链表</a>
 */
public class LC_0021 {

    /**
     * 思路：比较两条链表的值，放入新链表中，直到其中一条链表为空
     * 时间复杂度：O(m + n)，m 是链表 1 的长度，n 是链表 2 的长度
     * 空间复杂度：O(1)，除了返回结果链表，其他变量都不占额外空间
     *
     * @param list1 链表 1
     * @param list2 链表 2
     * @return 合并后的链表头节点
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        ListNode sentinelNode = new ListNode(-1);
        ListNode curNode = sentinelNode;
        ListNode curList1Node = list1;
        ListNode curList2Node = list2;

        // 比较两条链表的值
        while (curList1Node != null && curList2Node != null) {
            if (curList1Node.val > curList2Node.val) {
                curNode.next = curList2Node;
                curList2Node = curList2Node.next;
            } else {
                curNode.next = curList1Node;
                curList1Node = curList1Node.next;
            }
            curNode = curNode.next;
        }

        // 比较完会有一条链表为空
        curNode.next = curList1Node == null ? curList2Node : curList1Node;

        return sentinelNode.next;
    }
}
