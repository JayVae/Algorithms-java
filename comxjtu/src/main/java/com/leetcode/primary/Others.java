package com.leetcode.primary;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Jay
 * @Date: Created in 18:58 2018/6/7
 * @Modified By:
 */
public class Others {
    public int hammingWeight(int n) {
        int count =0;
        while (n!=0) {
            n= n& (n-1);   //每次操作都是从后面消除第一个1
            count++;
        }
        return count;
    }

    public int hammingDistance(int x, int y) {
        int count = 0;
        int m = x^y;
        while (m!=0){
            m = m&(m-1);
            count++;
        }
        return count;
    }

    public int reverseBits(int n) {

        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += n & 1;
            n >>>= 1;
            if (i < 31) {
                result <<= 1;
            }
        }
        return result;
    }

    public boolean isValid(String s) {
        if (s == null || s.length() % 2 > 0)
            return false;

        int sum = 0;
        int num = 0; // 系数
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                    num = num + 1;
                    sum = sum + (1 * num);
                    break;
                case '[':
                    num = num + 1;
                    sum = sum + (10 * num);
                    break;
                case '{':
                    num = num + 1;
                    sum = sum + (100 * num);
                    break;
                case ')':
                    if (num == 0)
                        return false;
                    sum = sum - (1 * num);
                    num = num - 1;
                    break;
                case ']':
                    if (num == 0)
                        return false;
                    sum = sum - (10 * num);
                    num = num - 1;
                    break;
                case '}':
                    if (num == 0)
                        return false;
                    sum = sum - (100 * num);
                    num = num - 1;
                    break;

                default:
                    return false;
            }
        }

        return sum == 0;
    }

    public int missingNumber(int[] nums) {
        if (nums.length==0) return 0;
        Arrays.sort(nums);
        if (nums[0]!=0) return 0;
        if (nums.length==1){
            return 1;
        }
        for (int i = 1; i < nums.length; i++) {
            if ((nums[i]-nums[i-1])!=1) return i;
        }
        return nums.length;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new LinkedList<>();
        if (numRows<1) return list;

        List<Integer> pre = new LinkedList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> l = new LinkedList<>();
            for (int j = 0; j < i; j++) {
                if (j==0) l.add(1);
                else l.add(pre.get(j-1)+pre.get(j));
            }
            l.add(1);
            list.add(l);
            pre = l;
        }
        return list;
    }

    public static void main(String[] args){
        Others o = new Others();
        System.out.println(Math.pow(2,0));
        System.out.println(Math.pow(2,3));
        int an = o.reverseBits(0);
        System.out.println(an);
    }
}
