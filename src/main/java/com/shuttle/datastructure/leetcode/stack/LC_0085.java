package com.shuttle.datastructure.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/maximal-rectangle/description">最大矩形</a>
 */
public class LC_0085 {

    /**
     * 思路：每一层看成柱状图，套用 {@link LC_0084} 的解法
     * 时间复杂度：O(n * m)，n 是矩阵的行数，m 是矩阵的列数
     * 空间复杂度：O(m)
     *
     * @param matrix 仅包含 0 和 1 的二维二进制矩阵
     * @return 找出只包含 1 的最大矩形面积
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int column = matrix[0].length;
        int[] heights = new int[column];
        int res = 0;

        for (char[] chars : matrix) {
            // 更新高度
            for (int j = 0; j < column; j++) {
                if (chars[j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }

            // 计算当前行的最大矩形面积
            res = Math.max(res, largestRectangleArea(heights));
        }

        return res;
    }

    /**
     * {@link LC_0084}
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
