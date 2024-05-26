package com.shuttle.algorithm.leetcode.doublepointer;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/container-with-most-water">盛最多水的容器</a>
 */
public class LC_0011 {

    /**
     * 思路：双指针，不断收缩找到可容纳最多的水的左右边界索引值
     * 时间复杂度：O(n)，n 是整数数组的长度
     * 空间复杂度：O(1)
     *
     * @param height 代表高度的整数数组
     * @return 最大的容量
     */
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        int maxCapacity = Integer.MIN_VALUE;

        while (leftIndex < rightIndex) {
            // 比较面积
            int curArea = (rightIndex - leftIndex) * Math.min(height[leftIndex], height[rightIndex]);
            maxCapacity = Math.max(maxCapacity, curArea);
            if (height[leftIndex] > height[rightIndex]) {
                rightIndex--;
            } else {
                leftIndex++;
            }
        }

        return maxCapacity;
    }

}
