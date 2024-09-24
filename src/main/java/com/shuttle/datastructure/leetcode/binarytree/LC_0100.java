package com.shuttle.datastructure.leetcode.binarytree;

import com.shuttle.helper.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/same-tree/description">相同的树</a>
 */
public class LC_0100 {

    /**
     * 解法一：深度优先搜索
     * 时间复杂度：O(n)，n 是两颗二叉树的结点总数
     * 空间复杂度：O(h)，h 为树的高度，最坏情况下为 O(n)。
     *
     * @param p 根结点 p
     * @param q 根结点 q
     * @return 两棵树是否相同
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /**
     * 解法二：广度优先搜索
     * 时间复杂度：O(n)，n 是两颗二叉树的结点总数
     * 空间复杂度：O(w)，w 为最宽一层的结点数，最坏情况下为 O(n)。
     *
     * @param p 根结点 p
     * @param q 根结点 q
     * @return 两棵树是否相同
     */
    public boolean isSameTree1(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(p);
        nodeQueue.offer(q);

        while (!nodeQueue.isEmpty()) {
            p = nodeQueue.poll();
            q = nodeQueue.poll();

            if (p == null && q == null) {
                continue;
            }
            if (p == null || q == null || p.val != q.val) {
                return false;
            }

            nodeQueue.offer(p.left);
            nodeQueue.offer(q.left);
            nodeQueue.offer(p.right);
            nodeQueue.offer(q.right);
        }

        return true;
    }
}
