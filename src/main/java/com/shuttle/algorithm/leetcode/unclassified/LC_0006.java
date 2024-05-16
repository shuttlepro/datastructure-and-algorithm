package com.shuttle.algorithm.leetcode.unclassified;

/**
 * @author: Shuttle
 * @description: 将一个给定字符串 s 根据给定的行数 numRows，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 */
public class LC_0006 {

    /**
     * 思路：利用一个 numRows 大小的数组和一个代表转向的临时变量
     * 时间复杂度：O(n)，n 是字符串 s 的长度
     * 空间复杂度：O(n)，convertStrs 占用的空间
     *
     * @param s       字符串
     * @param numRows 给定需要转换的行数
     * @return 字符串 s 进行 Z 字形排列的结果
     */
    public String convert(String s, int numRows) {
        if (s == null || s.isEmpty() || numRows <= 1) {
            return s;
        }
        StringBuilder[] convertStrs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            convertStrs[i] = new StringBuilder();
        }
        // 代表往上还是往下【 1：往下，-1：往上 】
        int upOrDown = 1;
        // 代表当前字符需要存入的数组索引位置
        int curIndex = 0;
        int sLen = s.length();

        for (int i = 0; i < sLen; i++) {
            char ch = s.charAt(i);
            convertStrs[curIndex].append(ch);
            curIndex += upOrDown;
            // 临界值需要变更方向
            if ((curIndex + 1) % numRows == 0 || curIndex == 0) {
                upOrDown = -upOrDown;
            }
        }

        StringBuilder convertResult = new StringBuilder();
        for (StringBuilder convertStr : convertStrs) {
            convertResult.append(convertStr);
        }

        return convertResult.toString();
    }

}
