package com.leetcode.everyday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author JS
 * @version 1.0
 * @date 2022/4/27 18:50
 * @description //TODO
 */
public class PacificAtlantic {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> resultList = new LinkedList<>();
        if (heights == null){
            return resultList;
        }
        int m = heights.length, n = heights[0].length;

        //右上角和左下角
        List<Integer> listRight = new ArrayList(Arrays.asList(new int[]{0,n-1}));
        resultList.add(listRight);
        if (m == 1 && n == 1){
            return resultList;
        }
        List<Integer> listLeft = new ArrayList(Arrays.asList(new int[]{m-1,0}));
        resultList.add(listLeft);

        //处理每一行

        return resultList;
    }

    public static void main(String[] args) {

    }
}
