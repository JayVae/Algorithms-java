package com.leetcode.otherSet.number;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author JS
 * @version 1.0
 * @date 2023/5/10 9:44
 * @description //1015. 可被 K 整除的最小整数

 */
public class SmallestRepunitDivByK {
    public int smallestRepunitDivByK(int k) {
        int resid = 1 % k, len = 1; // resid为余数，len为数字长度，初始值为1
        Set<Integer> set = new HashSet<Integer>(); // 创建一个无序集合，用于存储余数
        set.add(resid); // 插入余数1
        while (resid != 0) { // 当余数为0时退出循环
            resid = (resid * 10 + 1) % k; // 计算下一个余数
            len++; // 数字长度+1
            if (set.contains(resid)) { // 如果余数重复出现，则无解
                return -1;
            }
            set.add(resid); // 将余数插入集合
        }
        return len; // 返回数字长度
    }
}
