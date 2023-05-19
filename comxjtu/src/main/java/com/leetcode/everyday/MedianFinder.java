package com.leetcode.everyday;

import java.util.PriorityQueue;

/**
 * @author JS
 * @version 1.0
 * @date 2023/5/19 21:16
 * @Description //剑指 Offer 41. 数据流中的中位数
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *
 */
public class MedianFinder {
    /** initialize your data structure here. */
    PriorityQueue<Integer> left;//大顶
    PriorityQueue<Integer> right;//小顶
    public MedianFinder() {
        left=new PriorityQueue<>((n1,n2)->n2-n1);
        right=new PriorityQueue<>();
    }
    public void addNum(int num) {
        left.add(num);
        right.add(left.poll());
        if(left.size()+1<right.size())
            left.add(right.poll());
    }
    public double findMedian() {
        if(right.size()>left.size())return right.peek();
        return (double)(left.peek()+right.peek())/2;
    }
}
