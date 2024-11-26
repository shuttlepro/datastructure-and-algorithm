package com.shuttle.datastructure.leetcode.queue;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/k-closest-points-to-origin/description">最接近原点的 K 个点</a>
 */
public class LC_0973 {

    /**
     * 思路：优先队列
     * 时间复杂度：O(n * log k)，n 是点的数量，k 是返回的点的数量
     * 空间复杂度：O(k)
     *
     * @param points 由 x,y 坐标组成的点组成的数组
     * @param k      返回点的数量
     * @return 离原点最近的 k 个点
     */
    public int[][] kClosest(int[][] points, int k) {
        // 优先队列 [距离，索引] 距离远的放队列前面，方便出队
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        for (int i = 0; i < k; i++) {
            // 先放入 k 个元素
            int distance = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            queue.offer(new int[]{distance, i});
        }

        int len = points.length;
        for (int i = k; i < len; i++) {
            // 继续遍历后续的元素，与队首的距离进行比较，距离远的出队，近的入队
            int distance = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            if (distance < queue.peek()[0]) {
                queue.poll();
                queue.offer(new int[]{distance, i});
            }
        }

        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] poll = queue.poll();
            int index = poll[1];
            res[i] = points[index];
        }

        return res;
    }
}
