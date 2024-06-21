package com.shuttle.algorithm.leetcode.dynamicprogramming;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/description">买卖股票的最佳时机 IV</a>
 */
public class LC_0188 {

    /**
     * 思路：动态规划
     * 时间复杂度：O(n * k)，n 是 prices 数组的长度，k 是允许的最大交易次数
     * 空间复杂度：O(n * k)
     *
     * @param k      允许的最大交易次数
     * @param prices 股票每日价格数组
     * @return 最大可获得利润
     */
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length < 2 || k <= 0) {
            return 0;
        }
        int days = prices.length;
        // 实际上交易一次涉及两天
        k = Math.min(days / 2, k);
        // dp[i][j][k] 代表截至到第 i 天能够交易 k 次的最大利润，j = 0 代表未持有，j = 1 代表持有
        int[][][] dp = new int[days][2][k + 1];
        for (int i = 0; i <= k; i++) {
            // 初始化 dp 数组，假设第 0 天不持有或持有
            dp[0][0][i] = 0;
            dp[0][1][i] = -prices[0];
        }

        for (int i = 1; i < days; i++) {
            for (int m = 1; m <= k; m++) {
                // 当天不持有股票：昨天就不持有 / 昨天持有今天卖了
                dp[i][0][m] = Math.max(dp[i - 1][0][m], dp[i - 1][1][m] + prices[i]);
                // 当天持有股票: 昨天持有 / 今天买的【说明昨天不持有【本来就不持有或者刚卖】，交易次数应该减一】
                dp[i][1][m] = Math.max(dp[i - 1][1][m], dp[i - 1][0][m - 1] - prices[i]);
            }
        }

        // 最后一天不持有股票且用完所有交易次数的最大利润
        return dp[days - 1][0][k];
    }

}
