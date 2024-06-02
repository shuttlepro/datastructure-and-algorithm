package com.shuttle.algorithm.leetcode.unclassified;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/decode-string/description">字符串解码</a>
 */
public class LC_0394 {

    /**
     * 思路：遍历时合理利用栈数据结构
     * 时间复杂度：O(n)，n 是字符串 s 的长度
     * 空间复杂度：O(n)，countStack、strStack
     *
     * @param s 字符串
     * @return 解码后的字符串
     */
    public String decodeString(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        StringBuilder decodeString = new StringBuilder();
        int count = 0;
        Deque<Integer> countStack = new ArrayDeque<>();
        Deque<String> strStack = new ArrayDeque<>();
        char[] charArray = s.toCharArray();

        for (char ch : charArray) {
            if (ch == '[') {
                countStack.push(count);
                // push [] 外的str
                strStack.push(decodeString.toString());
                count = 0;
                decodeString = new StringBuilder();
            } else if (ch == ']') {
                StringBuilder sBuilder = new StringBuilder();
                int curCount = countStack.pop();
                for (int i = 0; i < curCount; i++) {
                    sBuilder.append(decodeString);
                }
                // 本次结果等于 [] 左边的字符加上 [] 里面的字符 * count
                decodeString = new StringBuilder(strStack.pop() + sBuilder);
            } else if (ch >= '0' && ch <= '9') {
                // 统计当前 [] 里需要出现的次数
                count = count * 10 + Integer.parseInt("" + ch);
            } else {
                // 记录 [] 里和外的字符
                decodeString.append(ch);
            }
        }

        return decodeString.toString();
    }

}
