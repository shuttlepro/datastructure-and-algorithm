package com.shuttle.algorithm.sort.executor;

/**
 * @author: Shuttle
 * @description: 排序执行器枚举类
 */
public enum SortExecutorEnum {

    BUBBLE_SORT("Bubble Sort", new BubbleSortExecutor()),
    SELECT_SORT("Select Sort", new SelectSortExecutor()),
    INSERT_SORT("Insert Sort", new InsertSortExecutor()),
    SHELL_SORT("Shell Sort", new ShellSortExecutor()),
    QUICK_SORT("Quick Sort", new QuickSortExecutor()),
    MERGE_SORT("Merge Sort", new MergeSortExecutor()),
    HEAP_SORT("Heap Sort", new HeapSortExecutor()),
    COUNTING_SORT("Counting Sort", new CountingSortExecutor()),
    BUCKET_SORT("Bucket Sort", new BucketSortExecutor()),
    RADIX_SORT("Radix Sort", new RadixSortExecutor()),
    JDK_SORT("JDK Sort", new JDKSortExecutor());

    private final String executorName;

    private final SortExecutor executor;

    SortExecutorEnum(String executorName, SortExecutor executor) {
        this.executorName = executorName;
        this.executor = executor;
    }

    public String getExecutorName() {
        return this.executorName;
    }

    public SortExecutor getExecutor() {
        return this.executor;
    }

}
