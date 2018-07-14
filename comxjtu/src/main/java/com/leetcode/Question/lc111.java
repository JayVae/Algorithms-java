package com.leetcode.Question;

/**
 * @Author: Jay
 * @Date: Created in 17:39 2018/7/14
 * @Modified By:
 */
public class lc111 {

    public int minDepth(TreeNode root) {
        if (root==null) return 0;
        int l = minDepth(root.left);
        int r = minDepth(root.right);
        if (l==0){
            return r+1;
        }
        if (r==0){
            return l+1;
        }
        return Math.min(l,r)+1;


    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
