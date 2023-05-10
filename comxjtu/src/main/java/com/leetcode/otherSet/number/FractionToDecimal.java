package com.leetcode.otherSet.number;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JS
 * @version 1.0
 * @date 2023/5/10 11:40
 * @description //166. 分数到小数
 * 为了解答这个问题，需要了解以下知识点：
 * 分数的基本知识，包括分子、分母、约分等。
 * 循环小数的知识，以及如何将循环部分用括号括起来。
 * 哈希表的应用，以及如何用哈希表来判断循环小数。
 */
public class FractionToDecimal {

    public String fractionToDecimal(int numerator, int denominator) {
        long numeratorLong = (long) numerator;
        long denominatorLong = (long) denominator;
        if (numeratorLong % denominatorLong == 0) {
            return String.valueOf(numeratorLong / denominatorLong);
        }

        StringBuffer sb = new StringBuffer();
        if (numeratorLong < 0 ^ denominatorLong < 0) {
            sb.append('-');
        }

        // 整数部分
        numeratorLong = Math.abs(numeratorLong);
        denominatorLong = Math.abs(denominatorLong);
        long integerPart = numeratorLong / denominatorLong;
        sb.append(integerPart);
        sb.append('.');

        // 小数部分
        StringBuffer fractionPart = new StringBuffer();
        Map<Long, Integer> remainderIndexMap = new HashMap<Long, Integer>();
        long remainder = numeratorLong % denominatorLong;
        int index = 0;
        while (remainder != 0 && !remainderIndexMap.containsKey(remainder)) {
            remainderIndexMap.put(remainder, index);
            remainder *= 10;
            fractionPart.append(remainder / denominatorLong);
            remainder %= denominatorLong;
            index++;
        }
        if (remainder != 0) { // 有循环节
            int insertIndex = remainderIndexMap.get(remainder);
            fractionPart.insert(insertIndex, '(');
            fractionPart.append(')');
        }
        sb.append(fractionPart.toString());

        return sb.toString();
    }

}
