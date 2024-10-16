package com.shuttle.datastructure.leetcode.binarytree;

import com.shuttle.helper.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/binary-tree-right-side-view/description">二叉树的右视图</a>
 */
public class LC_0199 {

    /**
     * 解法一：广度优先遍历
     * 时间复杂度：O(n)，n 是二叉树的结点数量
     * 空间复杂度：O(n)
     *
     * @param root 给定的根结点
     * @return 返回从右侧所能看到的结点值组成的列表
     */
    public List<Integer> rightSideViewSolution1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);

        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();

            for (int i = 0; i < size; i++) {
                TreeNode pollNode = nodeQueue.poll();

                if (pollNode.left != null) {
                    nodeQueue.offer(pollNode.left);
                }
                if (pollNode.right != null) {
                    nodeQueue.offer(pollNode.right);
                }

                // 说明已经访问到当前层级下的最右边的元素了
                if (i == size - 1) {
                    res.add(pollNode.val);
                }
            }
        }

        return res;
    }

    /**
     * 解法二：深度优先遍历
     * 时间复杂度：O(n)，n 是树的结点数量
     * 空间复杂度：O(h)，h 为树的高度，最坏情况 h == n
     *
     * @param root 给定的根结点
     * @return 返回从右侧所能看到的结点值组成的列表
     */
    public List<Integer> rightSideViewSolution2(TreeNode root) {
        dfs(root, 0);

        return res;
    }

    List<Integer> res = new ArrayList<>();

    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }

        // 先访问当前结点，再递归访问右子树和左子树
        // 如果当前结点所在深度还没有出现在 res 里，说明该深度下当前结点是第一个被访问的结点
        if (depth == res.size()) {
            res.add(root.val);
        }

        depth++;
        dfs(root.right, depth);
        dfs(root.left, depth);
    }
}
