package com.shuttle.algorithm.leetcode.dynamicprogramming;

import java.util.Comparator;
import java.util.stream.Stream;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/description">买卖股票的最佳时机 III</a>
 */
public class LC_0123 {

    /**
     * 解法一：动态规划
     * 时间复杂度：O(n)，n 是 prices 数组的长度
     * 空间复杂度：O(n)
     *
     * @param prices 代表每天股票价格的数组
     * @return 两次次交易能获取的最大利润
     */
    public int maxProfitSolution1(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        // 定义dp数组，包含当前天的5种状态
        /*
        dp[i][0] 初始化状态
        dp[i][1] 第一次买入
        dp[i][2] 第一次卖出
        dp[i][3] 第二次买入
        dp[i][4] 第二次卖出
         */
        int[][] dp = new int[len][5];
        // 初始化第一天的状态
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        dp[0][3] = -prices[0];
        dp[0][4] = 0;

        for (int i = 1; i < len; i++) {
            dp[i][0] = dp[i - 1][0];
            // 处理第一次买入: 只能是买了没动 / 初始状态到今天买
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            // 处理第一次卖出: 卖出了没买 / 第一次买到今天卖
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            // 处理第二次买入: 第二次买了没动 / 只能是第一次卖到第二次买
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            // 处理第二次卖出: 卖出了没买 / 第二次卖
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
        int max1 = Math.max(dp[len - 1][0], dp[len - 1][1]);
        int max2 = Math.max(dp[len - 1][2], dp[len - 1][3]);

        return Math.max(Math.max(max1, max2), dp[len - 1][4]);
    }

    /**
     * 解法二：滚动数组
     * 时间复杂度：O(n)，n 是 prices 数组的长度
     * 空间复杂度：O(1)
     *
     * @param prices 代表每天股票价格的数组
     * @return 两次次交易能获取的最大利润
     */
    public int maxProfitSolution2(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        // 代替解法一中的五种状态
        int temp1 = 0;
        int temp2 = -prices[0];
        int temp3 = 0;
        int temp4 = -prices[0];
        int temp5 = 0;

        for (int i = 1; i < len; i++) {
            temp2 = Math.max(temp2, temp1 - prices[i]);
            temp3 = Math.max(temp3, temp2 + prices[i]);
            temp4 = Math.max(temp4, temp3 - prices[i]);
            temp5 = Math.max(temp5, temp4 + prices[i]);
        }

        return Stream.of(temp2, temp3, temp4, temp5).max(Comparator.comparingInt(o -> o)).orElse(0);
    }

}
