package com.shuttle.algorithm.sort.helper;

import java.util.Random;

/**
 * @author: Shuttle
 * @description: 数据处理辅助类
 */
public class DataHelper {

    /**
     * 生成固定大小、固定范围的随机整数数组
     *
     * @param generateCount 需要生成的数量
     * @return 随机整数数组
     */
    public static int[] generateRandomNumsByCount(int generateCount) {
        int[] randomNums = new int[generateCount];
        Random random = new Random();

        for (int i = 0; i < generateCount; i++) {
            // [0, generateCount]
            randomNums[i] = random.nextInt(generateCount + 1);
        }

        return randomNums;
    }

    /**
     * 交换数组中的两个索引位置的元素
     *
     * @param arr  数组
     * @param src  来源位置
     * @param dest 目的位置
     */
    public static void swapTwoElementInArray(int[] arr, int src, int dest) {
        int temp = arr[src];
        arr[src] = arr[dest];
        arr[dest] = temp;
    }

}
