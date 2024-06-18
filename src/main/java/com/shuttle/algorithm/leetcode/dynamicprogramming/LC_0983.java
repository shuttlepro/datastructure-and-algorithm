package com.shuttle.algorithm.leetcode.dynamicprogramming;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/minimum-cost-for-tickets/description">最低票价</a>
 */
public class LC_0983 {

    /**
     * 思路：动态规划
     * 时间复杂度：O(n)，n 是 days 数组的长度
     * 空间复杂度：O(lastTravelDay + 31)
     *
     * @param days 旅行的日子
     * @param costs 旅行的花费
     * @return 在完成 days 旅行所需要的最低消费
     */
    public int mincostTickets(int[] days, int[] costs) {
        int totalTravelDays = days.length;
        // 需要旅游的最后一天和第一天
        int lastTravelDay = days[totalTravelDays - 1];
        int firstTravelDay = days[0];
        // dp[i] 表示从第 i 天开始到最后一天所需的最小费用。tip：多扩展几天，避免数组越界
        int[] dp = new int[lastTravelDay + 31];
        int travelDayIndex = totalTravelDays - 1;

        // 从最后一天开始遍历到第一天，因为这些天之外不需要出门，不会增加费用
        for (int day = lastTravelDay; day >= firstTravelDay; day--) {
            // 今天需要出门
            if (day == days[travelDayIndex]) {
                // 计算三种票价策略的最小值
                dp[day] = Math.min(dp[day + 1] + costs[0], Math.min(dp[day + 7] + costs[1], dp[day + 30] + costs[2]));
                travelDayIndex--;
            } else {
                // 今天不需要出门
                dp[day] = dp[day + 1];
            }
        }
        // 返回从 firstTravelDay 开始到最后一天所需的最小费用
        return dp[firstTravelDay];
    }

}
