package com.shuttle.algorithm.leetcode.binarysearch;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/find-in-mountain-array/description">山脉数组中查找目标值</a>
 */
public class LC_1095 {

    /**
     * 思路：先找到峰顶元素，然后左右部分分别使用二分查找寻找目标值
     * 时间复杂度：O(log N)
     * 空间复杂度：O(1)
     *
     * @param target 目标值
     * @param mountainArr 山脉数组
     * @return 目标值在山脉数组中的第一个索引位置
     */
    public int findInMountainArray(int target, MountainArray mountainArr) {
        if (mountainArr == null || mountainArr.arr == null || mountainArr.arr.length == 0) {
            return -1;
        }
        int arrLen = mountainArr.length();
        // [1, 2, 3, 4, 5, 3, 1] target = 3
        // 先找到顶峰
        int leftIndex = 0;
        int rightIndex = arrLen - 2;

        while (leftIndex < rightIndex) {
            int midIndex = leftIndex + (rightIndex - leftIndex) / 2;
            if (mountainArr.get(midIndex) < mountainArr.get(midIndex + 1)) {
                // 说明顶峰靠右 [midIndex + 1, rightIndex]
                leftIndex = midIndex + 1;
            } else {
                // 说明顶峰靠左 [leftIndex, midIndex]
                rightIndex = midIndex;
            }
        }
        // 顶峰 leftIndex == 5
        int peakIndex = leftIndex;
        rightIndex = leftIndex;
        leftIndex = 0;
        // 尝试从前到顶峰找 target
        while (leftIndex <= rightIndex) {
            int midIndex = leftIndex + (rightIndex - leftIndex) / 2;
            // [1, 2, 3, 4, 5] target = 3
            if (mountainArr.get(midIndex) == target) {
                return midIndex;
            } else if (mountainArr.get(midIndex) < target) {
                // [midIndex + 1, rightIndex]
                leftIndex = midIndex + 1;
            } else {
                // [leftIndex, midIndex - 1]
                rightIndex = midIndex - 1;
            }
        }
        // 前面找不到找后面
        leftIndex = peakIndex + 1;
        rightIndex = mountainArr.length() - 1;

        while (leftIndex <= rightIndex) {
            int midIndex = leftIndex + (rightIndex - leftIndex) / 2;
            if (mountainArr.get(midIndex) == target) {
                return midIndex;
            }
            // [5, 4, 3, 2, 1] target = 3;
            if (mountainArr.get(midIndex) < target) {
                // [leftIndex, midIndex]
                rightIndex = midIndex - 1;
            } else {
                // [midIndex + 1, rightIndex]
                leftIndex = midIndex + 1;
            }
        }

        return -1;
    }

    /**
     * 供 leetcode 使用，防止编译错误
     */
    class MountainArray {

        int[] arr = {1, 2, 3, 4, 5, 3, 1, 2};

        public int get(int k) {
            return arr[k];
        }

        public int length() {
            return arr.length;
        }

    }

}

