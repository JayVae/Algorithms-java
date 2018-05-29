package com.leetcode.primary;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Jay
 * @Date: Created in 18:00 2018/5/29
 * @Modified By:
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits==null) return null;
        if (digits.length==0) return null;
        int N = digits.length;
        List<Integer> list = new LinkedList();
        int jinwei = 0;
        if (digits[N-1]==9){
            list.add(0);
            jinwei=1;
        }else {
            list.add(digits[N-1]+1);
        }
        for (int i = N - 2; i >= 0; i--) {
            if (jinwei+digits[i]>9){
                list.add(jinwei+digits[i]-10);
            }else {
                list.add(jinwei+digits[i]);
                jinwei=0;
            }
        }
        if (jinwei==1) list.add(1);
        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(list.size()-1-i);
        }
        return ans;
    }
}
