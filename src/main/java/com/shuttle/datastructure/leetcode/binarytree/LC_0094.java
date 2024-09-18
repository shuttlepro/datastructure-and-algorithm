package com.shuttle.datastructure.leetcode.binarytree;

import com.shuttle.helper.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/binary-tree-inorder-traversal/description">二叉树的中序遍历</a>
 */
public class LC_0094 {

    /**
     * 解法一：递归
     * 时间复杂度：O(n)，n 是树的结点数
     * 空间复杂度：O(n)，最坏情况时树的高度等于结点数
     *
     * @param root 给定的二叉树根结点
     * @return 中序遍历结果
     */
    public List<Integer> inorderTraversalSolution1(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        inorder(root, res);

        return res;
    }

    public void inorder(TreeNode root, List<Integer> nodeList) {
        if (root == null) {
            return;
        }

        inorder(root.left, nodeList);
        nodeList.add(root.val);
        inorder(root.right, nodeList);
    }

    /**
     * 解法二：迭代
     * 时间复杂度：O(n)，n 是树的结点数
     * 空间复杂度：O(n)
     *
     * @param root 给定的二叉树根结点
     * @return 中序遍历结果
     */
    public List<Integer> inorderTraversalSolution2(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Deque<TreeNode> nodeDeque = new ArrayDeque<>();

        while (root != null || !nodeDeque.isEmpty()) {
            // push 左节点直到叶子结点
            while (root != null) {
                nodeDeque.push(root);
                root = root.left;
            }

            root = nodeDeque.pop();
            res.add(root.val);
            root = root.right;
        }

        return res;
    }
}
