package com.shuttle.algorithm.leetcode.unclassified;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Shuttle
 * @description: 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出和为目标值 target 的那两个整数，并返回它们的数组下标。
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 */
public class LC_0001 {

    /**
     * 解法一：遍历
     * 思路：对 nums 数组进行内外两次嵌套遍历，寻找外层和里层 数值和 == 目标值 的下标对返回
     * 时间复杂度：O(n²) n 是 nums 数组中元素数量
     * 空间复杂度：O(1) 没有额外创建数据结构
     *
     * @param nums   整数数组
     * @param target 目标值
     * @return 和为目标值的那两个整数在数组中的下标 [index1, index2]
     */
    public int[] twoSumSolution1(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[0];
        }

        int numsLen = nums.length;

        for (int i = 0; i < numsLen; i++) {
            for (int j = i + 1; j < numsLen; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[0];
    }

    /**
     * 解法二：HashMap
     * 思路：对 nums 数组进行两次遍历，寻找外层和里层 数值和 == 目标值 的下标对返回
     * 时间复杂度：O(n) 仅遍历一次 nums 数组
     * 空间复杂度：O(n) 额外创建了一个 HashMap 来存储 num 和 index 的映射关系
     *
     * @param nums   整数数组
     * @param target 目标值
     * @return 和为目标值的那两个整数在数组中的下标 [index1, index2]
     */
    public int[] twoSumSolution2(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[0];
        }
        // <num, index>
        Map<Integer, Integer> numToIndexMap = new HashMap<>();
        int numsLen = nums.length;

        for (int i = 0; i < numsLen; i++) {
            int curNum = nums[i];
            int diffNum = target - curNum;
            if (numToIndexMap.containsKey(diffNum)) {
                return new int[]{numToIndexMap.get(diffNum), i};
            }
            numToIndexMap.put(curNum, i);
        }

        return new int[0];
    }

}
