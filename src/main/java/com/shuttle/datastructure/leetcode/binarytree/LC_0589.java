package com.shuttle.datastructure.leetcode.binarytree;

import com.shuttle.helper.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/n-ary-tree-preorder-traversal/description">N 叉树的前序遍历</a>
 */
public class LC_0589 {

    /**
     * 解法一：递归
     * 时间复杂度：O(n)，n 为节点个数
     * 空间复杂度：O(n)
     *
     * @param root 给定的根节点
     * @return 前序遍历结果
     */
    public List<Integer> preorderSolution1(Node root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    public void preorder(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }

        // 添加根节点
        res.add(root.val);

        // 遍历子节点，递归添加
        for (Node ch : root.children) {
            preorder(ch, res);
        }
    }

    /**
     * 解法二：迭代
     * 时间复杂度：O(n)，n 为节点个数
     * 空间复杂度：O(n)
     *
     * @param root 给定的根节点
     * @return 前序遍历结果
     */
    public List<Integer> preorderSolution2(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node pollNode = stack.poll();
            // 先添加根节点
            res.add(pollNode.val);

            // 遍历子节点，添加到栈中
            int size = pollNode.children.size();
            for (int i = size - 1; i >= 0; i--) {
                stack.push(pollNode.children.get(i));
            }
        }

        return res;
    }
}
