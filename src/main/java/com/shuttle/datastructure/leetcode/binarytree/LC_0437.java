package com.shuttle.datastructure.leetcode.binarytree;

import com.shuttle.helper.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/path-sum-iii/description">路径总和 III</a>
 */
public class LC_0437 {

    /**
     * 解法一：深度优先搜索
     * 时间复杂度：O(n²)，n 是二叉树的结点数
     * 空间复杂度：O(h)，h 是二叉树的高度，最坏情况 h == n
     *
     * @param root      给定的根结点
     * @param targetSum 路径总和
     * @return 二叉树里结点值之和等于 targetSum 的路径数目
     */
    public int pathSumSolution1(TreeNode root, long targetSum) {
        if (root == null) {
            return 0;
        }

        int res = rootSum(root, targetSum);
        res += pathSumSolution1(root.left, targetSum);
        res += pathSumSolution1(root.right, targetSum);

        return res;
    }

    public int rootSum(TreeNode root, long targetSum) {
        int count = 0;

        if (root == null) {
            return 0;
        }

        int val = root.val;
        if (val == targetSum) {
            count++;
        }

        count += rootSum(root.left, targetSum - val);
        count += rootSum(root.right, targetSum - val);

        return count;
    }

    /**
     * 解法二：前缀和
     * 时间复杂度：O(n)，n 是二叉树的结点数
     * 空间复杂度：O(n)
     *
     * @param root      给定的根结点
     * @param targetSum 路径总和
     * @return 二叉树里结点值之和等于 targetSum 的路径数目
     */
    public int pathSumSolution2(TreeNode root, long targetSum) {
        target = targetSum;
        // 把根到叶子的情况考虑进去。举个例子 {1，1}，2。如果不加的话是 0
        prefixSum2CountMap.put(0L, 1);

        return dfs(root, 0);
    }

    // 用哈希表统计 <前缀和, 个数>
    Map<Long, Integer> prefixSum2CountMap = new HashMap<>();
    long target = 0;

    private int dfs(TreeNode root, long curSum) {
        if (root == null) {
            return 0;
        }

        // res 就是路径数量 curSum 是根节点到当前结点的前缀和，
        // 如果哈希表中能找到之前存在过路径的前缀和为 curSum - target，
        // 说明可以找到 val 条路径使其路径和为 target。
        curSum += root.val;
        int res = prefixSum2CountMap.getOrDefault(curSum - target, 0);
        // 保存前缀和
        prefixSum2CountMap.put(curSum, prefixSum2CountMap.getOrDefault(curSum, 0) + 1);

        int left = 0;
        int right = 0;
        if (root.left != null) {
            left = dfs(root.left, curSum);
        }
        if (root.right != null) {
            right = dfs(root.right, curSum);
        }

        // 路径恢复，因为当前前缀和只对自己结点的叶子有效，防止左右两边有相同前缀和影响
        prefixSum2CountMap.put(curSum, prefixSum2CountMap.get(curSum) - 1);

        return res + left + right;
    }
}
