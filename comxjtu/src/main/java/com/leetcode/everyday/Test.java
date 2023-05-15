package com.leetcode.everyday;

import java.util.HashMap;
import java.util.Map;

public class Test {

    /**
     *
     * @Param
     * @Description //1072. 按列翻转得到最大值等行数
     * 给定m x n矩阵matrix。
     * 你可以从中选出任意数量的列并翻转其上的每个单元格。（即翻转后，单元格的值从 0 变成 1，或者从 1 变为 0 。）
     * 返回 经过一些翻转后，行与行之间所有值都相等的最大行数。
     * @Date 10:01 2023/5/15
     * @return
     **/
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        // 统计每行翻转后形成的01序列的数量，相同的一定可以放在同一组
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (int j = 0; j < matrix[0].length; j++) {
                // 正序拼接和倒序拼接
                sb1.append(matrix[i][j]);
                sb2.append(1 - matrix[i][j]);
            }
            // 存储相同的01序列的数量
            String s1 = sb1.toString();
            String s2 = sb2.toString();
            map.put(s1, map.getOrDefault(s1, 0) + 1);
            map.put(s2, map.getOrDefault(s2, 0) + 1);
        }
        int maxRows = 0;
        for (int value : map.values()) {
            // 更新最大行数
            maxRows = Math.max(maxRows, value);
        }
        return maxRows;
    }

     void testWithFiveExamples(){
            int[][] matrix = {{0,1},{1,1}};
        int[][] matrix1 = {{0,1},{1,0}};
        int[][] matrix2 = {{0,0,0},{0,0,1},{1,1,0}};
        int[][] matrix3 = {{1,0,0,0,1,1,1,0,1,1,1},{1,0,0,0,1,0,0,0,1,0,0},{1,0,0,0,1,1,1,0,1,1,1},{1,0,0,0,1,0,0,0,1,0,0},{1,1,1,0,1,1,1,0,1,1,1}};
        int[][] matrix4 = {{0,0,0,0,1,1,1},{0,0,0,0,1,0,1},{1,1,1,0,1,1,1},{0,0,0,0,1,0,0},{0,0,1,0,1,0,0},{0,1,1,0,1,0,0},{0,0,0,0,1,1,1},{0,0,0,0,1,0,0},{0,0,0,0,1,0,0},{0,0,0,0,1,0,0}};
        System.out.println(maxEqualRowsAfterFlips(matrix));
        System.out.println(maxEqualRowsAfterFlips(matrix1));
        System.out.println(maxEqualRowsAfterFlips(matrix2));
        System.out.println(maxEqualRowsAfterFlips(matrix3));
        System.out.println(maxEqualRowsAfterFlips(matrix4));
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.testWithFiveExamples();
    }



}
