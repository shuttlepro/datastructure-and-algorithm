package com.shuttle.datastructure.leetcode.binarytree;

import com.shuttle.helper.TreeNode;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/insert-into-a-binary-search-tree/description">二叉搜索树中的插入操作</a>
 */
public class LC_0701 {

    /**
     * 解法一：递归
     * 时间复杂度：O(n)，n 是树的节点个数
     * 空间复杂度：O(n)
     *
     * @param root 树的根节点
     * @param val  待插入的值
     * @return 插入后的根节点
     */
    public TreeNode insertIntoBSTSolution1(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        // 如果当前值大于目标值，递归左子树
        if (root.val > val) {
            root.left = insertIntoBSTSolution1(root.left, val);
        } else {
            // 否则递归右子树
            root.right = insertIntoBSTSolution1(root.right, val);
        }

        return root;
    }

    /**
     * 解法二：迭代
     * 时间复杂度：O(n)，n 是树的节点个数
     * 空间复杂度：O(1)
     *
     * @param root 树的根节点
     * @param val  待插入的值
     * @return 插入后的根节点
     */
    public TreeNode insertIntoBSTSolution2(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        // 记录当前节点
        TreeNode curNode = root;

        while (true) {
            // 如果当前节点值大于目标值，说明目标值需要插入左子树其中一个节点的左边，遍历左子树即可
            if (curNode.val > val) {
                if (curNode.left == null) {
                    curNode.left = new TreeNode(val);
                    break;
                } else {
                    curNode = curNode.left;
                }
            } else {
                // 如果当前节点值小于目标值，说明目标值需要插入右子树其中一个节点的右边，遍历右子树即可
                if (curNode.right == null) {
                    curNode.right = new TreeNode(val);
                    break;
                } else {
                    curNode = curNode.right;
                }
            }
        }

        return root;
    }
}
