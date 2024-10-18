package com.shuttle.datastructure.leetcode.binarytree;

import com.shuttle.helper.TreeNode;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/balanced-binary-tree/description">平衡二叉树</a>
 */
public class LC_0110 {

    /**
     * 思路：递归求解当前结点的高度，判断左右子树高度是否相差超过 1
     * 时间复杂度：O(n)，n 是树的结点个数
     * 空间复杂度：O(n)
     *
     * @param root 给定的根节点
     * @return 该树是否平衡二叉树
     */
    public boolean isBalanced(TreeNode root) {
        return balanced(root) != -1;
    }

    private int balanced(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = balanced(node.left);
        int rightHeight = balanced(node.right);

        // 如果左子树或右子树或左右子树高度相差超过 1 说明该树不为平衡二叉树
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
