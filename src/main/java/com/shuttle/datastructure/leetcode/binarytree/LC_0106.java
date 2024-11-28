package com.shuttle.datastructure.leetcode.binarytree;

import com.shuttle.helper.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description>从中序与后序遍历序列构造二叉树</a>
 */
public class LC_0106 {

    /**
     * 思路：根据提供的中序遍历数组构建 <node, index> 的哈希表，然后根据后序遍历的最后一个节点找到根节点，递归构建左右子树
     * 时间复杂度：O(n)，n 是 inorder 和 postorder 的长度
     * 空间复杂度：O(n)
     *
     * @param inorder   中序遍历数组
     * @param postorder 后序遍历数组
     * @return 构造二叉树后的根节点
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || postorder.length != inorder.length) {
            return null;
        }

        int length = inorder.length;
        for (int i = 0; i < length; i++) {
            inRootMap.put(inorder[i], i);
        }

        return buildTree(postorder, 0, postorder.length - 1, 0, inorder.length - 1);
    }

    // <root, index>
    Map<Integer, Integer> inRootMap = new HashMap<>();

    public TreeNode buildTree(int[] postorder, int postLeft, int postRight, int inLeft, int inRight) {
        if (inLeft > inRight || postLeft > postRight) {
            return null;
        }

        // 后序遍历的最后一个节点是根节点
        int rootVal = postorder[postRight];
        TreeNode root = new TreeNode(rootVal);
        // 递归构建左右子树
        Integer inRootIndex = inRootMap.get(rootVal);
        root.left = buildTree(postorder, postLeft, inRootIndex - inLeft + postLeft - 1, inLeft, inRootIndex - 1);
        root.right = buildTree(postorder, inRootIndex - inLeft + postLeft, postRight - 1, inRootIndex + 1, inRight);

        return root;
    }
}
