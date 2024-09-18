package com.shuttle.datastructure.leetcode.binarytree;

import com.shuttle.helper.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/binary-tree-preorder-traversal/description">二叉树的前序遍历</a>
 */
public class LC_0144 {

    /**
     * 解法一：递归
     * 时间复杂度：O(n)，n 是树的结点数
     * 空间复杂度：O(n)，最坏情况时树的高度等于结点数
     *
     * @param root 给定的二叉树根结点
     * @return 前序遍历结果
     */
    public List<Integer> preorderTraversalSolution1(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        preorder(root, res);

        return res;
    }

    private void preorder(TreeNode root, List<Integer> nodeList) {
        if (root == null) {
            return;
        }

        nodeList.add(root.val);
        preorder(root.left, nodeList);
        preorder(root.right, nodeList);
    }

    /**
     * 解法二：迭代
     * 时间复杂度：O(n)，n 是树的结点数
     * 空间复杂度：O(n)
     *
     * @param root 给定的二叉树根结点
     * @return 前序遍历结果
     */
    public List<Integer> preorderTraversalSolution2(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Deque<TreeNode> nodeDeque = new ArrayDeque<>();
        nodeDeque.push(root);

        while (!nodeDeque.isEmpty()) {
            TreeNode pollNode = nodeDeque.poll();
            res.add(pollNode.val);

            if (pollNode.right != null) {
                nodeDeque.push(pollNode.right);
            }
            if (pollNode.left != null) {
                nodeDeque.push(pollNode.left);
            }
        }

        return res;
    }
}
