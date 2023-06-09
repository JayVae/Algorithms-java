package com.leetcode.topinterview150.array;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author JS
 * @version 1.0
 * @date 2023/6/9 16:47
 * @description //堆的应用
 */
public class Heap {
    /*
    * 215. 数组中的第K个最大元素
    * 要求的是第k大，即构建的堆需要最大的前k个，返回的值为堆顶------> 构建最小堆minHeap
    * */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k,(a,b)->a-b);
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i]>minHeap.peek()){
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }

        return minHeap.peek();
    }

    /*
    * 502. IPO
    * */
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int curr = 0;
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; ++i) {
            arr[i][0] = capital[i];
            arr[i][1] = profits[i];
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        for (int i = 0; i < k; ++i) {
            while (curr < n && arr[curr][0] <= w) {
                pq.add(arr[curr][1]);
                curr++;
            }
            if (!pq.isEmpty()) {
                w += pq.poll();
            } else {
                break;
            }
        }

        return w;
    }

    public static void main(String[] args) {

    }


}
