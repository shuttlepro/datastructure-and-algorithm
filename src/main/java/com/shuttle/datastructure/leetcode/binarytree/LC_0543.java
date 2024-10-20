package com.shuttle.datastructure.leetcode.binarytree;

import com.shuttle.helper.TreeNode;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/diameter-of-binary-tree/description">二叉树的直径</a>
 */
public class LC_0543 {

    int res = 0;

    /**
     * 思路：深度优先搜索
     * 时间复杂度：O(n)，n 是树的结点个数
     * 空间复杂度：O(h)，h 是树的高度，最坏情况 h == n
     *
     * @param root 给定的根结点
     * @return 该二叉树的直径
     */
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return res;
    }

    public int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // 计算左右边最深的深度
        int left = depth(node.left);
        int right = depth(node.right);
        // 结果等于左右子树最深深度之和
        res = Math.max(left + right, res);

        return Math.max(left, right) + 1;
    }
}
