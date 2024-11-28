package com.shuttle.datastructure.leetcode.binarytree;

import com.shuttle.helper.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description">从前序与中序遍历序列构造二叉树</a>
 */
public class LC_0105 {

    /**
     * 思路：根据提供的中序遍历数组构建 <node, index> 的哈希表，然后根据先序遍历的第一个节点找到根节点，递归构建左右子树
     * 时间复杂度：O(n)，n 是 preorder 和 inorder 的长度
     * 空间复杂度：O(n)
     *
     * @param preorder 先序遍历数组
     * @param inorder  中序遍历数组
     * @return 构造二叉树后的根节点
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }

        int pLen = preorder.length;
        int iLen = inorder.length;
        for (int i = 0; i < iLen; i++) {
            inRootMap.put(inorder[i], i);
        }

        return buildTree(preorder, 0, pLen - 1, inorder, 0, iLen - 1);
    }

    // <root, index>
    Map<Integer, Integer> inRootMap = new HashMap<>();

    private TreeNode buildTree(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }

        // 先序遍历的第一个节点是根节点
        int rootVal = preorder[preLeft];
        TreeNode root = new TreeNode(rootVal);
        Integer rootIndex = inRootMap.get(rootVal);
        // 递归构建左右子树
        root.left = buildTree(preorder, preLeft + 1, rootIndex - inLeft + preLeft, inorder, inLeft, rootIndex - 1);
        root.right = buildTree(preorder, rootIndex - inLeft + preLeft + 1, preRight, inorder, rootIndex + 1, inRight);

        return root;
    }
}
