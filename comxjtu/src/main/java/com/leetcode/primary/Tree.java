package com.leetcode.primary;

/**
 * @Author: Jay
 * @Date: Created in 9:18 2018/5/31
 * @Modified By:
 */
public class Tree {
    /**
     * 给定一个二叉树，找出其最大深度。
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root==null) return 0;
        return  maxDepth2(root);
    }
    private int maxDepth2(TreeNode root){
        if (root==null) return 0;
        int h1 = maxDepth2(root.left);
        int h2 = maxDepth2(root.right);
        int height = h1>h2?h1:h2;
        return height+1;
    }

    public boolean isValidBST(TreeNode root) {
        if (root==null) return true;
        return isValid(root);
    }
    private boolean isValid(TreeNode root){
        return false;
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
