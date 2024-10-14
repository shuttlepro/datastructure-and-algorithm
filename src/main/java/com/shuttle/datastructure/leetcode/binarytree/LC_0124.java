package com.shuttle.datastructure.leetcode.binarytree;

import com.shuttle.helper.TreeNode;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/binary-tree-maximum-path-sum/description">二叉树中的最大路径和</a>
 */
public class LC_0124 {

    int max = Integer.MIN_VALUE;

    /**
     * 思路：递归
     * 时间复杂度：O(n)，n 是二叉树的结点个数
     * 空间复杂度：O(h)，h 是二叉树的高度，最坏情况 h == n
     *
     * @param root 给定的根结点
     * @return 最大路径和
     */
    public int maxPathSum(TreeNode root) {
        dfs(root);

        return max;
    }

    /**
     * 返回经过 root 的单边分支最大和，Math.max(root, root + left, root + right)
     */
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 计算左右边分支最大值，如果为负数则不选择
        int leftMax = Math.max(0, dfs(root.left));
        int rightMax = Math.max(0, dfs(root.right));

        // left -> root -> right 作为路径与已经计算过历史最大值做比较
        max = Math.max(root.val + leftMax + rightMax, max);

        // 返回经过 root 的单边最大分支给当前 root 的父结点计算使用
        return root.val + Math.max(leftMax, rightMax);
    }
}
