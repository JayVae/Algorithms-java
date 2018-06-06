package com.leetcode.primary;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author: Jay
 * @Date: Created in 19:52 2018/6/6
 * @Modified By:
 */
public class Shuffle {

    private final int[] nums;
    public Shuffle(int[] nums) {
        this.nums = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if(nums.length<=1)
            return nums;
        int[] cp = Arrays.copyOf(nums, nums.length);
        Random rnd = new Random();
        for (int i = nums.length - 1; i > 0; i--) {
            int j = rnd.nextInt(i + 1);
            //swap index i, j
            int t =cp[i];
            cp[i] = cp[j];
            cp[j] = t;
        }
        return cp;
    }

    public static void main(String[] args){
        Shuffle s = new Shuffle(new int[]{1,2,3,4,5,6});
        int[] ans = s.shuffle();
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]);
        }
        System.out.println("*****");
        System.out.println(s.reset());
        ans = s.shuffle();
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]);
        }
    }
}
