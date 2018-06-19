package com.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Jay
 * @Date: Created in 20:56 2018/6/16
 * @Modified By:
 */
public class SortandSearch {
    //今天是端午啊，下雨，心情平静,什么都没做，还一直没网~~~

    /**
     * 分类颜色：
     * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     * 方法二是遍历一次，常数空间。
     * @param nums
     */
    public void sortColors(int[] nums) {
        if (nums.length<2) return;
        int[] map = new int[3];
        for (int i = 0; i < nums.length; i++) {
            switch (nums[i]){
                case 0:
                    map[0]++;
                    break;
                case 1:
                    map[1]++;
                    break;
                case 2:
                    map[2]++;
                    break;
                default:
                    break;
            }
        }
        for (int i = 0; i < map[0]; i++) {
            nums[i]=0;
        }
        for (int i = map[0]; i < map[1] + map[0]; i++) {
            nums[i]=1;
        }
        for (int i = map[0]+map[1]; i < nums.length; i++) {
            nums[i]=2;
        }
    }
    public void sortColors1(int[] nums) {
        int i = -1,j = -1,k = -1;
        for(int m = 0; m < nums.length; m++){
            if(nums[m] == 0){
                nums[++k] = 2;
                nums[++j] = 1;
                nums[++i] = 0;
            }else if(nums[m] == 1){
                nums[++k] = 2;
                nums[++j] = 1;
            }else{
                nums[++k] = 2;
            }
        }
    }

    /**
     * Top K Frequent Elements
     给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent(int[] nums, int k) {

        List<Integer> res = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n > max)
                max = n;
            if (n < min)
                min = n;
        }
        int[] bucket = new int[max - min + 1];
        for (int n : nums)
            bucket[n - min]++;

        List<Integer>[] array = new ArrayList[nums.length + 1];
        for (int i = 0; i < bucket.length; i++) {
            if (array[bucket[i]] == null) {
                array[bucket[i]] = new ArrayList<>();
            }
            array[bucket[i]].add(i + min);
        }
        for (int i = array.length - 1; i > 0; i--) {
            if (array[i] != null) {
                for (Integer n : array[i]) {
                    res.add(n);
                    if (res.size() == k)
                        return res;
                }
            }
        }

        return res;

    }
}
