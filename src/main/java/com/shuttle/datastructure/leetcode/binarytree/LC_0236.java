package com.shuttle.datastructure.leetcode.binarytree;

import com.shuttle.helper.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/description">二叉树的最近公共祖先</a>
 */
public class LC_0236 {

    /**
     * 解法一：递归
     * p 和 q 可能存在两种情况
     * 情况一：p 和 q 分布在当前根的左子树和右子树上面，此时当前根就是二者最近公共祖先
     * 情况二：分布在当前根的某一边子树上，此时 p 和 q 其中之一就是当前最近公共祖先
     * 时间复杂度：O(n)，n 是节点个数
     * 空间复杂度：O(h)，h 是树的高度，最坏情况下 h = n
     *
     * @param root 给定的根节点
     * @param p    节点 p
     * @param q    节点 q
     * @return 最近公共祖先节点
     */
    public TreeNode lowestCommonAncestorSolution1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestorSolution1(root.left, p, q);
        TreeNode right = lowestCommonAncestorSolution1(root.right, p, q);

        // 情况一，直接返回根节点即可
        if (left != null && right != null) {
            return root;
        }
        // 情况二，需要判断 left 和 right 哪个为空
        return left != null ? left : right;
    }

    /**
     * 解法二：利用 HashMap 存储节点值与父节点的映射关系，另外使用 HashSet 存储已经访问过的节点，通过二者寻找到最近公共祖先
     * 时间复杂度：O(n)，n 是节点个数
     * 空间复杂度：O(n)
     *
     * @param root 给定的根节点
     * @param p    节点 p
     * @param q    节点 q
     * @return 最近公共祖先节点
     */
    public TreeNode lowestCommonAncestorSolution2(TreeNode root, TreeNode p, TreeNode q) {
        putFatherNodeInMap(root);
        while (p != null) {
            // 从 p 开始将当前值标记为已遍历，且层层往上直到 root
            visited.add(p.val);
            p = nodeVal2FatherNode.get(p.val);
        }
        while (q != null) {
            // 从 q 开始层层往上寻找第一个已经访问过的节点
            if (visited.contains(q.val)) {
                return q;
            }
            q = nodeVal2FatherNode.get(q.val);
        }

        return null;
    }

    // <当前值，当前节点的父节点>
    Map<Integer, TreeNode> nodeVal2FatherNode = new HashMap<>();
    // 是否被访问过
    Set<Integer> visited = new HashSet<>();

    private void putFatherNodeInMap(TreeNode root) {
        if (root.left != null) {
            nodeVal2FatherNode.put(root.left.val, root);
            putFatherNodeInMap(root.left);
        }
        if (root.right != null) {
            nodeVal2FatherNode.put(root.right.val, root);
            putFatherNodeInMap(root.right);
        }
    }
}
