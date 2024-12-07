package com.shuttle.datastructure.leetcode.binarytree;

import com.shuttle.helper.TreeNode;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/description">将有序数组转换为二叉搜索树</a>
 */
public class LC_0108 {

    /**
     * 思路：中序遍历，递归构建
     * 时间复杂度：O(n)，n 是数组长度
     * 空间复杂度：O(log n)
     *
     * @param nums 整数数组
     * @return 按规则构建树后的根节点
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    public TreeNode buildTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // 每次选取中间的位置作为 root
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        // 递归左右即可
        node.left = buildTree(nums, left, mid - 1);
        node.right = buildTree(nums, mid + 1, right);

        return node;
    }
}
