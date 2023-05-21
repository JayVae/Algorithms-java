package com.leetcode.everyday;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.apache.commons.lang3.CharSetUtils.count;

/**
 * @author JS
 * @version 1.0
 * @date 2023/5/21 17:45
 * @description //TODO
 */
public class WordSubsets {

    public List<String> wordSubsets(String[] A, String[] B) {
        int[] bmax = count("");
        for (String b: B) {
            int[] bCount = count(b);
            for (int i = 0; i < 26; ++i)
                bmax[i] = Math.max(bmax[i], bCount[i]);
        }

        List<String> ans = new LinkedList<>();
        for (String a : A) {
            int[] aCount = count(a);
            boolean shouldAdd = true;
            for (int i = 0; i < 26; ++i) {
                if (aCount[i] < bmax[i]) {
                    shouldAdd = false;
                    break;
                }
            }
            if (shouldAdd) {
                ans.add(a);
            }
        }

        return ans;
    }

    public int[] count(String S) {
        int[] ans = new int[26];
        for (char c: S.toCharArray())
            ans[c - 'a']++;
        return ans;
    }
}
