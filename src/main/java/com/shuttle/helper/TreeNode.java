package com.shuttle.helper;

/**
 * @author: Shuttle
 * @description: TreeNode
 */
public class TreeNode {

    // 为了符合题意将访问权限设置为 public
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
