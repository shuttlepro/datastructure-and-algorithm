package com.shuttle.datastructure.leetcode.binarytree;

import com.shuttle.helper.Node;

import java.util.*;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/n-ary-tree-postorder-traversal/description">N 叉树的后序遍历</a>
 */
public class LC_0590 {

    /**
     * 解法一：递归
     * 时间复杂度：O(n)，n 是节点个数
     * 空间复杂度：O(n)
     *
     * @param root 给定的根节点
     * @return 后序遍历结果
     */
    public List<Integer> postorderSolution1(Node root) {
        List<Integer> res = new ArrayList<>();
        postOrder(root, res);
        return res;
    }

    public void postOrder(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }
        for (Node ch : root.children) {
            postOrder(ch, res);
        }
        res.add(root.val);
    }

    /**
     * 解法二：将节点按层级顺序入栈后逆序返回
     * 时间复杂度：O(n)，n 是节点个数
     * 空间复杂度：O(n)
     *
     * @param root 给定的根节点
     * @return 后序遍历结果
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
            res.add(pollNode.val);
            for (Node child : pollNode.children) {
                stack.push(child);
            }
        }
        Collections.reverse(res);

        return res;
    }

    /**
     * 解法三：解法二基础上进行优化，使用额外的空间记录访问过的节点
     * 时间复杂度：O(n)，n 是节点个数
     * 空间复杂度：O(n)
     *
     * @param root 给定的根节点
     * @return 后序遍历结果
     */
    public List<Integer> preorderSolution3(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<Node> stack = new ArrayDeque<>();
        // 记录当前节点是否已经被遍历过
        Set<Node> isVisited = new HashSet<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            // 需要查看栈顶元素是否是叶子节点或已经被遍历过
            Node peekNode = stack.peek();
            int size = peekNode.children.size();

            if (size == 0 || isVisited.contains(peekNode)) {
                // 满足条件就弹出，并且将值加入res中
                stack.pop();
                res.add(peekNode.val);
                continue;
            }

            // 不满足就反向遍历，栈的特性可以在弹出的时候从左往右依次弹出
            for (int i = size - 1; i >= 0; i--) {
                stack.push(peekNode.children.get(i));
            }
            // 记录当前节点遍历状态
            isVisited.add(peekNode);
        }

        return res;
    }
}
