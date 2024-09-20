package com.shuttle.datastructure.leetcode.binarytree;

import com.shuttle.helper.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/maximum-depth-of-binary-tree/description">二叉树的最大深度</a>
 */
public class LC_0104 {

    /**
     * 思路：深度优先搜索
     * 时间复杂度：O(n)，n 是二叉树的结点个数
     * 空间复杂度：O(n)，最差情况树的高度等于结点数
     *
     * @param root 给定的根节点
     * @return 树的最大深度
     */
    public int maxDepthSolution1(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int maxLeft = maxDepthSolution1(root.left);
            int maxRight = maxDepthSolution1(root.right);

            return Math.max(maxLeft, maxRight) + 1;
        }
    }

    /**
     * 思路：广度优先搜索
     * 时间复杂度：O(n)，n 是二叉树的结点个数
     * 空间复杂度：O(n)
     *
     * @param root 给定的根节点
     * @return 树的最大深度
     */
    public int maxDepthSolution2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxDepth = 0;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);

        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();

            while (size > 0) {
                TreeNode pollNode = nodeQueue.poll();

                if (pollNode.left != null) {
                    nodeQueue.offer(pollNode.left);
                }

                if (pollNode.right != null) {
                    nodeQueue.offer(pollNode.right);
                }

                size--;
            }

            maxDepth++;
        }

        return maxDepth;
    }
}
