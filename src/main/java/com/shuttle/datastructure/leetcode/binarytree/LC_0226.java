package com.shuttle.datastructure.leetcode.binarytree;

import com.shuttle.helper.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/invert-binary-tree/description">翻转二叉树</a>
 */
public class LC_0226 {

    /**
     * 解法一：递归
     * 时间复杂度：O(n)，n 是二叉树的结点个数
     * 空间复杂度：O(h)，h 是二叉树的高度，最坏情况 h == n
     *
     * @param root 给定的根结点
     * @return 翻转后的根结点
     */
    public TreeNode invertTreeSolution1(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTreeSolution1(root.left);
        invertTreeSolution1(root.right);

        return root;
    }

    /**
     * 解法二：广度优先搜索
     * 时间复杂度：O(n)，n 是二叉树的结点个数
     * 空间复杂度：O(n)
     *
     * @param root 给定的根结点
     * @return 翻转后的根结点
     */
    public TreeNode invertTreeSolution2(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);

        while (!nodeQueue.isEmpty()) {
            TreeNode pollNode = nodeQueue.poll();
            // 交换
            TreeNode temp = pollNode.left;
            pollNode.left = pollNode.right;
            pollNode.right = temp;

            if (pollNode.left != null) {
                nodeQueue.offer(pollNode.left);
            }
            if (pollNode.right != null) {
                nodeQueue.offer(pollNode.right);
            }
        }

        return root;
    }
}
