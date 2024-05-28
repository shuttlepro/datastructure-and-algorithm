package com.shuttle.algorithm.leetcode.binarysearch;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/find-the-duplicate-number/description">寻找重复数</a>
 */
public class LC_0287 {

    /**
     * 解法一：二分查找，记录小于等于 midIndex 的元素的个数
     * 时间复杂度：O(n * log n)
     * 空间复杂度：O(1)
     *
     * @param nums 整数数组
     * @return 整数数组中存在的重复数
     */
    public int findDuplicateSolution1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int numsLen = nums.length;
        int leftIndex = 1;
        int rightIndex = numsLen - 1;

        while (leftIndex < rightIndex) {
            int midIndex = leftIndex + (rightIndex - leftIndex) / 2;
            /**
             * 例如 [2, 5, 4, 3, 1, 3] 对应的 count [2, 6, 5, 4, 1, 4]
             * 如果遍历数组，统计小于等于 4 的元素的个数，如果小于等于 4 的元素的个数大于 4
             * 说明重复的元素一定出现在整数区间 [1, 4]
             */
            // 记录 nums 中小于等于 midIndex 的元素的个数
            int count = 0;
            for (int i = 0; i < numsLen; ++i) {
                if (nums[i] <= midIndex) {
                    count++;
                }
            }
            if (count > midIndex) {
                // [leftIndex, midIndex]
                rightIndex = midIndex;
            } else {
                // [midIndex + 1, rightIndex]
                leftIndex = midIndex + 1;
            }
        }

        return leftIndex;
    }

    /**
     * 解法二：快慢指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param nums 整数数组
     * @return 整数数组中存在的重复数
     */
    public int findDuplicateSolution2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        /**
         * 在快慢指针的过程中，慢指针每次移动一步，快指针每次移动两步，因此快指针会追赶上慢指针。
         * 当快指针追赶上慢指针时，意味着存在循环。设慢指针移动了 k 步，则快指针移动了 2k 步。
         * 因此，两指针相遇时，快指针比慢指针多走了一个循环的长度。
         */
        int slow = 0;
        int fast = 0;

        while (slow == 0 || slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int res = 0;

        while (res != slow) {
            res = nums[res];
            slow = nums[slow];
        }

        return res;
    }

}
