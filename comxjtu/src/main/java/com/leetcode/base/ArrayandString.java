package com.leetcode.base;

/**
 * @Author: Jay
 * @Date: Created in 13:05 2018/8/22
 * @Modified By:
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 对角线遍历，螺旋矩阵
 */
public class ArrayandString {

    public int pivotIndex(int[] nums) {
        int sum = 0, left = 0;
        for (int i = 0; i < nums.length; i++) sum += nums[i];

        for (int i = 0; i < nums.length; i++) {
            if (i != 0) left += nums[i - 1];
            if (sum - left - nums[i] == left) return i;
        }

        return -1;
    }

    public int dominantIndex(int[] nums) {
        if (nums.length<1) return -1;
        int max=Integer.MIN_VALUE,index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>max){
                max = nums[i];
                index = i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (index==i) continue;
            if (max<2*nums[i]){
                return -1;
            }
        }
        return index;
    }

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];
        int m = matrix.length, n = matrix[0].length;

        int[] result = new int[m * n];
        int row = 0, col = 0, d = 0;
        int[][] dirs = {{-1, 1}, {1, -1}};

        for (int i = 0; i < m * n; i++) {
            result[i] = matrix[row][col];
            row += dirs[d][0];
            col += dirs[d][1];

            if (row >= m) { row = m - 1; col += 2; d = 1 - d;}
            if (col >= n) { col = n - 1; row += 2; d = 1 - d;}
            if (row < 0)  { row = 0; d = 1 - d;}
            if (col < 0)  { col = 0; d = 1 - d;}
        }

        return result;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix==null||matrix.length<1) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int m = matrix.length, n= matrix[0].length;

        int row = 0, col = 0, d = 0,xc=0,yc=0;
        int[][] dirs = {{0, 1}, {1, 0},{0,-1},{-1,0}};

        for (int i = 0; i < m*n; i++) {
            System.out.println(i);
            System.out.println(row+" "+col);
            list.add(matrix[row][col]);
            row += dirs[d][0];
            col += dirs[d][1];

            if (d==0 && col>=n-yc){
                col = n-yc-1;row += 1;d=1;
                continue;
            }
            if (d==1 && row>=m-xc){
                row = m-xc-1; col -= 1;d=2;
                continue;
            }
            if (d==2 && col<=yc){
                col = yc;row -= 1;d=3;
                xc++;
                continue;
            }
            if (d==3 && row<=xc){
                row = xc;col += 1;d=0;
                yc++;
                continue;
            }
        }
        return list;
    }

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() -1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }

    public int arrayPairSum(int[] nums) {
        if (nums==null || nums.length==0) return 0;
        Arrays.sort(nums);
        int sum=0;
        for (int i = 0; i < nums.length; i=i+2) {
            sum += nums[i];
        }
        return sum;
    }

    public int[] twoSum(int[] num, int target) {
        int[] indice = new int[2];
        if (num == null || num.length < 2) return indice;
        int left = 0, right = num.length - 1;
        while (left < right) {
            int v = num[left] + num[right];
            if (v == target) {
                indice[0] = left + 1;
                indice[1] = right + 1;
                break;
            } else if (v > target) {
                right --;
            } else {
                left ++;
            }
        }
        return indice;
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums==null || nums.length ==0) return 0;
        int ans = 0 , tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==1){
                tmp++;
            }else {
                if (tmp>ans) ans = tmp;
                tmp=0;
            }
        }
        return ans>tmp?ans:tmp;
    }

    public int minSubArrayLen(int s, int[] a) {
        if (a == null || a.length == 0)
            return 0;

        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;

        while (j < a.length) {
            sum += a[j++];

            while (sum >= s) {
                min = Math.min(min, j - i);
                sum -= a[i++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args){
        String str = "flower";
        System.out.println("flow".indexOf(str));
        System.out.println(str.substring(0,str.length()-1));
    }
}
