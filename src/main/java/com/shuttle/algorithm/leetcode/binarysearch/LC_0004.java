package com.shuttle.algorithm.leetcode.binarysearch;

/**
 * @author: Shuttle
 * @description: 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
 * 示例 1：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 */
public class LC_0004 {

    /**
     * 解法一：将两个数组合并，直接计算中位数
     * 时间复杂度：O(n + m) n 是 nums1 数组的长度，m 是 nums2 数组的长度
     * 空间复杂度：O(n + m) 创建了一个数组用于存放 nums1 和 nums2 的值
     *
     * @param nums1 正序数组 1
     * @param nums2 正序数组 2
     * @return 两个正序数组的中位数
     */
    public double findMedianSortedArraysSolution1(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return 0.0;
        }
        int n1Len = nums1.length;
        int n2Len = nums2.length;
        if (n1Len == 0) {
            if (n2Len % 2 == 0) {
                return (nums2[n2Len / 2 - 1] + nums2[n2Len / 2]) / 2.0;
            } else {
                return nums2[n2Len / 2];
            }
        }
        if (n2Len == 0) {
            if (n1Len % 2 == 0) {
                return (nums1[n1Len / 2 - 1] + nums1[n1Len / 2]) / 2.0;
            } else {
                return nums1[n1Len / 2];
            }
        }
        int[] allNums = new int[n1Len + n2Len];
        int count = 0;
        int n1Index = 0;
        int n2Index = 0;

        while (count != (n1Len + n2Len)) {
            if (n1Index == n1Len) {
                while (n2Index != n2Len) {
                    allNums[count++] = nums2[n2Index++];
                }
                break;
            }
            if (n2Index == n2Len) {
                while (n1Index != n1Len) {
                    allNums[count++] = nums1[n1Index++];
                }
                break;
            }
            if (nums1[n1Index] > nums2[n2Index]) {
                allNums[count++] = nums2[n2Index++];
            } else {
                allNums[count++] = nums1[n1Index++];
            }
        }

        if (count % 2 == 0) {
            return (allNums[count / 2 - 1] + allNums[count / 2]) / 2.0;
        } else {
            return allNums[count / 2];
        }
    }

    /**
     * 解法二：划分数组
     * 时间复杂度：O(log min(n, m))，n 是 nums1 数组的长度，m 是 nums2 数组的长度
     * 空间复杂度：O(1)
     *
     * @param nums1 正序数组 1
     * @param nums2 正序数组 2
     * @return 两个正序数组的中位数
     */
    public double findMedianSortedArraysSolution2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return 0.0;
        }
        if (nums1.length > nums2.length) {
            return findMedianSortedArraysSolution2(nums2, nums1);
        }
        int n1Len = nums1.length;
        int n2Len = nums2.length;
        int left = 0;
        int right = n1Len;
        // 第一部分的最大值和第二部分的最小值
        int part1Max = 0;
        int part2Min = 0;

        while (left <= right) {
            // 前一部分包含 nums1[0 .. n1Index - 1] 和 nums2[0 .. n2Index - 1]
            // 后一部分包含 nums1[n1Index .. n1Len - 1] 和 nums2[n2Index .. n2Len - 1]
            int n1Index = (left + right) / 2;
            // 如果需要保证两个部分元素个数相同得保证以下两点
            // 偶数时：n1Index + n2Index = n1Len - n1Index + n2Len - n2Index
            // 奇数时：n1Index + n2Index = n1Len - n1Index + n2Len - n2Index + 1
            // 规定 A 的长度小于 B 的长度，不然这里计算 n2Index 可能为负数
            int n2Index = (n1Len + n2Len + 1) / 2 - n1Index;

            // 当一个数不出现在前一个部分时，对应的值为负无穷，这样不会对前一部分的最大值产生影响
            // 当一个数不出现在后一个部分时，对应的值为正无穷，这样不会对后一部分的最小值产生影响，
            int n1Part1Max = (n1Index == 0 ? Integer.MIN_VALUE : nums1[n1Index - 1]);
            int n1Part2Min = (n1Index == n1Len ? Integer.MAX_VALUE : nums1[n1Index]);
            int n2Part1Max = (n2Index == 0 ? Integer.MIN_VALUE : nums2[n2Index - 1]);
            int n2Part2Min = (n2Index == n2Len ? Integer.MAX_VALUE : nums2[n2Index]);

            if (n1Part1Max <= n2Part2Min) {
                // 如果后一部分的最小值大于等于前一部分的最大值，说明需要进行划分
                // 划分前一部分元素中的最大值，以及划分后一部分元素中的最小值
                part1Max = Math.max(n1Part1Max, n2Part1Max);
                part2Min = Math.min(n1Part2Min, n2Part2Min);
                left = n1Index + 1;
            } else {
                right = n1Index - 1;
            }
        }

        return (n1Len + n2Len) % 2 == 0 ? (part1Max + part2Min) / 2.0 : part1Max;
    }

}
