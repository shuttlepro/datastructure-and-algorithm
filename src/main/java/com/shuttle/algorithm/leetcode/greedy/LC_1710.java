package com.shuttle.algorithm.leetcode.greedy;

import java.util.Arrays;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/maximum-units-on-a-truck/description">卡车上的最大单元数</a>
 */
public class LC_1710 {

    /**
     * 思路：贪心
     *
     * @param boxTypes  二维数组，boxTypes[i][0] 表示 i 类型箱子的数量，boxTypes[i][1] 表示 i 类型箱子的容量
     * @param truckSize 卡车可以装载箱子的最大总数
     * @return 卡车可以装载单元的最大总数
     */
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // 按容量从大到小排序
        Arrays.sort(boxTypes, (o1, o2) -> o2[1] - o1[1]);
        int maxCapacity = 0;

        for (int[] box : boxTypes) {
            int boxOfNum = box[0];
            int boxOfCapacity = box[1];
            if (boxOfNum < truckSize) {
                // 当前容量的箱子数量没超过可以放的 size
                maxCapacity += boxOfNum * boxOfCapacity;
                truckSize -= boxOfNum;
            } else {
                // 超过了就用剩余 size 即可
                maxCapacity += truckSize * boxOfCapacity;
                break;
            }
        }

        return maxCapacity;
    }

}
