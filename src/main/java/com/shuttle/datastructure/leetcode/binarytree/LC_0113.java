package com.shuttle.datastructure.leetcode.binarytree;

import com.shuttle.helper.TreeNode;

import java.util.*;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/path-sum-ii/description">路径总和 II</a>
 */
public class LC_0113 {

    // path result
    List<List<Integer>> res = new ArrayList<>();
    // map 维护的是 子节点 -> 父节点 的映射关系
    Map<TreeNode, TreeNode> treeNodeMap = new HashMap<>();

    /**
     * 解法一：广度优先搜索
     * 时间复杂度：O(n²)，n 是树的结点数
     * 空间复杂度：O(n)
     *
     * @param root      给定的根节点
     * @param targetSum 目标和
     * @return 从根节点到叶子结点路径总和等于给定目标和的路径集合
     */
    public List<List<Integer>> pathSumSolution1(TreeNode root, int targetSum) {
        if (root == null) {
            return res;
        }

        // 存储当前node和sum
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> sumQueue = new LinkedList<>();
        nodeQueue.offer(root);
        sumQueue.offer(0);

        while (!nodeQueue.isEmpty()) {
            TreeNode pollNode = nodeQueue.poll();
            int sum = sumQueue.poll() + pollNode.val;

            // 如果到达叶子节点就判断是否等于 targetSum
            if (pollNode.left == null && pollNode.right == null) {
                if (sum == targetSum) {
                    res.add(getPath(pollNode));
                }
            } else {
                if (pollNode.left != null) {
                    treeNodeMap.put(pollNode.left, pollNode);
                    nodeQueue.offer(pollNode.left);
                    sumQueue.offer(sum);
                }
                if (pollNode.right != null) {
                    treeNodeMap.put(pollNode.right, pollNode);
                    nodeQueue.offer(pollNode.right);
                    sumQueue.offer(sum);
                }
            }
        }

        return res;
    }

    private List<Integer> getPath(TreeNode node) {
        List<Integer> tempList = new ArrayList<>();

        while (node != null) {
            // 一直找到根节点停止添加
            tempList.add(node.val);
            node = treeNodeMap.get(node);
        }
        // 子 -> 父，所以需要反转
        Collections.reverse(tempList);

        return tempList;
    }

    /**
     * 解法二：递归
     * 时间复杂度：O(n²)，n 是树的结点数
     * 空间复杂度：O(n)
     *
     * @param root      给定的根节点
     * @param targetSum 目标和
     * @return 从根节点到叶子结点路径总和等于给定目标和的路径集合
     */
    public List<List<Integer>> pathSumSolution2(TreeNode root, int targetSum) {
        pathTracking(root, targetSum);
        return res;
    }

    List<Integer> path = new ArrayList<>();

    private void pathTracking(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }

        path.add(root.val);
        targetSum -= root.val;

        if (root.left == null && root.right == null && targetSum == 0) {
            // 这里因为 path 是引用类型不能直接添加，如果直接添加，那么 res 中所有元素都是同一个引用
            res.add(new ArrayList<>(path));
        }

        // 查找左右子树
        pathTracking(root.left, targetSum);
        pathTracking(root.right, targetSum);
        path.removeLast();
    }
}
