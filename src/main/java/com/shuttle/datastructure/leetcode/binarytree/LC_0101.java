package com.shuttle.datastructure.leetcode.binarytree;

import com.shuttle.helper.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/symmetric-tree/description">对称二叉树</a>
 */
public class LC_0101 {

    /**
     * 解法一：深度优先搜索
     * 时间复杂度：O(n)，n 是树的结点数
     * 空间复杂度：O(h)，h 为树的高度，最坏情况下为 O(n)。
     *
     * @param root 给定的根结点
     * @return 树是否对称
     */
    public boolean isSymmetricSolution1(TreeNode root) {
        return isSymmetricDfs(root, root);
    }

    public boolean isSymmetricDfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null || left.val != right.val) {
            return false;
        }

        return isSymmetricDfs(left.left, right.right) && isSymmetricDfs(left.right, right.left);
    }

    /**
     * 解法二：广度优先搜索
     * 时间复杂度：O(n)，n 是树的结点数
     * 空间复杂度：O(w)，w 为最宽一层的结点数，最坏情况下为 O(n)。
     *
     * @param root 给定的根结点
     * @return 树是否对称
     */
    public boolean isSymmetricSolution2(TreeNode root) {
        return isSymmetricBfs(root, root);
    }

    public boolean isSymmetricBfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(left);
        nodeQueue.offer(right);

        while (!nodeQueue.isEmpty()) {
            left = nodeQueue.poll();
            right = nodeQueue.poll();

            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null || left.val != right.val) {
                return false;
            }

            nodeQueue.offer(left.left);
            nodeQueue.offer(right.right);
            nodeQueue.offer(left.right);
            nodeQueue.offer(right.left);
        }

        return true;
    }
}
