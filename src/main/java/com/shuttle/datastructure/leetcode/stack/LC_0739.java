package com.shuttle.datastructure.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/daily-temperatures/description">每日温度</a>
 */
public class LC_0739 {

    /**
     * 思路：利用单调栈，栈中保存的是下标，栈顶到栈底递增，
     * 栈顶元素对应的温度要高于栈中元素对应的温度，那么栈顶元素就是栈中元素离下一次温度升高的天数
     * 时间复杂度：O(n)，n 是数组长度
     * 空间复杂度：O(n)
     *
     * @param temperatures 代表每天温度的数组
     * @return 计算给定数组中每一个温度离下一次温度升高的天数数组
     */
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            return new int[]{};
        }

        int length = temperatures.length;
        int[] res = new int[length];
        // 维护一个单调栈，栈顶到栈底递增
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < length; i++) {
            int temperature = temperatures[i];
            // 如果当前温度要高于前几天，就要进行出栈处理
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                Integer preIndex = stack.pop();
                res[preIndex] = i - preIndex;
            }

            // 当前索引入栈
            stack.push(i);
        }

        return res;
    }

}
