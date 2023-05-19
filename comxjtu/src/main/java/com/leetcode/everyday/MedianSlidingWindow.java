package com.leetcode.everyday;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author JS
 * @version 1.0
 * @date 2023/5/19 21:30
 * @description //力扣 480. 滑动窗口中位数
 */
public class MedianSlidingWindow {

//    中位数是有序序列最中间的那个数。如果序列的长度是偶数，则没有最中间的数；此时中位数是最中间的两个数的平均数。
    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 大根堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 小根堆
        double[] medians = new double[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            // Step 1: 维护两个堆的大小，并将元素分别插入
            if (i >= k) {
                // 判断堆顶元素是否失效
                if (maxHeap.contains(nums[i - k])) {
                    maxHeap.remove(nums[i - k]);
                } else {
                    minHeap.remove(nums[i - k]);
                }
            }
            if (maxHeap.size() <= minHeap.size()) {
                maxHeap.offer(nums[i]);
            } else {
                minHeap.offer(nums[i]);
            }
            // Step 2: 平衡两个堆
            if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
                int maxHeapTop = maxHeap.poll();
                int minHeapTop = minHeap.poll();
                maxHeap.offer(minHeapTop);
                minHeap.offer(maxHeapTop);
            }
            // Step 3: 找中位数
            if (i >= k - 1) { // 当窗口的大小大于等于k时，才可以找到中位数
                double median;
                if (k % 2 == 0) {
                    median = ((double) maxHeap.peek() + minHeap.peek()) / 2;
                } else {
                    median = maxHeap.peek();
                }
                medians[i - k + 1] = median;
            }
        }
        return medians;
    }

    public static void main(String[] args) {
        MedianSlidingWindow s = new MedianSlidingWindow();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        double[] result = s.medianSlidingWindow(nums, k);
        System.out.println(Arrays.toString(result)); // [1.0, -1.0, -1.0, 3.0, 5.0, 6.0]
    }
}
