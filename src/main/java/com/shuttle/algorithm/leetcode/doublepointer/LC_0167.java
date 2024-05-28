package com.shuttle.algorithm.leetcode.doublepointer;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/description">两数之和 II - 输入有序数组</a>
 */
public class LC_0167 {

    /**
     * 思路：双指针，找出左、右指针指向元素值之和等于 target
     * 时间复杂度：O(n)，n 为 nums 数组的长度
     * 空间复杂度：O(1)
     *
     * @param numbers 整数数组
     * @param target  目标值
     * @return 和为目标值的这两个数所在数组中的索引集合
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] twoSumResult = new int[2];
        if (numbers == null || numbers.length < 2) {
            return twoSumResult;
        }
        // numbers = [2, 7, 11, 15], target = 9 result:[1, 2]
        int leftIndex = 0;
        int rightIndex = numbers.length - 1;

        while (leftIndex < rightIndex) {
            int twoSum = numbers[leftIndex] + numbers[rightIndex];
            if (twoSum == target) {
                twoSumResult[0] = leftIndex + 1;
                twoSumResult[1] = rightIndex + 1;
                return twoSumResult;
            } else if (twoSum > target) {
                rightIndex--;
            } else {
                leftIndex++;
            }
        }

        return twoSumResult;
    }

}
