package com.shuttle.algorithm.leetcode.dynamicprogramming;

import java.util.List;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/triangle/description">三角形最小路径和</a>
 */
public class LC_0120 {

    /**
     * 思路：动态规划，自底向上
     * 时间复杂度：O(n²)，n 是 triangle 的 size
     * 空间复杂度：O(n²)
     *
     * @param triangle 三角形多维数组
     * @return triangle 中自顶向下的最小路径和
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) {
            return 0;
        }
        int size = triangle.size();
        int bottomSize = triangle.get(size - 1).size();
        // dp[i][j] 代表以triangle[i][j] 开始向下的最小路径和
        int[][] dp = new int[size][bottomSize];
        // 初始化最底层 dp，用于从倒数第二层开始循环
        for (int i = 0; i < bottomSize; i++) {
            dp[size - 1][i] = triangle.get(size - 1).get(i);
        }

        // 自底向上
        for (int i = size - 2; i >= 0; i--) {
            List<Integer> curList = triangle.get(i);
            int curSize = curList.size();
            for (int j = 0; j < curSize; j++) {
                dp[i][j] = curList.get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }

        return dp[0][0];
    }

}
