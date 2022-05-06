package com.leetcode.everyday;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author JS
 * @version 1.0
 * @date 2022/5/6 9:57
 * @description //lc933写一个 RecentCounter 类来计算特定时间范围内最近的请求。
 */
public class RecentCounter {

    private Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        while (queue.peek()!=null && queue.peek()<t-3000){
            queue.remove();
        }
        queue.offer(t);
        return queue.size();
    }
}
