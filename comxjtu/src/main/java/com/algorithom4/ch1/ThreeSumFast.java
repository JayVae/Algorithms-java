package com.algorithom4.ch1;

import java.io.IOException;
import java.util.Arrays;

/**
 * @Author: Jay
 * @Date: Created in 22:03 2018/5/17
 * @Modified By:
 */
/*
用排序+二分查找处理：找出一个数组中三个数之和为0的所有情况。
 */
public class ThreeSumFast {

    public int countSum(int[] a){
        int count = 0;
        Arrays.sort(a);

        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                if(binarySearch(a,-a[i]-a[j])>j)
                    count++;
            }
        }
        return count;
    }

    public static int binarySearch(int[] arr, int s){
        int lo = 0,hi = arr.length-1;
        int res = -1;
        while (lo <= hi){
            int mid = (hi+lo)/2;
            if (arr[mid] < s) lo = mid;
            else if (arr[mid] > s) hi = mid;
            else return mid;
            if(hi==(lo+1)) return res;
            System.out.println(arr[hi]+"%%"+arr[lo]+"hi"+hi+lo);
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();    //获取开始时间
        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> inList = new ArrayList<Integer>();
        String line = null;
        int lineNo = 0;
        int count =1;
        while((line = br.readLine())!= null){
            if(lineNo==0){
                int tmp = Integer.parseInt(line);
                count = Integer.parseInt(line);
            }else {
                inList.add(Integer.parseInt(line));
            }
            lineNo++;
            if ((lineNo-1)==count)
                break;
        }

        int[] arr = (int[]) inList.toArray();*/

        int[] arr = new int[]{1,3,5,7,10,60,100,500,510,511,1000};
        int res = binarySearch(arr,400);
        System.out.println(res);

        long endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间

    }

}
