package com.shuttle.datastructure.leetcode.binarytree;

import com.shuttle.helper.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/description">二叉树展开为链表</a>
 */
public class LC_0114 {

    /**
     * 解法一：递归
     * 时间复杂度：O(n)，n 是二叉树的结点个数
     * 空间复杂度：O(n)
     *
     * @param root 给定的二叉树根结点
     */
    public void flattenSolution1(TreeNode root) {
        if (root == null) {
            return;
        }

        List<TreeNode> nodeList = new ArrayList<>();

        // 将前序遍历结果保存到 nodeList 中
        preorder(root, nodeList);
        int size = nodeList.size();

        for (int i = 1; i < size; i++) {
            TreeNode prev = nodeList.get(i - 1);
            TreeNode cur = nodeList.get(i);
            prev.left = null;
            prev.right = cur;
        }
    }

    private void preorder(TreeNode root, List<TreeNode> nodeList) {
        if (root != null) {
            nodeList.add(root);
            preorder(root.left, nodeList);
            preorder(root.right, nodeList);
        }
    }

    /**
     * 解法二：迭代
     * 时间复杂度：O(n)，n 是二叉树的结点个数
     * 空间复杂度：O(1)
     *
     * @param root 给定的二叉树根结点
     */
    public void flattenSolution2(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode cur = root;

        while (cur != null) {
            if (cur.left != null) {
                TreeNode next = cur.left;
                TreeNode temp = next;

                // 找到左子树的最右侧节点 temp
                while (temp.right != null) {
                    temp = temp.right;
                }

                // 将 temp 的右子树设置为当前节点的右子树
                temp.right = cur.right;
                // 将当前节点的左子树设置为 null
                cur.left = null;
                // 将当前节点的右子树设置为左子树
                cur.right = next;
            }

            // 将当前节点更新为其右子树，继续遍历
            cur = cur.right;
        }
    }
}
