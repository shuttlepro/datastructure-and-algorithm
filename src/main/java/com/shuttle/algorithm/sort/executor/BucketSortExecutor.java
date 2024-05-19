package com.shuttle.algorithm.sort.executor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: Shuttle
 * @description: 桶排序
 */
public class BucketSortExecutor implements SortExecutor {

    /**
     * 思路：假设输入数据服从均匀分布，将数据分到有限数量的桶里，每个桶再分别以递归方式继续使用桶排序进行排序。
     * 时间复杂度：O(n + k)，n 是数组的长度，k 是每个桶的平均元素数
     * 空间复杂度：O(n + k)
     *
     * @param nums 待排序的数组
     */
    @Override
    public void sort(int[] nums) {
        if (requiresNoSorting(nums)) {
            return;
        }
        List<Integer> bucketSortResult = bucketSort(
                Arrays.stream(nums).boxed().collect(Collectors.toList()), (int) Math.sqrt(nums.length));

        for (int i = 0; i < bucketSortResult.size(); i++) {
            nums[i] = bucketSortResult.get(i);
        }
    }

    /**
     * BucketSort
     *
     * @param bucket      待排序的桶
     * @param bucketCount 桶的个数
     * @return 当前桶排序好的结果
     */
    public List<Integer> bucketSort(List<Integer> bucket, int bucketCount) {
        if (bucket.size() < 2 || bucketCount == 0) {
            return bucket;
        }
        int minVal = bucket.stream().mapToInt(Integer::intValue).min().orElse(0);
        int maxVal = bucket.stream().mapToInt(Integer::intValue).max().orElse(0);
        // 计算实际需要的桶数
        int needBucketCount = (maxVal - minVal) / bucketCount + 1;
        List<List<Integer>> buckets = new ArrayList<>(needBucketCount);

        for (int i = 0; i < needBucketCount; i++) {
            buckets.add(new ArrayList<>());
        }
        // 将元素分配到相应的桶中
        for (int num : bucket) {
            int index = (num - minVal) / bucketCount;
            buckets.get(index).add(num);
        }
        // 对每个桶进行递归桶排序，并将结果合并
        for (int i = 0; i < buckets.size(); i++) {
            if (buckets.get(i).size() > 1) {
                buckets.set(i, bucketSort(buckets.get(i), bucketCount / 2));
            }
        }

        List<Integer> sortedList = new ArrayList<>();
        for (List<Integer> itemList : buckets) {
            sortedList.addAll(itemList);
        }

        return sortedList;
    }

}
