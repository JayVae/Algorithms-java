package com.leetcode.everyday;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @author JS
 * @version 1.0
 * @date 2023/5/23 10:13
 * @description //1090. 受标签影响的最大值
 */
public class LargestValsFromLabels {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        Integer[] id = new Integer[values.length];
        for (int i = 0; i < values.length; i++) {
            id[i] = i;
        }
        Arrays.sort(id, (a, b) -> values[b] - values[a]);

        HashMap<Integer, Integer> hashMap = new LinkedHashMap<>();
        for (int label : labels) {
            hashMap.put(label, 0);
        }
        int ans = 0, numCount = 0;
        for (int j = 0; j < id.length && numCount<numWanted; j++) {
            int count = hashMap.get(labels[id[j]]);
            if (count<useLimit){
                ans += values[id[j]];
                hashMap.put(labels[id[j]], count+1);
                numCount++;
            }
        }

        return ans;

    }
}
