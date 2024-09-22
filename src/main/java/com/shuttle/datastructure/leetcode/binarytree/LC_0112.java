package com.shuttle.datastructure.leetcode.binarytree;

import com.shuttle.helper.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/path-sum/description">路径总和</a>
 */
public class LC_0112 {

    /**
     * 思路：广度优先搜索
     * 时间复杂度：O(n)，n 是树的结点个数
     * 空间复杂度：O(n)
     *
     * @param root      给定的根节点
     * @param targetSum 目标和
     * @return 树中是否存在路径和为 targetSum
     */
    public boolean hasPathSumSolution1(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        // 两个队列分别存储当前 node 和 node value
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> valQueue = new LinkedList<>();
        nodeQueue.offer(root);
        valQueue.offer(root.val);

        while (!nodeQueue.isEmpty()) {
            TreeNode treeNode = nodeQueue.poll();
            Integer value = valQueue.poll();

            // 说明到达叶子节点，判断是否和target相等
            if (treeNode.left == null && treeNode.right == null) {
                if (value == targetSum) {
                    return true;
                }
                continue;
            }

            // 不相等就把左右子树的值分别加上放入队列中
            if (treeNode.left != null) {
                nodeQueue.offer(treeNode.left);
                valQueue.offer(value + treeNode.left.val);
            }
            if (treeNode.right != null) {
                nodeQueue.offer(treeNode.right);
                valQueue.offer(value + treeNode.right.val);
            }
        }

        return false;
    }

    /**
     * 思路：递归
     * 时间复杂度：O(n)，n 是树的结点个数
     * 空间复杂度：O(h)，h 是树的高度，最坏情况 h == n
     *
     * @param root      给定的根节点
     * @param targetSum 目标和
     * @return 树中是否存在路径和为 targetSum
     */
    public boolean hasPathSumSolution2(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        return hasPathSumSolution2(root.left, targetSum - root.val)
                || hasPathSumSolution2(root.right, targetSum - root.val);
    }
}
