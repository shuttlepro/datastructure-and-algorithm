package com.shuttle.datastructure.leetcode.binarytree;

import com.shuttle.helper.TreeNode;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/search-in-a-binary-search-tree/description">二叉搜索树中的搜索</a>
 */
public class LC_0700 {

    /**
     * 解法一：递归
     * 时间复杂度：O(n)，n 是节点数
     * 空间复杂度：O(n)
     *
     * @param root 给定的根节点
     * @param val  待查找的整数值
     * @return 待查找的节点，若不存在，则返回 null
     */
    public TreeNode searchBSTSolution1(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        if (root.val < val) {
            return searchBSTSolution1(root.right, val);
        } else {
            return searchBSTSolution1(root.left, val);
        }
    }

    /**
     * 解法二：迭代
     * 时间复杂度：O(n)，n 是节点数
     * 空间复杂度：O(1)
     *
     * @param root 给定的根节点
     * @param val  待查找的整数值
     * @return 待查找的节点，若不存在，则返回 null
     */
    public TreeNode searchBSTSolution2(TreeNode root, int val) {
        while (root != null) {
            if (root.val == val) {
                return root;
            }
            root = root.val > val ? root.left : root.right;
        }

        return null;
    }
}
