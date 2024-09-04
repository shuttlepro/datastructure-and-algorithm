package com.shuttle.datastructure.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/trapping-rain-water/description">接雨水</a>
 */
public class LC_0042 {

    /**
     * 思路：维护一个单调不增栈，出现入栈元素（右墙）比栈顶大时，
     * 说明在右墙左侧形成了低洼处，低洼处出栈并结算该低洼处能接的雨水
     *
     * @param height 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图
     * @return 下雨之后能接的雨水总量
     */
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        int waterCapacity = 0;
        // 单调栈
        Deque<Integer> stack = new ArrayDeque<>();
        int hLen = height.length;

        for (int i = 0; i < hLen; i++) {
            // 栈不为空，且当前元素【右墙】比栈顶【右墙的左侧，前一个元素】大，形成低洼
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                // 低洼处弹出
                Integer top = stack.pop();
                // 判断左墙是否存在
                if (stack.isEmpty()) {
                    break;
                }
                // 左墙
                int left = stack.peek();
                // 积水槽的宽度
                int curWidth = i - left - 1;
                // 积水槽的高度 = (左墙，右墙) 的 min - 低洼处的高度
                int curHeight = Math.min(height[left], height[i]) - height[top];
                waterCapacity += curWidth * curHeight;
            }

            stack.push(i);
        }

        return waterCapacity;
    }

}
