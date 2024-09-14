package com.shuttle.datastructure.leetcode.binarytree;

import com.shuttle.helper.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/binary-tree-level-order-traversal/description">二叉树的层序遍历</a>
 */
public class LC_0102 {

    /**
     * 思路：利用队列存放每级节点，每层遍历结束后，再添加到 res 中
     * 时间复杂度：O(n)，n 是树的节点个数
     * 空间复杂度：O(n)
     *
     * @param root 给定的二叉树根节点
     * @return 其节点值的层序遍历
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            // 每一层的 List
            List<Integer> curLevelList = new ArrayList<>();
            // 当前的层数的元素个数等于队列中元素的数量
            int curLevelSize = queue.size();

            for (int i = 1; i <= curLevelSize; i++) {
                // 因为是从左到右顺序放进去的，所以 poll 也是当前层从左往右的顺序
                TreeNode pollNode = queue.poll();
                curLevelList.add(pollNode.val);
                // 左右子树不为空就放到队列中
                if (pollNode.left != null) {
                    queue.offer(pollNode.left);
                }
                if (pollNode.right != null) {
                    queue.offer(pollNode.right);
                }
            }

            // 每层结束添加到 res 集合
            res.add(curLevelList);
        }

        return res;
    }
}
