package com.shuttle.datastructure.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/longest-valid-parentheses/description">最长有效括号</a>
 */
public class LC_0032 {

    /**
     * 思路：用 ArrayDeque 作为栈，遍历字符串，根据字符内容进行出入栈操作
     * 时间复杂度：O(n)，n 是字符串 s 的长度
     * 空间复杂度：O(n)
     *
     * @param s 字符串
     * @return 最长有效括号长度
     */
    public int longestValidParentheses(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int longestValidParentheses = 0;
        char[] sCharArray = s.toCharArray();
        int sLen = sCharArray.length;
        Deque<Integer> stack = new ArrayDeque<>();
        // 防止第一个字符是 ')'
        stack.push(-1);

        for (int i = 0; i < sLen; i++) {
            if (sCharArray[i] == '(') {
                // 左括号直接入栈
                stack.push(i);
            } else {
                // 遇到右括号直接弹出栈顶，然后判断栈是否空
                stack.pop();
                if (stack.isEmpty()) {
                    // 维护最后一个未匹配的右括号下标
                    stack.push(i);
                } else {
                    longestValidParentheses = Math.max(longestValidParentheses, i - stack.peek());
                }
            }
        }

        return longestValidParentheses;
    }

}
