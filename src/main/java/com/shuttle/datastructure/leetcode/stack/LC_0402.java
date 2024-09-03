package com.shuttle.datastructure.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/remove-k-digits/description">移掉 K 位数字</a>
 */
public class LC_0402 {

    /**
     * 思路：使用单调栈来维护一个数字单调递增的栈，栈顶元素始终为当前最小值
     * 时间复杂度：O(n)，n 为字符串长度
     * 空间复杂度：O(n)
     *
     * @param num 以字符串表示的非负整数
     * @param k   要移除的数字个数
     * @return 移除 k 个数字后最小的数字
     */
    public String removeKdigits(String num, int k) {
        if (num == null || num.length() <= k) {
            return "0";
        }

        // 维护单调栈
        Deque<Character> stack = new ArrayDeque<>();
        char[] numCharArray = num.toCharArray();

        for (char numChar : numCharArray) {
            // 遍历 num 如果发现单调栈的顶部元素大于当前字符就移除
            while (!stack.isEmpty() && k > 0 && stack.peekLast() > numChar) {
                stack.removeLast();
                k--;
            }
            stack.addLast(numChar);
        }

        // 此时 k 如果还大于 0 就移除尾部元素
        for (int i = 0; i < k; i++) {
            stack.removeLast();
        }

        // 是否还包含前导零
        boolean isContainsPreZero = true;
        StringBuilder sBuilder = new StringBuilder();

        while (!stack.isEmpty()) {
            Character numChar = stack.pollFirst();
            if (isContainsPreZero && numChar == '0') {
                continue;
            }
            isContainsPreZero = false;
            sBuilder.append(numChar);
        }

        return sBuilder.isEmpty() ? "0" : sBuilder.toString();
    }

}
