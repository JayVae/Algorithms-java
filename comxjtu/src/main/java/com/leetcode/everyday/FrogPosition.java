package com.leetcode.everyday;

import lombok.experimental.var;

import java.util.*;

/**
 * @author JS
 * @version 1.0
 * @date 2023/5/24 9:48
 * @description //1377. T 秒后青蛙的位置
 */
public class FrogPosition {

    public double frogPosition(int n, int[][] edges, int t, int target) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        double[] prob = new double[n + 1];
        prob[1] = 1.0;
        while (!queue.isEmpty() && t-- > 0) {
            for (int sz = queue.size(); sz > 0; --sz) {
                int cur = queue.poll();
                int nextCount = 0;
                for (int next : graph.getOrDefault(cur, new ArrayList<>())) {
                    if (prob[next] == 0) {
                        ++nextCount;
                    }
                }
                for (int next : graph.getOrDefault(cur, new ArrayList<>())) {
                    if (prob[next] == 0) {
                        queue.offer(next);
                        prob[next] = prob[cur] / nextCount;
                    }
                }
                if (nextCount > 0) {
                    prob[cur] = 0;
                }
            }
        }
        return prob[target];
    }

    public static void main(String[] args) {
        FrogPosition solver = new FrogPosition();
        int n = 7;
        int[][] edges = {{1,2},{1,3},{1,7},{2,4},{2,6},{3,5}};
        int t = 2;
        int target = 4;
        System.out.println(solver.frogPosition(n,edges,t,target));
    }
}
