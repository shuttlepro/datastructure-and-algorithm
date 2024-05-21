package com.shuttle.algorithm.leetcode.doublepointer;

import java.util.Arrays;

/**
 * @author: Shuttle
 * @description: 给你一个长度为 n 的整数数组 nums 和一个目标值 target。
 * 请你从 nums 中选出三个整数，使它们的和与 target 最接近。返回这三个数的和。
 * 示例 1：
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 */
public class LC_0016 {

    /**
     * 思路：双指针，穷举求出各三数之和，找出最接近的值
     * 时间复杂度：O(n²)，n 是 nums 数组的长度
     * 空间复杂度：O(1)
     *
     * @param nums 整数数组
     * @param target 目标值
     * @return nums 数组中最接近 target 的三数之和
     */
    public int threeSumClosest(int[] nums, int target) {
        // 初始化一个最大值，方便作比较
        int threeSumClosest = Integer.MAX_VALUE;
        int numsLen = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < numsLen; i++) {
            int curVal = nums[i];
            int leftIndex = i + 1;
            int rightIndex = numsLen - 1;

            while (leftIndex < rightIndex) {
                int threeSum = nums[leftIndex] + nums[rightIndex] + curVal;
                // 绝对值相差小说明更接近结果
                threeSumClosest = Math.abs(threeSumClosest - target) > Math.abs(threeSum - target) ? threeSum : threeSumClosest;
                if (threeSumClosest == target) {
                    return threeSumClosest;
                } else if (threeSum > target) {
                    rightIndex--;
                } else {
                    leftIndex++;
                }
            }
        }

        return threeSumClosest;
    }

}
