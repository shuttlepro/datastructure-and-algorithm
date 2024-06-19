package com.shuttle.algorithm.leetcode.dynamicprogramming;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/description">买卖股票的最佳时机 II</a>
 */
public class LC_0122 {

    /**
     * 解法一：动态规划
     * 时间复杂度：O(n)，n 是 prices 数组的长度
     * 空间复杂度：O(n)
     *
     * @param prices 代表每天股票价格的数组
     * @return 多次交易能获取的最大利润
     */
    public int maxProfitSolution1(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int len = prices.length;
        // dp[i][0] 代表持有现金 dp[i][1] 代表持有股票
        int[][] dp = new int[len][2];
        dp[0][1] = -prices[0]; // 0 - prices[0]

        for (int i = 1; i < len; i++) {
            // 处理持有现金: 前一天持有的现金 和 今天卖出【前一天的股票 + 今天的价格】
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // 处理持有股票: 前一天持有的股票 和 今天买入【前一天的现金 - 今天的价格】
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[len - 1][0];
    }

    /**
     * 解法二：滚动数组
     * 时间复杂度：O(n)，n 是 prices 数组的长度
     * 空间复杂度：O(1)
     *
     * @param prices 代表每天股票价格的数组
     * @return 多次交易能获取的最大利润
     */
    public int maxProfitSolution2(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int len = prices.length;
        // 将解法一的二维 dp 数组用独立变量代替
        int money = 0;
        int stock = -prices[0];
        int preMoney = 0;
        int preStock = stock;

        for (int i = 1; i < len; i++) {
            money = Math.max(preMoney, preStock + prices[i]);
            stock = Math.max(preStock, preMoney - prices[i]);
            preMoney = money;
            preStock = stock;
        }

        return money;
    }

    /**
     * 解法三：贪心算法
     * 时间复杂度：O(n)，n 是 prices 数组的长度
     * 空间复杂度：O(1)
     *
     * @param prices 代表每天股票价格的数组
     * @return 多次交易能获取的最大利润
     */
    public int maxProfitSolution3(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int len = prices.length;
        int profit = 0;

        for (int i = 1; i < len; i++) {
            if (prices[i] > prices[i - 1]) {
                // 只要是正收益就交易
                profit += prices[i] - prices[i - 1];
            }
        }

        return profit;
    }

}
