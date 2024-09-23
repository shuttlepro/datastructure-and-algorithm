package com.shuttle.datastructure.leetcode.binarytree;

import com.shuttle.helper.TreeNode;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/merge-two-binary-trees/description">合并二叉树</a>
 */
public class LC_0617 {

    /**
     * 思路：递归
     * 时间复杂度：O(n + m)，n 是树 1 的结点数，m 是树 2 的结点数
     * 空间复杂度：O(h)，h 是树的高度
     *
     * @param root1 给定的 1 号根结点
     * @param root2 给定的 2 号根结点
     * @return 合并后的二叉树
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return root1 == null ? root2 : root1;
        }

        TreeNode mergeNode = new TreeNode(root1.val + root2.val);
        mergeNode.left = mergeTrees(root1.left, root2.left);
        mergeNode.right = mergeTrees(root1.right, root2.right);

        return mergeNode;
    }
}
