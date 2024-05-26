package com.shuttle.algorithm.leetcode.doublepointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/4sum">四数之和</a>
 */
public class LC_0018 {

    /**
     * 思路：双指针，LC_0015 的进阶
     * 时间复杂度：O(n³)，n 是 nums 数组的长度
     * 空间复杂度：O(n)
     *
     * @param nums 整数数组
     * @param target 四元组组成的目标值
     * @return 整数数组中能组成目标值的不重复四元组集合
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> fourSumResult = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return fourSumResult;
        }
        Arrays.sort(nums);
        int numsLen = nums.length;
        
        for (int i = 0; i < numsLen - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 转成 long 防止溢出，后续元素已经不具备组成目标值的条件
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            // nums[i] 太小，不符合
            if ((long) nums[i] + nums[numsLen - 3] + nums[numsLen - 2] + nums[numsLen - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < numsLen - 2; j++) {
                // 重复元素跳过
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                // 后续元素已经不具备组成目标值的条件
                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                // nums[i] 太小，不符合
                if ((long) nums[i] + nums[j] + nums[numsLen - 2] + nums[numsLen - 1] < target) {
                    continue;
                }
                // 左右指针，尝试查找合适的四元组
                int leftIndex = j + 1;
                int rightIndex = numsLen - 1;

                while (leftIndex < rightIndex) {
                    long fourSum = (long) nums[i] + nums[j] + nums[leftIndex] + nums[rightIndex];
                    if (fourSum == target) {
                        fourSumResult.add(Arrays.asList(nums[i], nums[j], nums[leftIndex], nums[rightIndex]));
                        // 跳过重复元素
                        while (leftIndex < rightIndex && nums[leftIndex] == nums[leftIndex + 1]) {
                            leftIndex++;
                        }
                        while (leftIndex < rightIndex && nums[rightIndex] == nums[rightIndex - 1]) {
                            rightIndex--;
                        }
                        leftIndex++;
                        rightIndex--;
                    } else if (fourSum > target) {
                        rightIndex--;
                    } else {
                        leftIndex++;
                    }
                }
            }
        }

        return fourSumResult;
    }

}
