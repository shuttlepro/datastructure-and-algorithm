package com.shuttle.algorithm.leetcode.unclassified;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/monotone-increasing-digits/description">单调递增的数字</a>
 */
public class LC_0738 {

    /**
     * 思路：将 n 转为字符数组，遍历的过程中找到下降特征的二元组进行处理
     * 时间复杂度：O(log n)，n 是输入数字
     * 空间复杂度：O(log n)
     *
     * @param n 整数
     * @return 小于或等于 n 的最大单调递增数字
     */
    public int monotoneIncreasingDigits(int n) {
        if (n < 10) {
            return n;
        }
        char[] nChars = String.valueOf(n).toCharArray();
        int curDescIndex = 0;
        int cLen = nChars.length;
        // 找到当前下降二元组的首位元素
        while (curDescIndex + 1 < cLen && nChars[curDescIndex] <= nChars[curDescIndex + 1]) {
            curDescIndex++;
        }
        if (curDescIndex == cLen - 1) {
            return n;
        }
        // 再往前看，检查是否有等于 nChars[i] 的元素，将其减 1，然后把后面的元素全部变为 9
        while (curDescIndex - 1 >= 0 && nChars[curDescIndex - 1] == nChars[curDescIndex]) {
            curDescIndex--;
        }
        nChars[curDescIndex] = (char) (nChars[curDescIndex] - 1);
        curDescIndex++;
        while (curDescIndex < cLen) {
            nChars[curDescIndex] = '9';
            curDescIndex++;
        }

        return Integer.parseInt(new String(nChars));
    }

}
