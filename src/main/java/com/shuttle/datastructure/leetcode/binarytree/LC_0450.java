package com.shuttle.datastructure.leetcode.binarytree;

import com.shuttle.helper.TreeNode;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/delete-node-in-a-bst/description">删除二叉搜索树中的节点</a>
 */
public class LC_0450 {

    /**
     * 解法一：递归
     * 时间复杂度：O(n)，n 是节点个数
     * 空间复杂度：O(n)
     *
     * @param root 给定的根节点
     * @param key  要删除的节点的值
     * @return 删除节点值后的根节点
     */
    public TreeNode deleteNodeSolution1(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        // 当前节点大于 key，说明在待删除节点在左子树，递归查找
        if (root.val > key) {
            root.left = deleteNodeSolution1(root.left, key);
            return root;
        } else if (root.val < key) {
            root.right = deleteNodeSolution1(root.right, key);
            return root;
        }
        // 找到需要删除的节点，有四种情况
        else {
            // 情况一：左右子树都为空，直接返回 null
            if (root.left == null && root.right == null) {
                return null;
            }
            // 情况二：左子树为空，返回右子树
            if (root.left == null) {
                return root.right;
            }
            // 情况三：右子树为空，返回左子树
            if (root.right == null) {
                return root.left;
            }
            // 情况四：都不为空，找到继承节点，也就是右子树中最小或左子树最大的那个节点
            TreeNode successor = root.left;
            while (successor.right != null) {
                successor = successor.right;
            }
            // 从 root 的左子树中将 successor 删除
            root.left = deleteNodeSolution1(root.left, successor.val);
            successor.left = root.left;
            successor.right = root.right;

            return successor;
        }
    }

    /**
     * 解法二：迭代
     * 时间复杂度：O(n)，n 是节点个数
     * 空间复杂度：O(1)
     *
     * @param root 给定的根节点
     * @param key  要删除的节点的值
     * @return 删除节点值后的根节点
     */
    public TreeNode deleteNodeSolution2(TreeNode root, int key) {
        TreeNode cur = root;
        TreeNode curParent = null;

        // 寻找需要删除的节点及其父节点
        while (cur != null && cur.val != key) {
            curParent = cur;
            if (cur.val > key) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }

        // 如果没有找到需要删除的节点，直接返回原树
        if (cur == null) {
            return root;
        }

        // 分为以下四种情况
        if (cur.left == null && cur.right == null) {
            // 情况一：左右子树都为空，直接删除节点
            cur = null;
        } else if (cur.right == null) {
            // 情况二：右子树为空，用左子树替代
            cur = cur.left;
        } else if (cur.left == null) {
            // 情况三：左子树为空，用右子树替代
            cur = cur.right;
        } else {
            // 情况四：左右子树都不为空，找到右子树中的最小节点作为继承节点
            TreeNode successor = cur.right;
            TreeNode successorParent = cur;

            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }

            // 从右子树中删除继承节点
            if (successorParent.val == cur.val) {
                successorParent.right = successor.right;
            } else {
                successorParent.left = successor.right;
            }

            // 将继承节点的左右子树设置为当前节点的左右子树
            successor.right = cur.right;
            successor.left = cur.left;

            // 用继承节点替代当前节点
            cur = successor;
        }

        // 更新父节点的引用
        if (curParent == null) {
            // 如果删除的是根节点，直接返回新的根节点
            return cur;
        } else {
            if (curParent.left != null && curParent.left.val == key) {
                curParent.left = cur;
            } else {
                curParent.right = cur;
            }
            return root;
        }
    }
}
