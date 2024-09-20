package com.shuttle.datastructure.leetcode.binarytree;

import com.shuttle.helper.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/minimum-depth-of-binary-tree/description">二叉树的最小深度</a>
 */
public class LC_0111 {

    /**
     * 思路：深度优先搜索
     * 时间复杂度：O(n)，n 是二叉树的结点个数
     * 空间复杂度：O(n)，最差情况树的高度等于结点数
     *
     * @param root 给定的根节点
     * @return 树的最小深度
     */
    public int minDepthSolution1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int minDepth = Integer.MAX_VALUE;

        if (root.left != null) {
            minDepth = Math.min(minDepthSolution1(root.left), minDepth);
        }

        if (root.right != null) {
            minDepth = Math.min(minDepthSolution1(root.right), minDepth);
        }

        return minDepth + 1;
    }

    /**
     * 思路：广度优先搜索
     * 时间复杂度：O(n)，n 是二叉树的结点个数
     * 空间复杂度：O(n)
     *
     * @param root 给定的根节点
     * @return 树的最小深度
     */
    public int minDepthSolution2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 1));

        while (!queue.isEmpty()) {
            Pair pollNode = queue.poll();
            TreeNode treeNode = pollNode.treeNode;
            int depth = pollNode.depth;

            if (treeNode.left == null && treeNode.right == null) {
                return depth;
            }

            if (treeNode.left != null) {
                queue.offer(new Pair(treeNode.left, depth + 1));
            }

            if (treeNode.right != null) {
                queue.offer(new Pair(treeNode.right, depth + 1));
            }
        }

        return 0;
    }

    static class Pair {
        TreeNode treeNode;
        int depth;

        public Pair(TreeNode treeNode, int depth) {
            this.treeNode = treeNode;
            this.depth = depth;
        }
    }
}
