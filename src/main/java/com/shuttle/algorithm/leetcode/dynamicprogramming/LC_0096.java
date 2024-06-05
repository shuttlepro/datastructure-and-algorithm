package com.shuttle.algorithm.leetcode.dynamicprogramming;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/unique-binary-search-trees/description">不同的二叉搜索树</a>
 */
public class LC_0096 {

    /**
     * 思路：动态规划
     * 时间复杂度：O(n²)，n 表示二叉搜索树的节点个数
     * 空间复杂度：O(n)，dp 数组
     *
     * @param n 节点数
     * @return 由 n 个节点组成且节点值从 1 到 n 互不相同的二叉搜索树种数
     */
    public int numTrees(int n) {
        // dp[i] 代表从 1 ~ i 能组成 dp[i] 种互不相同的二叉搜索树
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                /**
                 * 以 j 为根节点时：
                 * 左子树的节点是从 1 到 j - 1，一共有 j - 1 个节点。
                 * 右子树的节点是从 j + 1 到 i，一共有 i - j 个节点。
                 * 对于每个 i，不同的二叉搜索树的数量就是所有可能的以 1 到 i 为根节点的树的数量之和。
                 * 如果选择 j 作为根节点，那么：
                 * 左子树可以有 dp[j - 1] 种不同的组成方式（因为左子树的节点是 j - 1 个）。
                 * 右子树可以有 dp[i - j] 种不同的组成方式（因为右子树的节点是 i - j 个）。
                 * 因为左子树和右子树是独立的，所以以 j 为根的树的总数量就是左子树的数量乘以右子树的数量，即 dp[j - 1] * dp[i - j]。
                 * 通过遍历所有可能的 j（从 1 到 i），把这些数量加起来，就得到了 i 个节点能组成的所有不同的二叉搜索树的数量。
                 */
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }

}
