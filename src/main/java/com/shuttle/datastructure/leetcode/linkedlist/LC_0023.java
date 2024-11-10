package com.shuttle.datastructure.leetcode.linkedlist;

import com.shuttle.helper.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/merge-k-sorted-lists/description">合并 K 个升序链表</a>
 */
public class LC_0023 {

    /**
     * 解法一：正常遍历链表集合，两两合并
     * 时间复杂度：O(k² * n)，k 为链表数，n 为链表最长长度
     * 空间复杂度：O(1)
     *
     * @param lists 链表头组成的数组
     * @return 合并后的链表头
     */
    public ListNode mergeKListsSolution1(ListNode[] lists) {
        ListNode res = null;

        for (ListNode list : lists) {
            res = mergeTwoList(res, list);
        }

        return res;
    }

    private ListNode mergeTwoList(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }

        ListNode sentinelNode = new ListNode(-1);
        ListNode curNode = sentinelNode;
        ListNode curList1Node = list1;
        ListNode curList2Node = list2;

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
        curNode.next = curList1Node == null ? curList2Node : curList1Node;

        return sentinelNode.next;
    }

    /**
     * 解法二：分治法
     * 时间复杂度：O(kn * log k)，k 为链表数，n 为链表平均长度
     * 空间复杂度：O(log k)
     *
     * @param lists 链表头组成的数组
     * @return 合并后的链表头
     */
    public ListNode mergeKListSolution2(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] listNodes, int left, int right) {
        if (left == right) {
            return listNodes[left];
        }
        if (left > right) {
            return null;
        }

        int mid = (left + right) / 2;

        return mergeTwoList(merge(listNodes, left, mid), merge(listNodes, mid + 1, right));
    }

    /**
     * 解法三：优先队列
     * 时间复杂度：O(kn * log k)，k 为链表数，n 为链表平均长度
     * 空间复杂度：O(k)
     *
     * @param lists 链表头组成的数组
     * @return 合并后的链表头
     */
    public ListNode mergeKListsSolution3(ListNode[] lists) {
        if (lists == null) {
            return null;
        } else if (lists.length == 1) {
            return lists[0];
        }

        // 优先队列，按照首元素大小升序排序
        PriorityQueue<ListNode> listNodePriorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode list : lists) {
            if (list == null) {
                continue;
            }
            listNodePriorityQueue.add(list);
        }

        ListNode sentinelNode = new ListNode(-1);
        ListNode curNode = sentinelNode;

        while (!listNodePriorityQueue.isEmpty()) {
            // 将优先队列中的首元素添加到当前节点的后面
            ListNode queueFirstNode = listNodePriorityQueue.poll();
            curNode.next = queueFirstNode;
            curNode = curNode.next;
            // 下一段不为空就继续放到优先队列中
            if (queueFirstNode.next != null) {
                listNodePriorityQueue.add(queueFirstNode.next);
            }
        }

        return sentinelNode.next;
    }
}
