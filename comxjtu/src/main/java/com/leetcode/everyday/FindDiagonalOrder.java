package com.leetcode.everyday;

/**
 * @author JS
 * @version 1.0
 * @date 2022/6/14 15:04
 * @description //498. 对角线遍历
 */
public class FindDiagonalOrder {

    /**
     *
     * @Param
     * @Description 分三步：起点到左下至右上、右上至左下，确定什么时候变方向。
     * @Date 15:05 2022/6/14
     * @return
     **/
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n=mat[0].length;
        int[] ans = new int[m*n];
        ans[0] = mat[0][0];
        int index= 0, i= 0, j=0;

        while (i<m || j<n){
            //      左下至右上,从i,j开始
            while (i>=0 && j<n){
                ans[index++] = mat[i--][j++];
            }
            if (i+1 == m-1 && j-1 == n-1)break;
            //                改变方向
            if (j==n){
                i=i+2;
                j=j-1;
            }else{
                i = i+1;
            }
            //右上至左下
            while (i<m && j>=0 ){
                ans[index++] = mat[i++][j--];
            }
            if (i+1 == m-1 && j-1 == n-1)break;
            if (i==m){
                i=i-1;
                j=j+2;
            }else {
                j=j+1;
            }
        }
        return ans;
    }
}
