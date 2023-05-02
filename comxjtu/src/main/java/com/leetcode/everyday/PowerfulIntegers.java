package com.leetcode.everyday;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author JS
 * @version 1.0
 * @date 2023/5/2 21:35
 * @description //970. 强整数
 */
class PowerfulIntegers {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set = new HashSet<Integer>();
        int value1 = 1;
        for (int i = 0; i < 21; i++) {
            int value2 = 1;
            for (int j = 0; j < 21; j++) {
                int value = value1 + value2;
                if (value <= bound) {
                    set.add(value);
                } else {
                    break;
                }
                value2 *= y;
            }
            if (value1 > bound) {
                break;
            }
            value1 *= x;
        }
        return new ArrayList<Integer>(set);
    }
}

