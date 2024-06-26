package com.shuttle.algorithm.leetcode.doublepointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/3sum">三数之和</a>
 */
public class LC_0015 {

    /**
     * 思路：对数组排序后使用双指针
     * 时间复杂度：O(n²)
     * 空间复杂度：O(n²)
     *
     * @param nums 整数数组
     * @return 整数数组中和为不重复三元组的集合
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> threeSumResult = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return threeSumResult;
        }
        int numsLen = nums.length;
        // 从小到大排序
        Arrays.sort(nums);

        for (int i = 0; i < numsLen; i++) {
            int num = nums[i];
            // nums[i] > 0 说明后面元素都大于0，直接跳出循环
            if (num > 0) {
                break;
            }
            // 除掉重复元素
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            // 当前 i 位置的左右指针
            int leftIndex = i + 1;
            int rightIndex = numsLen - 1;

            while (leftIndex < rightIndex) {
                int sum = num + nums[leftIndex] + nums[rightIndex];
                if (sum == 0) {
                    // 符合条件的元素组
                    threeSumResult.add(Arrays.asList(num, nums[leftIndex], nums[rightIndex]));
                    // 除去重复元素
                    while (leftIndex < rightIndex && nums[leftIndex + 1] == nums[leftIndex]) {
                        leftIndex++;
                    }
                    while (leftIndex < rightIndex && nums[rightIndex - 1] == nums[rightIndex]) {
                        rightIndex--;
                    }
                    // 移动左右指针
                    leftIndex++;
                    rightIndex--;
                } else if (sum > 0) {
                    // 总和偏大，右指针左移
                    rightIndex--;
                } else {
                    // 总和偏小，左指针右移
                    leftIndex++;
                }
            }
        }

        return threeSumResult;
    }

}
