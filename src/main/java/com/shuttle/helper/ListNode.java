package com.shuttle.helper;

/**
 * @author: Shuttle
 * @description: 链表节点 ListNode
 */
public class ListNode {

    // 为了符合题意将访问权限设置为 public
    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
