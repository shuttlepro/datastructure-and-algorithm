package com.shuttle.algorithm.leetcode.greedy;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/minimum-swaps-to-make-strings-equal/description">交换字符使得字符串相同</a>
 */
public class LC_1247 {

    /**
     * 思路：贪心算法 + 组合优化
     * 时间复杂度：O(n)，n 是字符串的长度
     * 空间复杂度：O(1)
     *
     * @param s1 字符串 1
     * @param s2 字符串 2
     * @return 使 s1 和 s2 相同的最小交换次数，如果没有方法能够使得这两个字符串相同，则返回 -1
     */
    public int minimumSwap(String s1, String s2) {
        if (s1 == null || s2 == null
                || s1.isEmpty() || s2.isEmpty()
                || s1.length() != s2.length()) {
            return -1;
        }

        int xyCount = 0;
        int yxCount = 0;
        int sLen = s1.length();

        for (int i = 0; i < sLen; i++) {
            char s1Ch = s1.charAt(i);
            char s2Ch = s2.charAt(i);
            // 相等不用换
            if (s1Ch == s2Ch) {
                continue;
            }
            // 统计 xy 对和 yx 对
            if (s1Ch == 'x' && s2Ch == 'y') {
                xyCount++;
            }
            if (s1Ch == 'y' && s2Ch == 'x') {
                yxCount++;
            }
        }

        // 一次交换可减少 2 组 xy 对 或 yx 对，两次交换可减少 1 组 xy 对 和 yx 对
        if ((xyCount + yxCount) % 2 != 0) {
            return -1;
        }

        // 最小交换次数等于 xy 对数加 yx 对数，可能 xyCount 和 yxCount 是奇数
        return (xyCount / 2 + yxCount / 2) + (xyCount % 2 + yxCount % 2);
    }

}
