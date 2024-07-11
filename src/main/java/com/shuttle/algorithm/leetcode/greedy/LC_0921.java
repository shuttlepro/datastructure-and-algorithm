package com.shuttle.algorithm.leetcode.greedy;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/minimum-add-to-make-parentheses-valid/description">使括号有效的最少添加</a>
 */
public class LC_0921 {

    /**
     * 思路：贪心算法
     * 时间复杂度：O(n)，n 是字符串长度
     * 空间复杂度：O(1)
     *
     * @param s 待添加括号的字符串
     * @return 添加括号的最少次数
     */
    public int minAddToMakeValid(String s) {
        int res = 0;
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int leftBracket = 0;
        char[] sChars = s.toCharArray();

        for (char ch : sChars) {
            if (ch == '(') {
                leftBracket++;
            } else {
                // 碰到右括号可以消除一个左括号
                if (leftBracket > 0) {
                    leftBracket--;
                } else {
                    // 当前没有左括号就补一个
                    res++;
                }
            }
        }
        // 补上剩余右括号
        res += leftBracket;

        return res;
    }

}
