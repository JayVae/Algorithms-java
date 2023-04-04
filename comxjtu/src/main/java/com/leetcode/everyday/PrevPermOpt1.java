package com.leetcode.everyday;

import java.util.Arrays;

/**
 * @author JS
 * @version 1.0
 * @date 2023/4/3 11:17
 * @description //1053. 交换一次的先前排列
 */
public class PrevPermOpt1 {

    public int[] prevPermOpt1(int[] A) {
        int len = A.length;
        int curMax = -1;
        int index = -1;
        boolean hasResult = false;
        for (int i = len - 2; i >= 0; i--) {
            if (A[i+1] < A[i]) {                    // 此处逆序，需要移动A[i]
                for (int j = i + 1; j < len; j++) { // 寻找与 A[i] 交换的位置
                    if (A[i] > A[j]) {               // 必须满足 A[i] > A[j]，否则不能满足交换后的字典序小于原始字典序
                        hasResult = true;
                        if (A[j] > curMax) {
                            curMax = A[j];
                            index = j;
                        }
                    }
                }
                if (hasResult) {
                    int tmp = A[i];
                    A[i] = A[index];
                    A[index] = tmp;
                    return A;
                }
            }
        }
        return A;
    }
}
