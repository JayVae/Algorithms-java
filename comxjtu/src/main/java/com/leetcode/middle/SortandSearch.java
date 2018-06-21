package com.leetcode.middle;

import java.util.*;

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
     给定一个非空的整数数组，返回其中出现频率前 k 高的元素。:https://blog.csdn.net/x_i_y_u_e/article/details/52278842
     方法二使用优先队列
     * @param nums
     * @param k
     * @return
     */
    /** 求一个数组中，出现次数最多的k个数，利用桶排序的思想，注意这里的桶排序空间
     * 复杂度为O(n)，桶的下标表示出现的次数，桶的元素是一个List，表示所有出现了
     * 这些次数的元素，厉害
     * */
    public List<Integer> topKFrequent(int[] nums, int k) {

        //第一步，还是先统计每个数字出现的次数，这个貌似不可避免，时间复杂度为O(n)
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            Integer count = map.get(nums[i]);
            if(count==null){
                count = 0;
            }
            map.put(nums[i], count+1);
        }

        //第二步，构造一个桶，下标表示出现次数，如果nums大小为n，且这n个数相等，那么
        //出现次数最大为n，所有桶的大小为n+1
        //这个桶实际上是将上面那个map的key value翻转了一下，因为对于同一个value可能有多个
        //key，所以buckey的元素应该是个列表,第一次这么用列表
        List<Integer>[] bucket = new List[nums.length+1];

        for(int key:map.keySet()){
            int count = map.get(key);
            if(bucket[count]==null){
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(key);
                bucket[count] = temp;
            }else{
                bucket[count].add(key);
            }
        }

        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i=bucket.length-1;i>=0&&res.size()<k;i--){
            if(bucket[i]!=null){
                //这里addAll是因为题目说明了只有一个唯一解，是个特例
                res.addAll(bucket[i]);
            }
        }
        return res;
    }
    //返回一个数组中，出现次数最多的k个数
    public List<Integer> topKFrequent2(int[] nums, int k) {

        //先统计每个数字出现的次数，这个貌似不可避免，时间复杂度为O(n)
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            Integer count = map.get(nums[i]);
            if(count==null){
                count = 0;
            }
            map.put(nums[i], count+1);
        }

        //然后应该可以使用优先队列了，
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k,new Comp(map));

        for(int key:map.keySet()){
            if(pq.size()<k){
                pq.add(key);
                continue;
            }

            int small = pq.peek();
            if(map.get(small)<map.get(key)){
                pq.poll();
                pq.add(key);
            }
        }
        return new ArrayList<Integer>(pq);
    }

    //注意构造函数，使用map来初始化
    class Comp implements Comparator<Integer>{

        HashMap<Integer,Integer> map;
        public Comp(HashMap<Integer,Integer> map){
            this.map = map;
        }

        @Override  //通过key的value来排序
        public int compare(Integer o1, Integer o2) {
            return map.get(o1)-map.get(o2);
        }

    }

    /**
     * 数组中的第K个最大元素
     * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     * 方法一采用了快速排序的思想，方法二采取了桶排序的方法
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {

        shuffle(nums);
        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            final int j = partition(nums, lo, hi);
            if(j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }

    private void shuffle(int a[]) {

        final Random random = new Random();
        for(int ind = 1; ind < a.length; ind++) {
            final int r = random.nextInt(ind + 1);
            exch(a, ind, r);
        }
    }
    private int partition(int[] a, int lo, int hi) {

        int i = lo;
        int j = hi + 1;
        while(true) {
            while(i < hi && less(a[++i], a[lo]));
            while(j > lo && less(a[lo], a[--j]));
            if(i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private void exch(int[] a, int i, int j) {
        final int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private boolean less(int v, int w) {
        return v < w;
    }
    public int findKthLargest1(int[] nums, int k) {

        int max = nums[0];
        int min = nums[0];

        for(int num: nums) {
            if(num > max) {
                max = num;
            }
            if(num < min) {
                min = num;
            }
        }

        int[] bucket = new int[max -min +1];
        for(int num : nums) {
            bucket[num - min]++;

        }
        int count = 0;
        for(int i = bucket.length-1; i>-1; i--) {
            count += bucket[i];
            if(count >= k) {
                return i + min;
            }
        }
        return -1;
    }

    /**
     * 寻找峰值：峰值元素是指其值大于左右相邻值的元素。
     * 方法2是二分查找
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        if (nums.length<1) return -1;
        if (nums.length==1 ) return 0;
        if (nums[0]>nums[1]) return 0;
        for (int i = 1; i < nums.length-1; i++) {
            if (nums[i-1]<nums[i] && nums[i]>nums[i+1]) return i;
        }
        if (nums[nums.length-1]>nums[nums.length-2]) return nums.length-1;
        return -1;
    }
    public int findPeakElement2(int[] nums) {
        int i=0, j=nums.length-1;
        while (i<j) {
            int m = (i+j)/2;
            if (nums[m] > nums[m+1]) j=m; else i=m+1;
        }
        return i;
    }

    /**
     * 搜索范围：给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums.length<1) return new int[]{-1,-1};
        int ans = binarySearch(nums,target,0,nums.length-1);
        if (ans==-1){
            return new int[]{-1,-1};
        }else {
            int[] res = new int[2];
            int start=ans,end=ans;
            while (start!=-1){
                if (start!=0){
                    ans = start;
                    start = binarySearch(nums,target,0,start-1);
                }else {
                    start = 0;
                    break;
                }
            }
            if (start!=0){
                start = ans;
            }
            while (end!=-1){
                if (end!=nums.length-1){
                    ans = end;
                    end = binarySearch(nums,target,end+1,nums.length-1);
                }else {
                    end = nums.length-1;
                    break;
                }
            }
            if (end!=nums.length-1){
                end = ans;
            }
/*
            if (ans!=nums.length-1){
                end = binarySearch(nums,target,ans+1,nums.length-1);
                if (end==-1){
                    end = ans;
                }
            }else {
                end = ans;
            }*/
            return new int[]{start,end};
            /*boolean flag = false;
            for (int i = ans+1; i < nums.length; i++) {
                if (nums[i]!=target){
                    res[1] = i-1;
                    flag = true;
                    break;
                }
            }
            if (!flag) res[1] = nums.length-1;
            flag = false;
            for (int i = ans-1; i >=0; i--) {
                if (nums[i]!=target){
                    res[0] = i+1;
                    flag = true;
                    break;
                }
            }
            if (!flag) res[0] = 0;
            return res;*/
        }

    }
    private int binarySearch(int[] nums,int target,int low,int high){
        int lo = low, hi = high;
        while (lo<=hi){
            int mid = (lo + hi)/2;
            if (nums[mid]<target) lo = mid+1;
            else if (nums[mid]>target) hi = mid-1;
            else return mid;
        }
        return -1;
    }

    /**
     * 合并区间：给出一个区间的集合，请合并所有重叠的区间。
     * @param intervals
     * @return
     */
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1)
            return intervals;

        // Sort by ascending starting point using an anonymous Comparator
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));

        List<Interval> result = new LinkedList<Interval>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (Interval interval : intervals) {
            if (interval.start <= end) // Overlapping intervals, move the end if needed
                end = Math.max(end, interval.end);
            else {                     // Disjoint intervals, add the previous one and reset bounds
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }

        // Add the last interval
        result.add(new Interval(start, end));
        return result;
    }

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    /**
     * 搜索旋转排序数组
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {

    }
    private int binaryMiddle(int[] nums){
        int lo = 0, hi = nums.length-1;
        while (lo<=hi){
            int mi
        }
    }
}
