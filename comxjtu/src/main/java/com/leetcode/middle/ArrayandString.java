package com.leetcode.middle;

import java.util.*;

/**
 * @Author: Jay
 * @Date: Created in 17:58 2018/6/8
 * @Modified By:
 */
public class ArrayandString {
    /**
     * 三数之和
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {

        if (nums.length < 3)
            return Collections.emptyList();
        List<List<Integer>> res = new ArrayList<>();
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        int negSize = 0;
        int posSize = 0;
        int zeroSize = 0;
        for (int v : nums) {
            if (v < minValue)
                minValue = v;
            if (v > maxValue)
                maxValue = v;
            if (v > 0)
                posSize++;
            else if (v < 0)
                negSize++;
            else
                zeroSize++;
        }
        if (zeroSize >= 3)
            res.add(Arrays.asList(0, 0, 0));
        if (negSize == 0 || posSize == 0)
            return res;
        if (minValue * 2 + maxValue > 0)
            maxValue = -minValue * 2;
        else if (maxValue * 2 + minValue < 0)
            minValue = -maxValue * 2;

        int[] map = new int[maxValue - minValue + 1];
        int[] negs = new int[negSize];
        int[] poses = new int[posSize];
        negSize = 0;
        posSize = 0;
        for (int v : nums) {
            if (v >= minValue && v <= maxValue) {
                if (map[v - minValue]++ == 0) {
                    if (v > 0)
                        poses[posSize++] = v;
                    else if (v < 0)
                        negs[negSize++] = v;
                }
            }
        }
        Arrays.sort(poses, 0, posSize);
        Arrays.sort(negs, 0, negSize);
        int basej = 0;
        for (int i = negSize - 1; i >= 0; i--) {
            int nv = negs[i];
            int minp = (-nv) >>> 1;
            while (basej < posSize && poses[basej] < minp)
                basej++;
            for (int j = basej; j < posSize; j++) {
                int pv = poses[j];
                int cv = 0 - nv - pv;
                if (cv >= nv && cv <= pv) {
                    if (cv == nv) {
                        if (map[nv - minValue] > 1)
                            res.add(Arrays.asList(nv, nv, pv));
                    } else if (cv == pv) {
                        if (map[pv - minValue] > 1)
                            res.add(Arrays.asList(nv, pv, pv));
                    } else {
                        if (map[cv - minValue] > 0)
                            res.add(Arrays.asList(nv, cv, pv));
                    }
                } else if (cv < nv)
                    break;
            }
        }
        return res;

    }

    /**
     * 字谜分组:给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new LinkedList<>();
        if (strs==null || strs.length==0) return list;
        Map<String,List<String>> map = new HashMap();
        for (String str :
                strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String tmp = String.valueOf(chars);
            if (map.containsKey(tmp)) {
                List<String> l = map.get(tmp);
                l.add(str);
                map.put(tmp,l);
            }else {
                List<String> l = new LinkedList<>();
                l.add(str);
                map.put(tmp,l);
            }
        }
        for (List l :
                map.values()) {
            list.add(l);
        }
        return list;
    }

    /**
     * 无重复字符的最长子串:给定一个字符串，找出不含有重复字符的最长子串的长度。
     * http://baijiahao.baidu.com/s?id=1596959005481205984&wfr=spider&for=pc
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {

        int max=0;
        int count=0;

        char[] c=s.toCharArray();
        for(int i=0;i<c.length;i++){

            for(int j=count;j<i;j++){
                if(c[i]==c[j]){
                    count=j+1;
                    break;
                }
            }
            max=Math.max(max,i-count+1);
        }
        return max;

    }

    /**
     * 矩阵置零：给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。
     * 使用常数空间。
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        // 第一行被设置的标志
        boolean rowFlag = false;
        // 第一列被设置的标志
        boolean colFlag = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    // 标记第一行要被设置
                    if (i == 0) {
                        rowFlag = true;
                    }

                    // 标记第一列要被设置
                    if (j == 0){
                        colFlag = true;
                    }

                    // 在行列在标记要设置为0的行和列
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // 对第二行第二列开始的元素设置0
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 设置第一行为0
        if (rowFlag) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }

        // 设置第一列为0
        if (colFlag) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

    }

    public static void main(String[] args){
        ArrayandString as = new ArrayandString();
        List<List<String>> list = as.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        for (List<String> l :
                list) {
            for (String s :
                    l) {
                System.out.print(s);
            }
            System.out.println("***");
        }
    }
}
