package com.shuttle.datastructure.leetcode.binarytree;

import com.shuttle.helper.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/n-ary-tree-level-order-traversal/description">N 叉树的层序遍历</a>
 */
public class LC_0429 {

    /**
     * 思路：和 {@link LC_0102} 类似，但是需要遍历子集合
     * 时间复杂度：O(n)，n 是节点个数
     * 空间复杂度：O(n)
     *
     * @param root 给定的根节点
     * @return 层序遍历结果
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);

        while (!nodeQueue.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            // 当前层的元素个数等于队列中的元素个数
            int curLevelSize = nodeQueue.size();
            for (int i = 0; i < curLevelSize; i++) {
                // 遍历
                Node pollNode = nodeQueue.poll();
                levelList.add(pollNode.val);
                // 遍历子集合
                for (Node child : pollNode.children) {
                    nodeQueue.offer(child);
                }
            }

            res.add(levelList);
        }

        return res;
    }
}
