package com.shuttle.algorithm.leetcode.dynamicprogramming;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/house-robber-iii/description">打家劫舍 III</a>
 */
public class LC_0337 {

    /**
     * 思路：树形动态规划
     * 时间复杂度：O(n)，n 是树中节点的个数
     * 空间复杂度：O(n)
     *
     * @param root 根节点
     * @return 在不触动警报装置的情况下，一夜之内能够偷窃到的最高金额
     */
    public int rob(TreeNode root) {
        // 定义一个 res 数组，只包含两个元素
        // res[0]: 抢劫当前节点的最大值，res[1]: 不抢劫当前节点的最大值
        int[] res = dfs(root);

        return Math.max(res[0], res[1]);
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        // 当前抢劫的最大值 = 当前节点 + 左边不抢最大 + 右边不抢最大
        int maxRob = root.val + left[1] + right[1];
        // 当前不抢劫的最大值 = max(左不抢，左抢) + max(右不抢，右抢)
        int noRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{maxRob, noRob};
    }

    static class TreeNode {

        private TreeNode left;

        private TreeNode right;

        private int val;

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

    }

}
