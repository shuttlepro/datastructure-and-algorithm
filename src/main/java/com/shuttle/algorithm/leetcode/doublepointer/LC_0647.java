package com.shuttle.algorithm.leetcode.doublepointer;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/palindromic-substrings/description">回文子串</a>
 */
public class LC_0647 {

    /**
     * 思路：双指针，以 sChars[i] 为中心向两边扩散，需要考虑单字符和双字符
     * 时间复杂度：O(n²)，n 是字符串 s 的长度
     * 空间复杂度：O(1)
     *
     * @param s 字符串
     * @return 字符串中回文子串的数量
     */
    public int countSubstrings(String s) {
        int palindromeSubStringCount = 0;
        if (s == null || s.isEmpty()) {
            return palindromeSubStringCount;
        }
        int sLen = s.length();
        char[] sChars = s.toCharArray();
        // 每个字符都是一个回文串
        palindromeSubStringCount = sLen;

        for (int i = 0; i < sLen; i++) {
            // 单字符扩，以 sChars[i] 为中心向两边扩散
            int leftIndex = i - 1;
            int rightIndex = i + 1;

            while (leftIndex >= 0 && rightIndex < sLen && sChars[leftIndex] == sChars[rightIndex]) {
                leftIndex--;
                rightIndex++;
                palindromeSubStringCount++;
            }
            // 双字符扩，sChars[i] 和 sChars[i + 1] 为中心进行扩展
            leftIndex = i;
            rightIndex = i + 1;

            while (leftIndex >= 0 && rightIndex < sLen && sChars[leftIndex] == sChars[rightIndex]) {
                leftIndex--;
                rightIndex++;
                palindromeSubStringCount++;
            }
        }

        return palindromeSubStringCount;
    }

}
