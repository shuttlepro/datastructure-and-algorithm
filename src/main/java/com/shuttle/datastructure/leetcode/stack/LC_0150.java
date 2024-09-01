package com.shuttle.datastructure.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/evaluate-reverse-polish-notation/description">逆波兰表达式求值</a>
 */
public class LC_0150 {

    /**
     * 思路：如果遇到操作数，则将操作数入栈；
     * 如果遇到运算符，则将两个操作数出栈，其中先出栈的是右操作数，后出栈的是左操作数，
     * 使用运算符对两个操作数进行运算，将运算得到的新操作数入栈。
     * 时间复杂度：O(n)，n 是字符串数组长度
     * 空间复杂度：O(n)
     *
     * @param tokens 字符串数组
     * @return 逆波兰表达式表示的算术表达式的值
     */
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }

        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            if (!isOperator(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                Integer num1 = stack.pop();
                Integer num2 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(num2 + num1);
                        break;
                    case "-":
                        stack.push(num2 - num1);
                        break;
                    case "*":
                        stack.push(num2 * num1);
                        break;
                    case "/":
                        stack.push(num2 / num1);
                        break;
                    default:
                        break;
                }
            }
        }

        return stack.pop();
    }

    private boolean isOperator(String token) {
        return "+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token);
    }

}
