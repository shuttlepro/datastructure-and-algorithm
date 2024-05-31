package com.shuttle.algorithm.leetcode.unclassified;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/longest-consecutive-sequence/description">最长连续序列</a>
 */
public class LC_0128 {

    /**
     * 思路：利用 HashSet，判断每一个 item 的左边一位是否存在于 HashSet 中
     * 时间复杂度：O(n) n 是 nums 的长度
     * 空间复杂度：O(n) unSortNums 所占用的空间
     *
     * @param nums 未排序的整数数组
     * @return nums 中最长连续序列的长度
     */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> unSortNums = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int longestConsecutiveLen = 0;

        for (Integer num : unSortNums) {
            // 如果 num - 1 存在于 unSortNums 中，说明当前数不可能是最长连续序列的左区间
            if (unSortNums.contains(num - 1)) {
                continue;
            }
            int curNum = num;
            int curSequenceLen = 1;
            // 如果 unSortNums 存在 curNum + 1，则继续尝试找右边界
            while (unSortNums.contains(curNum + 1)) {
                curNum++;
                curSequenceLen++;
            }

            longestConsecutiveLen = Math.max(longestConsecutiveLen, curSequenceLen);
        }

        return longestConsecutiveLen;
    }

}
