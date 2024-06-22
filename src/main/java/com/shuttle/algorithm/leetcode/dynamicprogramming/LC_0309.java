package com.shuttle.algorithm.leetcode.dynamicprogramming;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/description">买卖股票的最佳时机含冷冻期</a>
 */
public class LC_0309 {

    /**
     * 解法一：动态规划
     * 时间复杂度：O(n)，n 是 prices 数组的长度
     * 空间辅助度：O(n)
     *
     * @param prices 股票每日价格数组
     * @return 最大可获得利润
     */
    public int maxProfitSolution1(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int len = prices.length;
        // 当天一共可以分为三种状态
        // dp[i][0]: 当天不持有且没买入, dp[i][1]: 当天持有, dp[i][2]: 当天卖出
        int[][] dp = new int[len][3];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;

        for (int i = 1; i < len; i++) {
            // 处理状态一: 本来就不持有 / 前一天卖出
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            // 处理状态二: 前一天就持有 / 今天买入【隐含前一天一定未买入】
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            // 处理状态三: 前一天肯定持有，当天卖出
            dp[i][2] = dp[i - 1][1] + prices[i];
        }

        // 最后结果只能是当天不持有的两种情况
        return Math.max(dp[len - 1][0], dp[len - 1][2]);
    }

    /**
     * 解法一的空间优化
     * 时间复杂度：O(n)，n 是 prices 数组的长度
     * 空间复杂度：O(1)
     *
     * @param prices 股票每日价格数组
     * @return 最大可获得利润
     */
    public int maxProfitSolution2(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int len = prices.length;
        int noHold = 0;
        int hold = -prices[0];
        int sale = 0;
        int preNoHold = noHold;
        int preHold = hold;
        int preSale = sale;

        for (int i = 1; i < len; i++) {
            noHold = Math.max(preNoHold, preSale);
            hold = Math.max(preHold, preNoHold - prices[i]);
            sale = preHold + prices[i];
            preNoHold = noHold;
            preHold = hold;
            preSale = sale;
        }

        return Math.max(noHold, sale);
    }

}
