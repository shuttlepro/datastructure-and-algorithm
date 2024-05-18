package com.shuttle.algorithm.leetcode.unclassified;

/**
 * @author: Shuttle
 * @description: 给你一个整数数组 nums，找出 nums 的下一个排列。
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。
 * 更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，
 * 那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。
 * 如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3]，因为 [3,2,1] 不存在一个字典序更大的排列。
 */
public class LC_0031 {

    /**
     * 思路：逆序找降序数对
     * 时间复杂度：O(N) N 为 nums 数组的长度，最多只需要循环两次
     * 空间复杂度：O(1) 没有额外创建数据结构
     *
     * @param nums 整数数组
     */
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        // 从后往前找第一个降序数对，descIndex 为降序数对的前一个元素索引值。如 [1, 2, 3] descIndex = 1
        int descIndex = nums.length - 2;
        while (descIndex >= 0 && nums[descIndex] >= nums[descIndex + 1]) {
            descIndex--;
        }
        // 再从后往前找，需要找一个比 nums[descIndex] 大的数进行交换
        if (descIndex >= 0) {
            int ascIndex = nums.length - 1;
            while (ascIndex >= 0 && nums[ascIndex] <= nums[descIndex]) {
                ascIndex--;
            }
            swapTwoNum(nums, ascIndex, descIndex);
        }
        // 最后将 descIndex + 1 到结尾段进行反转
        int endIndex = nums.length - 1;
        descIndex++;

        while (descIndex < endIndex) {
            swapTwoNum(nums, endIndex, descIndex);
            endIndex--;
            descIndex++;
        }
    }

    private void swapTwoNum(int[] nums, int src, int dest) {
        int temp = nums[src];
        nums[src] = nums[dest];
        nums[dest] = temp;
    }

}
