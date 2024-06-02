package com.shuttle.algorithm.leetcode.unclassified;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array/description">找到所有数组中消失的数字</a>
 */
public class LC_0448 {

    /**
     * 思路：第一次遍历将对应索引位置的元素加上数组长度，第二次遍历过滤出所有位置上值小于等于数组长度则为消失数的集合
     * 时间复杂度：O(n)，n 为 nums 数组的长度
     * 空间复杂度：O(1)
     *
     * @param nums 整数数组
     * @return 整数数组中消失的数
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> disappearedNumbers = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return disappearedNumbers;
        }
        int numsLen = nums.length;

        for (int num : nums) {
            int index = (num - 1) % numsLen;
            nums[index] += numsLen;
        }
        for (int i = 0; i < numsLen; i++) {
            if (nums[i] <= numsLen) {
                disappearedNumbers.add(i + 1);
            }
        }

        return disappearedNumbers;
    }

}
