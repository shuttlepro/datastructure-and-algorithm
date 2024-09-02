package com.shuttle.datastructure.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/remove-duplicate-letters/description">去除重复字母</a>
 */
public class LC_0316 {

    /**
     * 思路：使用单调栈（Monotonic Stack）来去除字符串中的重复字符，并保证结果字符串的字典序最小。
     *
     * @param s 字符串
     * @return 去除重复字符后的字符串，使得每个字母只出现一次且字典序最小
     */
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        int sLen = s.length();
        char[] sCharArray = s.toCharArray();

        // 用于记录每个字符最后出现的位置
        int[] lastIndex = new int[26];
        for (int i = 0; i < sLen; i++) {
            lastIndex[sCharArray[i] - 'a'] = i;
        }

        // 单调栈
        Deque<Character> stack = new ArrayDeque<>();
        // 用于记录当前栈中的某个字符是否已出现
        boolean[] isVisited = new boolean[26];

        for (int i = 0; i < sLen; i++) {
            char ch = sCharArray[i];
            // 如果在栈中已经出现了直接跳过
            if (isVisited[ch - 'a']) {
                continue;
            }
            // 当前栈不为空 && 栈底元素大于当前元素【维护字典序】 && 栈底元素后面还会出现
            while (!stack.isEmpty() && ch < stack.peekLast() && lastIndex[stack.peekLast() - 'a'] > i) {
                // 弹出栈底元素，将它置为 false
                Character topChar = stack.removeLast();
                isVisited[topChar - 'a'] = false;
            }
            // 添加当前元素
            stack.addLast(ch);
            isVisited[ch - 'a'] = true;
        }

        StringBuilder sBuilder = new StringBuilder();
        for (Character ch : stack) {
            sBuilder.append(ch);
        }

        return sBuilder.toString();
    }

}
