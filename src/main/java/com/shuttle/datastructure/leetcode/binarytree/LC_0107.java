package com.shuttle.datastructure.leetcode.binarytree;

import com.shuttle.helper.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/binary-tree-level-order-traversal-ii/description">二叉树的层序遍历 II</a>
 */
public class LC_0107 {

    /**
     * 思路：利用队列存放每级结点，每层遍历结束后，再添加到 res 中，与 {@link LC_0102} 类似
     * 时间复杂度：O(n)，n 是树的结点个数
     * 空间复杂度：O(n)
     *
     * @param root 给定的二叉树根结点
     * @return 其结点值的层序遍历
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> curLevelList = new ArrayList<>();
            int curLevelSize = queue.size();

            for (int i = 0; i < curLevelSize; i++) {
                TreeNode pollNode = queue.poll();
                curLevelList.add(pollNode.val);

                if (pollNode.left != null) {
                    queue.offer(pollNode.left);
                }
                if (pollNode.right != null) {
                    queue.offer(pollNode.right);
                }
            }

            // 过程和 LC_0102 类似，这里改成头插即可
            res.addFirst(curLevelList);
        }

        return res;
    }
}
