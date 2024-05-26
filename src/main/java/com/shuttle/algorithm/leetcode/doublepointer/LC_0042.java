package com.shuttle.algorithm.leetcode.doublepointer;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/trapping-rain-water">接雨水</a>
 */
public class LC_0042 {

    /**
     * 思路：双指针，对于每一个柱子，它能接的水 = min(左右两边最高柱子）- 当前柱子高度
     *
     * @param height 代表高度图的整数数组
     * @return 能接的所有雨水总和
     */
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int waterCapacity = 0;
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        // 维护左右两边最高柱子
        int leftMaxHeight = 0;
        int rightMaxHeight = 0;

        while (leftIndex < rightIndex) {
            leftMaxHeight = Math.max(leftMaxHeight, height[leftIndex]);
            rightMaxHeight = Math.max(rightMaxHeight, height[rightIndex]);
            // 如果当前左边柱子高度 > 当前右边柱子高度，说明右边可以接水
            if (height[leftIndex] > height[rightIndex]) {
                waterCapacity += rightMaxHeight - height[rightIndex];
                rightIndex--;
            } else {
                // 同理
                waterCapacity += leftMaxHeight - height[leftIndex];
                leftIndex++;
            }
        }

        return waterCapacity;
    }

}
