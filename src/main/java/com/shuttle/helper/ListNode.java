package com.shuttle.helper;

/**
 * @author: Shuttle
 * @description: ListNode
 */
public class ListNode {

    // 为了符合题意将访问权限设置为 public
    public int val;
    public ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
