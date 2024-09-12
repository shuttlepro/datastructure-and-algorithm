package com.shuttle.datastructure.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/largest-rectangle-in-histogram/description">柱状图中最大的矩形</a>
 */
public class LC_0084 {

    /**
     * 思路：单调栈
     * 时间复杂度：O(n)，n 是 heights 数组的长度
     * 空间复杂度：O(n)
     *
     * @param heights 各个柱子高度组成的数组
     * @return 柱状图中能够勾勒出的最大矩形的面积
     */
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        int hLen = heights.length;
        int newLen = hLen + 2;
        int[] temp = new int[newLen];
        // 将原数组复制到新数组中间，首位元素为 0
        System.arraycopy(heights, 0, temp, 1, hLen);

        Deque<Integer> stack = new ArrayDeque<>();
        int area = 0;

        for (int i = 0; i < newLen; i++) {
            // 对栈中柱体来说，栈中的下一个柱体就是其 左边第一个小于自身的柱体
            // 若当前柱体 i 的高度小于栈顶柱体的高度，说明 i 是栈顶柱体的 右边第一个小于栈顶柱体的柱体
            while (!stack.isEmpty() && temp[i] < temp[stack.peek()]) {
                int height = temp[stack.pop()];
                int width = i - stack.peek() - 1;
                area = Math.max(area, width * height);
            }

            stack.push(i);
        }

        return area;
    }
}
