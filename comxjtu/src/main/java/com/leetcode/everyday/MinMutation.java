package com.leetcode.everyday;

/**
 * @author JS
 * @version 1.0
 * @date 2022/5/7 9:42
 * @description //TODO
 */
public class MinMutation {

    int ret=Integer.MAX_VALUE;
    public int minMutation(String start, String end, String[] bank) {
        boolean[] used = new boolean[bank.length];
        backtrack(end, bank,start,0, used);
        return ret==Integer.MAX_VALUE?-1:ret;
    }
    private void backtrack(String end, String[] bank, String now,int i, boolean[] used) {
        if (now.equals(end)) ret = Math.min(ret, i);

        for (int j = 0; j < bank.length; j++) {
            if (!used[j] && caculateLen(now, bank[j])==1){
                used[j]=true;
                backtrack(end, bank,bank[j], i+1, used);
                used[j]=false;
            }
        }
    }

    private int caculateLen(String start, String end) {
        int res = 0;
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i)!=end.charAt(i)) res++;
        }
        return res;
    }

    public static void main(String[] args) {
        MinMutation minMutation = new MinMutation();
        int res = minMutation.minMutation(        "AACCGGTT", "AAACGGTA", new String[]{"AACCGATT","AACCGATA","AAACGATA","AAACGGTA"});
        System.out.println(res);
    }
}
