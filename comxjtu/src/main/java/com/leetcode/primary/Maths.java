package com.leetcode.primary;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Jay
 * @Date: Created in 16:12 2018/6/7
 * @Modified By:
 */
public class Maths {

    public boolean isPowerOfThree(int n) {
        if (n<=0) return false;
        if (n==1||n==3) return true;
        if (n%2==0) return false;
        int maxPower = (int) Math.pow(3,(int)(Math.log(0x7fffffff)/Math.log(3)));
        return maxPower % n == 0 ;
    }

    public List<String> fizzBuzz(int n) {
        if (n<1) return null;
        List<String> list = new LinkedList<>();
        for (int i = 1; i < n+1; i++) {
            if (i%3==0 && i%5==0){
                list.add("FizzBuzz");
            }else if (i%3==0){
                list.add("Fizz");
            }else if (i%5==0){
                list.add("Buzz");
            }else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }

    /**
     * 如果一个数是另一个数的倍数，那这个数肯定不是质数。利用这个性质，可以建立一个质数数组，从2开始将素数的倍数都标注为不是质数。
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        boolean[] prime = new boolean[n];
        Arrays.fill(prime, true);
        for(int i = 2; i < n; i++){
            if(prime[i]){
                // 将i的2倍、3倍、4倍...都标记为非素数
                for(int j = i * 2; j < n; j =  j + i){
                    prime[j] = false;
                }
            }
        }
        int count = 0;
        for(int i = 2; i < n; i++){
            if(prime[i]) count++;
        }
        return count;
    }

    public int romanToInt(String s) {

    }

    public static void main(String[] args){
        System.out.println(Math.sqrt(45)%3);
        boolean ans = new Maths().isPowerOfThree(9);
        System.out.println(Math.sqrt(27/3));
        System.out.println(Math.sqrt(27/3)==0);
        System.out.println(ans);
    }
}
