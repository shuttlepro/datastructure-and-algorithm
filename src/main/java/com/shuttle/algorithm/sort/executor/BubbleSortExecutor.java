package com.shuttle.algorithm.sort.executor;

import com.shuttle.algorithm.sort.helper.DataHelper;

/**
 * @author: Shuttle
 * @description: 冒泡排序
 */
public class BubbleSortExecutor implements SortExecutor {

    /**
     * 思路：将数组中相邻元素从前往后依次进行比较，如果前一个元素比后一个元素大则交换，每一轮循环最大元素就在数组末尾。
     * 时间复杂度：最差为O(n²)，取决于随机数组的数据分布特点。
     * 空间复杂度：O(1)
     *
     * @param nums 待排序的数组
     */
    @Override
    public void sort(int[] nums) {
        if (requiresNoSorting(nums)) {
            return;
        }
        int numsLen = nums.length;

        for (int i = 0; i < numsLen - 1; i++) {
            boolean isExistSwap = false;
            // 减去 i 是因为之前的循环已经排过序了
            for (int j = 0; j < numsLen - 1 - i; j++) {
                if (nums[j + 1] >= nums[j]) {
                    continue;
                }
                // 优化点：添加一个标识用来确定内层排序是否存在交换元素的动作，没有则说明数组已经有序。
                isExistSwap = true;
                DataHelper.swapTwoElementInArray(nums, j, j + 1);
            }
            if (!isExistSwap) {
                return;
            }
        }
    }

}
