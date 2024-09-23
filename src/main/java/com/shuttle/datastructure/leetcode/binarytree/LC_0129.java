package com.shuttle.datastructure.leetcode.binarytree;

import com.shuttle.helper.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/sum-root-to-leaf-numbers/description">求根节点到叶节点数字之和</a>
 */
public class LC_0129 {

    /**
     * 解法一：深度优先搜索
     * 时间复杂度：O(n)，n 是树的结点个数
     * 空间复杂度：O(h)，h 是树的高度，最坏情况下 h == n
     *
     * @param root 给定的根结点
     * @return 从根结点到叶结点数字之和
     */
    public int sumNumbersSolution1(TreeNode root) {
        // 从根结点开始，遍历每个结点，如果遇到叶子结点则将叶子结点对应的数字加到数字之和。
        // 如果当前结点不是叶子结点则计算其子结点对应的数字，然后对子结点递归遍历。
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int prevSum) {
        if (root == null) {
            return 0;
        }

        int sum = prevSum * 10 + root.val;

        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }

    /**
     * 解法二：广度优先搜索
     * 时间复杂度：O(n)，n 是树的结点个数
     * 空间复杂度：O(n)
     *
     * @param root 给定的根结点
     * @return 从根结点到叶结点数字之和
     */
    public int sumNumbersSolution2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 初始化
        int res = 0;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> sumQueue = new LinkedList<>();
        nodeQueue.offer(root);
        sumQueue.offer(root.val);

        while (!nodeQueue.isEmpty()) {
            TreeNode pollNode = nodeQueue.poll();
            Integer sum = sumQueue.poll();
            TreeNode left = pollNode.left;
            TreeNode right = pollNode.right;

            // 叶子节点直接添加
            if (left == null && right == null) {
                res += sum;
            } else {
                // 非叶子节点扩大当前值
                if (left != null) {
                    nodeQueue.offer(left);
                    sumQueue.offer(sum * 10 + left.val);
                }
                if (right != null) {
                    nodeQueue.offer(right);
                    sumQueue.offer(sum * 10 + right.val);
                }
            }
        }

        return res;
    }
}
