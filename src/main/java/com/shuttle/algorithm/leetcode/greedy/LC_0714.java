package com.shuttle.algorithm.leetcode.greedy;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description">买卖股票的最佳时机含手续费</a>
 */
public class LC_0714 {

    /**
     * 解法一、二和 买卖股票的最佳时机II（LC_0122）一样，仅在计算费用时多扣除 fee 即可，不再赘述
     * 这里介绍第三种：贪心算法
     * 时间复杂度：O(n)，n 是 prices 数组的长度
     * 空间复杂度：O(1)
     *
     * @param prices 代表每天股票价格的数组
     * @param fee    交易产生的额外费用
     * @return 最大可获得利润
     */
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int len = prices.length;
        int maxProfit = 0;
        // 记录前一天买股票需要的钱
        int preBuy = prices[0] + fee;

        for (int i = 1; i < len; i++) {
            if (prices[i] + fee < preBuy) {
                // 如果今天的价格 + fee 要小于前一天的费用，说明当天是更好的买入时机
                preBuy = prices[i] + fee;
            } else if (prices[i] > preBuy) {
                /*
                  只要当前价格高于之前的买入成本（即使未来某天价格可能更高），就立即卖出并累加利润到 maxProfit。
                  同时更新 preBuy 为当前卖出后的成本。
                 */
                maxProfit += prices[i] - preBuy;
                preBuy = prices[i];
            }
        }

        return maxProfit;
    }

}
