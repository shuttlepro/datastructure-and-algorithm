package com.shuttle.algorithm.leetcode.doublepointer;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/sort-colors/description">颜色分类</a>
 */
public class LC_0075 {

    /**
     * 思路：双指针，一个指向 0，一个指向 2
     *
     * @param nums 待排序的数组
     */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int numsLen = nums.length;
        // 双指针
        int zeroIndex = 0;
        int twoIndex = numsLen - 1;

        for (int i = 0; i <= twoIndex; i++) {
            // 先将所有的 2 放到后面
            while (i <= twoIndex && nums[i] == 2) {
                swapTwoNum(nums, twoIndex, i);
                twoIndex--;
            }
            // 再放 0
            if (nums[i] == 0) {
                swapTwoNum(nums, zeroIndex, i);
                zeroIndex++;
            }
        }
    }

    private void swapTwoNum(int[] nums, int src, int dest) {
        int temp = nums[src];
        nums[src] = nums[dest];
        nums[dest] = temp;
    }

}
