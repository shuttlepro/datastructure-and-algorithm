package com.shuttle.datastructure.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/valid-parentheses/description">有效的括号</a>
 */
public class LC_0020 {

    /**
     * 解法一：ArrayDeque 充当栈，HashMap 维护括号映射关系
     * 时间复杂度：O(n)，n 是字符串 s 的长度
     * 空间复杂度：O(n)
     *
     * @param s 提供的字符串
     * @return 是否有效字符串
     */
    public boolean isValidSolution1(String s) {
        if (s == null || s.isEmpty() || s.length() % 2 != 0) {
            return false;
        }

        // 括号反向映射表
        Map<Character, Character> bracketMap = new HashMap<>();
        bracketMap.put(')', '(');
        bracketMap.put(']', '[');
        bracketMap.put('}', '{');
        Deque<Character> stack = new ArrayDeque<>();
        char[] sCharArray = s.toCharArray();

        for (char ch : sCharArray) {
            if (bracketMap.containsKey(ch)) {
                // 如果当前栈为空或者不为对应的括号则返回 false
                if (stack.isEmpty() || !stack.peek().equals(bracketMap.get(ch))) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }

    /**
     * 解法二：字符数组充当栈
     * 时间复杂度：O(n)，n 是字符串 s 的长度
     * 空间复杂度：O(n)
     *
     * @param s 提供的字符串
     * @return 是否有效字符串
     */
    public boolean isValidSolution2(String s) {
        if (s == null || s.isEmpty() || s.length() % 2 != 0) {
            return false;
        }

        char[] sCharArray = s.toCharArray();
        char[] stack = new char[sCharArray.length];
        int curidx = -1;

        for (char ch : sCharArray) {
            if (curidx == -1 || ch == '(' || ch == '[' || ch == '{') {
                stack[++curidx] = ch;
            } else if (ch == ')' && stack[curidx--] != '('
                    || ch == ']' && stack[curidx--] != '['
                    || ch == '}' && stack[curidx--] != '{') {
                return false;
            }
        }

        return curidx < 0;
    }

}
