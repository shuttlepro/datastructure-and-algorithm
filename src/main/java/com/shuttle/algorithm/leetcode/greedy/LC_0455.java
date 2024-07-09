package com.shuttle.algorithm.leetcode.greedy;

import java.util.Arrays;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/assign-cookies/description">分发饼干</a>
 */
public class LC_0455 {

    /**
     * 思路：贪心算法
     * 时间复杂度：O(n * log n)，n 是数组 g、s 的长度
     * 空间复杂度：O(1)
     *
     * @param g 所有孩子的胃口值组成的数组
     * @param s 所有饼干的尺寸组成的数组
     * @return 可以满足最多的孩子数量，
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        // 双指针，代表当前孩子和当前饼干
        int curChild = 0;
        int curCookie = 0;
        int gLen = g.length;
        int sLen = s.length;
        int count = 0;

        while (curChild < gLen && curCookie < sLen) {
            // 如果当前饼干不能满足当前孩子，就往后找，这样的合理性来源于已经从小到大排序了
            while (curCookie < sLen && g[curChild] > s[curCookie]) {
                curCookie++;
            }
            // 如果存在饼干就可以进行统计
            if (curCookie < sLen) {
                count++;
                curChild++;
                curCookie++;
            }
        }

        return count;
    }

}
