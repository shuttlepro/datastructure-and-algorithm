package com.shuttle.datastructure.leetcode.binarytree;

import com.shuttle.helper.TreeNode;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/longest-univalue-path/description">最长同值路径</a>
 */
public class LC_0687 {

    int longestUnivaluePath = 0;

    /**
     * 思路：深度优先搜索
     * 时间复杂度：O(n)，n 是树的结点个数
     * 空间复杂度：O(h)，h 是树的高度，最坏情况 h == n
     *
     * @param root 给定的根结点
     * @return 最长同值路径长度
     */
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);

        return longestUnivaluePath;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 本结点的其中一条路径
        int temp = 0;
        // 本结点所有路径
        int all = 0;
        int nextL = dfs(root.left);
        int nextR = dfs(root.right);

        // 左右对比
        if (root.left != null && root.left.val == root.val) {
            temp = nextL + 1;
            all += nextL + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            // 取大的那条分支返回
            temp = Math.max(temp, nextR + 1);
            all += nextR + 1;
        }

        // 这里做累加，考虑这个结点及以下左右分支合起来组成一个最长同值路径
        longestUnivaluePath = Math.max(longestUnivaluePath, all);

        return temp;
    }
}
