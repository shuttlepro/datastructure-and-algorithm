package com.shuttle.datastructure.leetcode.binarytree;

import com.shuttle.helper.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/count-complete-tree-nodes/description">完全二叉树的结点个数</a>
 */
public class LC_0222 {

    /**
     * 解法一：深度优先搜索
     * 时间复杂度：O(n)，n 是树的结点个数
     * 空间复杂度：O(h)，h 为树的高度，最坏情况下 h == n
     *
     * @param root 给定的根结点
     * @return 完全二叉树的结点个数
     */
    public int countNodesSolution1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = countNodesSolution1(root.left);
        int right = countNodesSolution1(root.right);

        return left + right + 1;
    }

    /**
     * 解法二：广度优先搜索
     * 时间复杂度：O(n)，n 是树的结点个数
     * 空间复杂度：O(n)
     *
     * @param root 给定的根结点
     * @return 完全二叉树的结点个数
     */
    public int countNodesSolution2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        int count = 0;

        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();

            while (size > 0) {
                size--;
                TreeNode cur = nodeQueue.poll();
                count++;

                if (cur.left != null) {
                    nodeQueue.offer(cur.left);
                }
                if (cur.right != null) {
                    nodeQueue.offer(cur.right);
                }
            }
        }

        return count;
    }

    /**
     * 解法三：完全二叉树特有的解法
     * 时间复杂度：O(log² n)，n 是树的结点个数
     * 空间复杂度：O(n)
     *
     * @param root 给定的根结点
     * @return 完全二叉树的结点个数
     */
    public int countNodesSolution3(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);

        if (leftDepth == rightDepth) {
            // 左子树是满二叉树
            return (1 << leftDepth) + countNodesSolution3(root.right);
        } else {
            // 右子树是满二叉树
            return (1 << rightDepth) + countNodesSolution3(root.left);
        }
    }

    private int getDepth(TreeNode root) {
        int depth = 0;

        while (root != null) {
            root = root.left;
            depth++;
        }

        return depth;
    }
}
