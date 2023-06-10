package com.leetcode.everyday;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author JS
 * @version 1.0
 * @date 2023/6/10 9:06
 * @description //1170. 比较字符串最小字母出现频次
 */
public class NumSmallerByFrequency {

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] ans = new int[queries.length];

//        先对words处理，将其保存在hashmap中
        Map<Integer, Integer> map = new HashMap<>();
        for (String word : words) {
            int count = f(word);
            map.put(count, map.getOrDefault(count, 0)+1);
        }

        int i = 0;
        for (String query : queries) {
            int count = f(query);
            int ansNow = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getKey()>count) ansNow+=entry.getValue();
            }
            ans[i]=ansNow;
            i++;
        }
        return ans;
    }

    private int f(String word) {
        int ans = 1;
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        for (int i = 0; i < chars.length-1; i++) {
            if (chars[i]==chars[i+1]) ans++;
            else break;
        }
        return ans;
    }
}
