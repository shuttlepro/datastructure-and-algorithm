package com.shuttle.algorithm.sort.executor;

import java.util.Arrays;

/**
 * @author: Shuttle
 * @description: 计数排序
 */
public class CountingSortExecutor implements SortExecutor {

    /**
     * 思路：计数排序使用一个额外的数组 T，其中第 i 个元素是待排序数组 N 中值等于 i 的元素的个数。
     * 然后根据 T 来将 N 中的元素排到正确的位置。它只能对整数进行排序。
     * 时间复杂度：O(n + k)，n 是待排序数组的长度，k 是待排序数组的最大值
     * 空间复杂度：O(k)
     *
     * @param nums 待排序的数组
     */
    @Override
    public void sort(int[] nums) {
        if (requiresNoSorting(nums)) {
            return;
        }
        int minVal = Arrays.stream(nums).min().orElse(0);
        int maxVal = Arrays.stream(nums).max().orElse(0);

        int[] countArr = new int[maxVal - minVal + 1];
        int[] result = new int[nums.length];

        // 以 nums[i] - minVal 作为 countArr 数组的索引，
        // 以 nums[i] 在 nums 中元素出现的次数作为 countArr[nums[i] - minVal] 的值
        for (int num : nums) {
            countArr[num - minVal] += 1;
        }
        // 对 countArr 数组变形，新元素的值是该元素与前一个元素值的和
        for (int i = 1; i < countArr.length; i++) {
            countArr[i] += countArr[i - 1];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            int index = countArr[nums[i] - minVal] - 1;
            result[index] = nums[i];
            countArr[nums[i] - minVal] -= 1;
        }
        // result 元素 copy 到原数组
        System.arraycopy(result, 0, nums, 0, nums.length);
    }

}
