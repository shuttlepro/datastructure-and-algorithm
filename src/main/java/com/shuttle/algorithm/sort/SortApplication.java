package com.shuttle.algorithm.sort;

import com.shuttle.algorithm.sort.executor.SortExecutor;
import com.shuttle.algorithm.sort.executor.SortExecutorManager;
import com.shuttle.algorithm.sort.helper.DataHelper;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import static com.shuttle.algorithm.sort.constant.NumberConstants.*;

/**
 * @author: Shuttle
 * @description: 排序测试类
 */
public class SortApplication {
    public static void main(String[] args) {
        Map<String, SortExecutor> sortExecutorManager = SortExecutorManager.getSortExecutorManager();
        int[] randomNums = DataHelper.generateRandomNumsByCount(NUMBER_100_000);
        Set<String> allSortExecutorNames = sortExecutorManager.keySet();

        for (String executorName : allSortExecutorNames) {
            long startTimestamp = System.currentTimeMillis();
            int[] copyRandomNums = Arrays.copyOf(randomNums, randomNums.length);
            sortExecutorManager.get(executorName).sort(copyRandomNums);
//            System.out.println(Arrays.toString(copyRandomNums));
            long endTimestamp = System.currentTimeMillis();
            computeAndPrintDuration(executorName, startTimestamp, endTimestamp);
        }
        /**
         * Bubble Sort ==> 11923 ms
         * Select Sort ==> 2193 ms
         * Insert Sort ==> 1489 ms
         * Shell Sort ==> 11 ms
         * Quick Sort ==> 22 ms
         * Merge Sort ==> 19 ms
         * Heap Sort ==> 9 ms
         * Counting Sort ==> 6 ms
         * Bucket Sort ==> 80 ms
         * Radix Sort ==> 35 ms
         * JDK Sort ==> 10 ms
         */
    }

    private static void computeAndPrintDuration(String executorName, long startTimestamp, long endTimestamp) {
        System.out.println(executorName + " ==> " + (endTimestamp - startTimestamp) + " ms");
    }

}
