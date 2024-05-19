package com.shuttle.algorithm.sort.executor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Shuttle
 * @description: 基数排序
 */
public class RadixSortExecutor implements SortExecutor {

    /**
     * 思路：按照低位先排序，然后收集；再按照高位排序，然后再收集；依次类推，直到最高位。
     * 时间复杂度：O(n x k)，n 是数组的长度，k 是数组中元素的最大位数
     * 空间复杂度：O(n + k)
     *
     * @param nums 待排序的数组
     */
    @Override
    public void sort(int[] nums) {
        if (requiresNoSorting(nums)) {
            return;
        }
        // 记录最大位数和最大值
        int maxDigit = 1;
        int maxVal = Arrays.stream(nums).max().orElse(0);

        while (maxVal / 10 != 0) {
            maxVal = maxVal / 10;
            maxDigit += 1;
        }

        for (int i = 0; i < maxDigit; i++) {
            // 进行计数排序
            List<List<Integer>> radixSortList = new ArrayList<>();
            for (int k = 0; k < 10; k++) {
                radixSortList.add(new ArrayList<>());
            }
            for (int num : nums) {
                int index = (num / (int) Math.pow(10, i)) % 10;
                radixSortList.get(index).add(num);
            }
            int index = 0;
            // 将 radixSortList 依次赋值给原数组
            for (List<Integer> itemList : radixSortList) {
                for (int item : itemList) {
                    nums[index++] = item;
                }
            }
        }
    }

}
