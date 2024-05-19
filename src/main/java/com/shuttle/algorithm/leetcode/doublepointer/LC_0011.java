package com.shuttle.algorithm.leetcode.doublepointer;

/**
 * @author: Shuttle
 * @description: 给定一个长度为 n 的整数数组 height。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i])。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。返回容器可以储存的最大水量。
 * 示例 1：
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
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
