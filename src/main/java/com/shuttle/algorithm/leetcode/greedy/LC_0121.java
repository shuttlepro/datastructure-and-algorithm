package com.shuttle.algorithm.leetcode.greedy;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/description">买卖股票的最佳时机</a>
 */
public class LC_0121 {

    /**
     * 思路：一次遍历，同时维护当前 最小 price 和 最大 profit
     * 时间复杂度：O(n)，n 是 prices 数组的长度
     * 空间复杂度：O(1)
     *
     * @param prices 代表每天股票价格的数组
     * @return 一次交易所能获取的最大利润
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int maxProfit = Integer.MIN_VALUE;
        int curMinPrice = Integer.MAX_VALUE;

        for (int price : prices) {
            curMinPrice = Math.min(curMinPrice, price);
            maxProfit = Math.max(maxProfit, price - curMinPrice);
        }

        return maxProfit;
    }

}
