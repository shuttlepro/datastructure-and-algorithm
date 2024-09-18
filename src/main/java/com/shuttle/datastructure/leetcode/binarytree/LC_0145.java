package com.shuttle.datastructure.leetcode.binarytree;

import com.shuttle.helper.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/binary-tree-postorder-traversal/description">二叉树的后序遍历</a>
 */
public class LC_0145 {

    /**
     * 解法一：递归
     * 时间复杂度：O(n)，n 是树的结点数
     * 空间复杂度：O(n)，最坏情况时树的高度等于结点数
     *
     * @param root 给定的二叉树根结点
     * @return 后序遍历结果
     */
    public List<Integer> postorderTraversalSolution1(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        postorder(root, res);

        return res;
    }

    private void postorder(TreeNode root, List<Integer> nodeList) {
        if (root == null) {
            return;
        }

        postorder(root.left, nodeList);
        postorder(root.right, nodeList);
        nodeList.add(root.val);
    }

    /**
     * 解法二：迭代
     * 与中序的不同之处在于：
     * 中序遍历中，从栈中弹出的结点，其左子树是访问完了，可以直接访问该结点，然后接下来访问右子树。
     * 后序遍历中，从栈中弹出的结点，只能确定其左子树肯定访问完了，但是无法确定右子树是否访问过。
     * 因此，在后序遍历中，引入了一个 prev 来记录历史访问记录。当访问完一棵子树的时候，用 prev 指向该结点。
     * 这样，在回溯到父结点的时候，可以依据 prev 是指向左子结点，还是右子结点，来判断父结点的访问情况。
     * 时间复杂度：O(n)，n 是树的结点数
     * 空间复杂度：O(n)
     *
     * @param root 给定的二叉树根结点
     * @return 后序遍历结果
     */
    public List<Integer> postorderTraversalSolution2(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Deque<TreeNode> nodeDeque = new ArrayDeque<>();
        // 需要记录历史访问结点
        TreeNode prev = null;

        while (root != null || !nodeDeque.isEmpty()) {
            while (root != null) {
                nodeDeque.push(root);
                root = root.left;
            }

            root = nodeDeque.pop();

            if (root.right != null && root.right != prev) {
                nodeDeque.push(root);
                root = root.right;
            } else {
                res.add(root.val);
                // 更新上次访问的记录
                prev = root;
                // 避免重复访问左子树
                root = null;
            }
        }

        return res;
    }
}
